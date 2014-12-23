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
import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;
import com.awe.pms.service.BusinessAuditService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * BusinessAuditController ：审核商家流水表控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
*/
@Controller
@RequestMapping("businessAudit")
public class BusinessAuditController extends BaseController {

    @Autowired
    private BusinessAuditService businessAuditService;

    /** 视图前缀 */
    private static final String viewPrefix ="businessAudit";
    
    private static final Log LOG = LogFactory.getLog(BusinessAuditController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, BusinessAuditQuery query) {
        try {
            List<BusinessAudit> dataList = businessAuditService.queryBusinessAuditListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("businessAudit index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 审核商家流水表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 审核商家流水表----添加
     * 
     * @param businessAudit
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(BusinessAudit businessAudit) {
        try {
            businessAudit.setCreateUser(getLoginUserCnName());
            if (businessAuditService.insert(businessAudit)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("businessAudit add fail, exist businessAudit.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("businessAudit add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 审核商家流水表----更新跳转
     * 
     * @param model
     * @param businessAudit
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, BusinessAudit businessAudit) {
        try {
            BusinessAudit businessAuditResult = businessAuditService.getBusinessAuditById(businessAudit.getId());
            model.addAttribute("businessAudit", businessAuditResult);
        } catch (Exception e) {
            LOG.error("businessAudit updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 审核商家流水表----更新
     * 
     * @param model
     * @param businessAudit
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, BusinessAudit businessAudit) {
        try {
            businessAudit.setUpdateUser(getLoginUserCnName());
            if (businessAuditService.update(businessAudit)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("businessAudit update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 审核商家流水表----删除
     * 
     * @param businessAudit
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(BusinessAudit businessAudit) {
        try {
            businessAudit.setUpdateUser(getLoginUserCnName());
            if (businessAuditService.delete(businessAudit)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("businessAudit delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 审核商家流水表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(BusinessAuditQuery query) {
        try {
            List<BusinessAudit> list = businessAuditService.queryBusinessAuditList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("businessAudit query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询审核商家流水表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(BusinessAuditQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            BusinessAudit businessAudit = businessAuditService.getBusinessAuditById(query.getId());
            if (businessAudit != null) {
                return new Wrapper<BusinessAudit>().result(businessAudit);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询审核商家流水表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail businessAudit has error.", e);
            return error();
        }
    }
}
