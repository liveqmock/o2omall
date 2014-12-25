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
import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.awe.pms.service.ProductBrandService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductBrandController ：商品类别品牌控制器
 * 
 * @author ljz
 * @version 2014-12-25 9:31:55
*/
@Controller
@RequestMapping("productBrand")
public class ProductBrandController extends BaseController {

    @Autowired
    private ProductBrandService productBrandService;

    /** 视图前缀 */
    private static final String viewPrefix ="productBrand";
    
    private static final Log LOG = LogFactory.getLog(ProductBrandController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductBrandQuery query) {
        try {
            List<ProductBrand> dataList = productBrandService.queryProductBrandListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productBrand index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商品类别品牌----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商品类别品牌----添加
     * 
     * @param productBrand
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductBrand productBrand) {
        try {
            productBrand.setCreateUser(getLoginUserCnName());
            if (productBrandService.insert(productBrand)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productBrand add fail, exist productBrand.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productBrand add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商品类别品牌----更新跳转
     * 
     * @param model
     * @param productBrand
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductBrand productBrand) {
        try {
            ProductBrand productBrandResult = productBrandService.getProductBrandById(productBrand.getId());
            model.addAttribute("productBrand", productBrandResult);
        } catch (Exception e) {
            LOG.error("productBrand updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商品类别品牌----更新
     * 
     * @param model
     * @param productBrand
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductBrand productBrand) {
        try {
            productBrand.setUpdateUser(getLoginUserCnName());
            if (productBrandService.update(productBrand)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productBrand update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品类别品牌----删除
     * 
     * @param productBrand
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductBrand productBrand) {
        try {
            productBrand.setUpdateUser(getLoginUserCnName());
            if (productBrandService.delete(productBrand)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productBrand delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商品类别品牌----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductBrandQuery query) {
        try {
            List<ProductBrand> list = productBrandService.queryProductBrandList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productBrand query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商品类别品牌详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductBrandQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductBrand productBrand = productBrandService.getProductBrandById(query.getId());
            if (productBrand != null) {
                return new Wrapper<ProductBrand>().result(productBrand);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商品类别品牌详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productBrand has error.", e);
            return error();
        }
    }
}
