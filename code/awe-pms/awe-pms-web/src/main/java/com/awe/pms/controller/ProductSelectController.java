package com.awe.pms.controller;
   

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.pms.controller.base.BaseController;
import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.awe.pms.service.ProductSelectService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductSelectController ：商品查询综合表控制器
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
*/
@Controller
@RequestMapping("productSelect")
public class ProductSelectController extends BaseController {

    @Autowired
    private ProductSelectService productSelectService;

    /** 视图前缀 */
    private static final String viewPrefix ="productSelect";
    
    private static final Log LOG = LogFactory.getLog(ProductSelectController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductSelectQuery query) {
        try {
            List<ProductSelect> dataList = productSelectService.queryProductSelectListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productSelect index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商品查询综合表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商品查询综合表----添加
     * 
     * @param productSelect
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductSelect productSelect) {
        try {
            productSelect.setCreateUser(getLoginUserCnName());
            if (productSelectService.insert(productSelect)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productSelect add fail, exist productSelect.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productSelect add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商品查询综合表----更新跳转
     * 
     * @param model
     * @param productSelect
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductSelect productSelect) {
        try {
            ProductSelect productSelectResult = productSelectService.getProductSelectById(productSelect.getId());
            model.addAttribute("productSelect", productSelectResult);
        } catch (Exception e) {
            LOG.error("productSelect updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商品查询综合表----更新
     * 
     * @param model
     * @param productSelect
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductSelect productSelect) {
        try {
            productSelect.setUpdateUser(getLoginUserCnName());
            if (productSelectService.update(productSelect)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productSelect update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品查询综合表----删除
     * 
     * @param productSelect
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductSelect productSelect) {
        try {
            productSelect.setUpdateUser(getLoginUserCnName());
            if (productSelectService.delete(productSelect)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productSelect delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品查询综合表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductSelectQuery query) {
        try {
            List<ProductSelect> list = productSelectService.queryProductSelectList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productSelect query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商品查询综合表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductSelectQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductSelect productSelect = productSelectService.getProductSelectById(query.getId());
            if (productSelect != null) {
                return new Wrapper<ProductSelect>().result(productSelect);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商品查询综合表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productSelect has error.", e);
            return error();
        }
    }
}
