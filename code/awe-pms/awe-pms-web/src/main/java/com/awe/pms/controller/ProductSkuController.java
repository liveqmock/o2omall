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
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.awe.pms.service.ProductSkuService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductSkuController ：商品SKU控制器
 * 
 * @author ljz
 * @version 2014-12-25 14:47:32
*/
@Controller
@RequestMapping("productSku")
public class ProductSkuController extends BaseController {

    @Autowired
    private ProductSkuService productSkuService;

    /** 视图前缀 */
    private static final String viewPrefix ="productSku";
    
    private static final Log LOG = LogFactory.getLog(ProductSkuController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductSkuQuery query) {
        try {
            List<ProductSku> dataList = productSkuService.queryProductSkuListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productSku index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商品SKU----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商品SKU----添加
     * 
     * @param productSku
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductSku productSku) {
        try {
            productSku.setCreateUser(getLoginUserCnName());
            if (productSkuService.insert(productSku)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productSku add fail, exist productSku.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productSku add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商品SKU----更新跳转
     * 
     * @param model
     * @param productSku
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductSku productSku) {
        try {
            ProductSku productSkuResult = productSkuService.getProductSkuById(productSku.getId());
            model.addAttribute("productSku", productSkuResult);
        } catch (Exception e) {
            LOG.error("productSku updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商品SKU----更新
     * 
     * @param model
     * @param productSku
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductSku productSku) {
        try {
            productSku.setUpdateUser(getLoginUserCnName());
            if (productSkuService.update(productSku)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productSku update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品SKU----删除
     * 
     * @param productSku
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductSku productSku) {
        try {
            productSku.setUpdateUser(getLoginUserCnName());
            if (productSkuService.delete(productSku)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productSku delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品SKU----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductSkuQuery query) {
        try {
            List<ProductSku> list = productSkuService.queryProductSkuList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productSku query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商品SKU详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductSkuQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductSku productSku = productSkuService.getProductSkuById(query.getId());
            if (productSku != null) {
                return new Wrapper<ProductSku>().result(productSku);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商品SKU详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productSku has error.", e);
            return error();
        }
    }
}
