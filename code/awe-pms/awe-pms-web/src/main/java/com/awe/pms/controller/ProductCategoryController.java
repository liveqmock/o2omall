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
import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.awe.pms.service.ProductCategoryService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductCategoryController ：商品类别控制器
 * 
 * @author ljz
 * @version 2014-12-25 9:31:55
*/
@Controller
@RequestMapping("productCategory")
public class ProductCategoryController extends BaseController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /** 视图前缀 */
    private static final String viewPrefix ="productCategory";
    
    private static final Log LOG = LogFactory.getLog(ProductCategoryController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductCategoryQuery query) {
        try {
            List<ProductCategory> dataList = productCategoryService.queryProductCategoryListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productCategory index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商品类别----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商品类别----添加
     * 
     * @param productCategory
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductCategory productCategory) {
        try {
            productCategory.setCreateUser(getLoginUserCnName());
            if (productCategoryService.insert(productCategory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productCategory add fail, exist productCategory.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productCategory add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商品类别----更新跳转
     * 
     * @param model
     * @param productCategory
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductCategory productCategory) {
        try {
            ProductCategory productCategoryResult = productCategoryService.getProductCategoryById(productCategory.getId());
            model.addAttribute("productCategory", productCategoryResult);
        } catch (Exception e) {
            LOG.error("productCategory updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商品类别----更新
     * 
     * @param model
     * @param productCategory
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductCategory productCategory) {
        try {
            productCategory.setUpdateUser(getLoginUserCnName());
            if (productCategoryService.update(productCategory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productCategory update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品类别----删除
     * 
     * @param productCategory
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductCategory productCategory) {
        try {
            productCategory.setUpdateUser(getLoginUserCnName());
            if (productCategoryService.delete(productCategory)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productCategory delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品类别----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductCategoryQuery query) {
        try {
            List<ProductCategory> list = productCategoryService.queryProductCategoryList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productCategory query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商品类别详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductCategoryQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductCategory productCategory = productCategoryService.getProductCategoryById(query.getId());
            if (productCategory != null) {
                return new Wrapper<ProductCategory>().result(productCategory);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商品类别详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productCategory has error.", e);
            return error();
        }
    }
}
