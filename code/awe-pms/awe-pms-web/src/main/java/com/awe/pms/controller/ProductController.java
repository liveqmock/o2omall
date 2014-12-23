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
import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.service.ProductService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductController ：商品信息控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
*/
@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    /** 视图前缀 */
    private static final String viewPrefix ="product";
    
    private static final Log LOG = LogFactory.getLog(ProductController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductQuery query) {
        try {
            List<Product> dataList = productService.queryProductListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("product index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商品信息----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商品信息----添加
     * 
     * @param product
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Product product) {
        try {
            product.setCreateUser(getLoginUserCnName());
            if (productService.insert(product)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("product add fail, exist product.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("product add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商品信息----更新跳转
     * 
     * @param model
     * @param product
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Product product) {
        try {
            Product productResult = productService.getProductById(product.getId());
            model.addAttribute("product", productResult);
        } catch (Exception e) {
            LOG.error("product updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商品信息----更新
     * 
     * @param model
     * @param product
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Product product) {
        try {
            product.setUpdateUser(getLoginUserCnName());
            if (productService.update(product)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("product update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品信息----删除
     * 
     * @param product
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Product product) {
        try {
            product.setUpdateUser(getLoginUserCnName());
            if (productService.delete(product)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("product delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductQuery query) {
        try {
            List<Product> list = productService.queryProductList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("product query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商品信息详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Product product = productService.getProductById(query.getId());
            if (product != null) {
                return new Wrapper<Product>().result(product);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商品信息详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail product has error.", e);
            return error();
        }
    }
}
