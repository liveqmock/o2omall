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
import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
import com.awe.pms.service.ProductDictService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductDictController ：配置表控制器
 * 
 * @author ljz
 * @version 2014-12-25 14:47:32
*/
@Controller
@RequestMapping("productDict")
public class ProductDictController extends BaseController {

    @Autowired
    private ProductDictService productDictService;

    /** 视图前缀 */
    private static final String viewPrefix ="productDict";
    
    private static final Log LOG = LogFactory.getLog(ProductDictController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductDictQuery query) {
        try {
            List<ProductDict> dataList = productDictService.queryProductDictListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productDict index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 配置表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 配置表----添加
     * 
     * @param productDict
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductDict productDict) {
        try {
            productDict.setCreateUser(getLoginUserCnName());
            if (productDictService.insert(productDict)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productDict add fail, exist productDict.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productDict add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 配置表----更新跳转
     * 
     * @param model
     * @param productDict
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductDict productDict) {
        try {
            ProductDict productDictResult = productDictService.getProductDictById(productDict.getId());
            model.addAttribute("productDict", productDictResult);
        } catch (Exception e) {
            LOG.error("productDict updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 配置表----更新
     * 
     * @param model
     * @param productDict
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductDict productDict) {
        try {
            productDict.setUpdateUser(getLoginUserCnName());
            if (productDictService.update(productDict)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productDict update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 配置表----删除
     * 
     * @param productDict
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductDict productDict) {
        try {
            productDict.setUpdateUser(getLoginUserCnName());
            if (productDictService.delete(productDict)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productDict delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 配置表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductDictQuery query) {
        try {
            List<ProductDict> list = productDictService.queryProductDictList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productDict query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询配置表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductDictQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductDict productDict = productDictService.getProductDictById(query.getId());
            if (productDict != null) {
                return new Wrapper<ProductDict>().result(productDict);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productDict has error.", e);
            return error();
        }
    }
}
