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
import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.awe.pms.service.ProductTaxRateService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductTaxRateController ：税率控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
*/
@Controller
@RequestMapping("productTaxRate")
public class ProductTaxRateController extends BaseController {

    @Autowired
    private ProductTaxRateService productTaxRateService;

    /** 视图前缀 */
    private static final String viewPrefix ="productTaxRate";
    
    private static final Log LOG = LogFactory.getLog(ProductTaxRateController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ProductTaxRateQuery query) {
        try {
            List<ProductTaxRate> dataList = productTaxRateService.queryProductTaxRateListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("productTaxRate index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 税率----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 税率----添加
     * 
     * @param productTaxRate
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ProductTaxRate productTaxRate) {
        try {
            productTaxRate.setCreateUser(getLoginUserCnName());
            if (productTaxRateService.insert(productTaxRate)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("productTaxRate add fail, exist productTaxRate.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("productTaxRate add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 税率----更新跳转
     * 
     * @param model
     * @param productTaxRate
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ProductTaxRate productTaxRate) {
        try {
            ProductTaxRate productTaxRateResult = productTaxRateService.getProductTaxRateById(productTaxRate.getId());
            model.addAttribute("productTaxRate", productTaxRateResult);
        } catch (Exception e) {
            LOG.error("productTaxRate updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 税率----更新
     * 
     * @param model
     * @param productTaxRate
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ProductTaxRate productTaxRate) {
        try {
            productTaxRate.setUpdateUser(getLoginUserCnName());
            if (productTaxRateService.update(productTaxRate)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("productTaxRate update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 税率----删除
     * 
     * @param productTaxRate
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ProductTaxRate productTaxRate) {
        try {
            productTaxRate.setUpdateUser(getLoginUserCnName());
            if (productTaxRateService.delete(productTaxRate)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("productTaxRate delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 税率----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ProductTaxRateQuery query) {
        try {
            List<ProductTaxRate> list = productTaxRateService.queryProductTaxRateList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("productTaxRate query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询税率详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ProductTaxRateQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ProductTaxRate productTaxRate = productTaxRateService.getProductTaxRateById(query.getId());
            if (productTaxRate != null) {
                return new Wrapper<ProductTaxRate>().result(productTaxRate);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询税率详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail productTaxRate has error.", e);
            return error();
        }
    }
}
