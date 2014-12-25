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
import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;
import com.awe.pms.service.BusinessInfoService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * BusinessInfoController ：商家信息控制器
 * 
 * @author ljz
 * @version 2014-12-25 14:47:32
*/
@Controller
@RequestMapping("businessInfo")
public class BusinessInfoController extends BaseController {

    @Autowired
    private BusinessInfoService businessInfoService;

    /** 视图前缀 */
    private static final String viewPrefix ="businessInfo";
    
    private static final Log LOG = LogFactory.getLog(BusinessInfoController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, BusinessInfoQuery query) {
        try {
            List<BusinessInfo> dataList = businessInfoService.queryBusinessInfoListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("businessInfo index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 商家信息----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 商家信息----添加
     * 
     * @param businessInfo
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(BusinessInfo businessInfo) {
        try {
            businessInfo.setCreateUser(getLoginUserCnName());
            if (businessInfoService.insert(businessInfo)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("businessInfo add fail, exist businessInfo.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("businessInfo add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 商家信息----更新跳转
     * 
     * @param model
     * @param businessInfo
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, BusinessInfo businessInfo) {
        try {
            BusinessInfo businessInfoResult = businessInfoService.getBusinessInfoById(businessInfo.getId());
            model.addAttribute("businessInfo", businessInfoResult);
        } catch (Exception e) {
            LOG.error("businessInfo updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 商家信息----更新
     * 
     * @param model
     * @param businessInfo
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, BusinessInfo businessInfo) {
        try {
            businessInfo.setUpdateUser(getLoginUserCnName());
            if (businessInfoService.update(businessInfo)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("businessInfo update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商家信息----删除
     * 
     * @param businessInfo
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(BusinessInfo businessInfo) {
        try {
            businessInfo.setUpdateUser(getLoginUserCnName());
            if (businessInfoService.delete(businessInfo)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("businessInfo delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 商家信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(BusinessInfoQuery query) {
        try {
            List<BusinessInfo> list = businessInfoService.queryBusinessInfoList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("businessInfo query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询商家信息详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(BusinessInfoQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            BusinessInfo businessInfo = businessInfoService.getBusinessInfoById(query.getId());
            if (businessInfo != null) {
                return new Wrapper<BusinessInfo>().result(businessInfo);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询商家信息详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail businessInfo has error.", e);
            return error();
        }
    }
}
