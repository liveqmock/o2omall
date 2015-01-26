package com.awe.rems.controller;
   

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

import com.awe.rems.controller.base.BaseController;
import com.awe.rems.domain.Refund;
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.RefundQuery;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.enums.AuditStatusEnum;
import com.awe.rems.service.RefundService;
import com.awe.rems.service.ReturnExchangeService;
import com.awe.rems.service.ServiceAuditService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ServiceAuditController ：退换货审核流表控制器
 * 
 * @author zyq
 * @version 2014-12-25 9:16:22
*/
@Controller
@RequestMapping("serviceAudit")
public class ServiceAuditController extends BaseController {

    @Autowired
    private ServiceAuditService serviceAuditService;
    @Autowired
    private ReturnExchangeService returnExchangeService;
    @Autowired
    private RefundService refundService;
    
    /** 视图前缀 */
    private static final String viewPrefix ="serviceAudit";
    
    private static final Log LOG = LogFactory.getLog(ServiceAuditController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ServiceAuditQuery query) {
        try {
            List<ServiceAudit> dataList = serviceAuditService.queryServiceAuditListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
            model.addAttribute("AuditStatusMap", AuditStatusEnum.getMap());
            model.addAttribute("AuditStatusDataList", AuditStatusEnum.getDataList());
        } catch (Exception e) {
            LOG.error("serviceAudit index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 退换货审核流表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 退换货审核流表----添加
     * 
     * @param serviceAudit
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ServiceAudit serviceAudit) {
        try {
            serviceAudit.setCreateUser(getLoginUserCnName());
            if (serviceAuditService.insert(serviceAudit)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("serviceAudit add fail, exist serviceAudit.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("serviceAudit add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 退换货审核流表----更新跳转
     * 
     * @param model
     * @param serviceAudit
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ServiceAudit serviceAudit) {
        try {
            ServiceAudit serviceAuditResult = serviceAuditService.getServiceAuditById(serviceAudit.getId());
            model.addAttribute("serviceAudit", serviceAuditResult);
        } catch (Exception e) {
            LOG.error("serviceAudit updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 退换货审核流表----更新
     * 
     * @param model
     * @param serviceAudit
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ServiceAudit serviceAudit) {
        try {
            serviceAudit.setUpdateUser(getLoginUserCnName());
            if (serviceAuditService.update(serviceAudit)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("serviceAudit update has error.", e);
            return WrapMapper.error();
        }
    }


    /**
     * 退换货审核流表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ServiceAuditQuery query) {
        try {
            List<ServiceAudit> list = serviceAuditService.queryServiceAuditList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("serviceAudit query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询退换货审核流表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ServiceAuditQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ServiceAudit serviceAudit = serviceAuditService.getServiceAuditById(query.getId());
            if (serviceAudit != null) {
                return new Wrapper<ServiceAudit>().result(serviceAudit);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询退换货审核流表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail serviceAudit has error.", e);
            return error();
        }
    }
    /***
     * @descripton:获取售后服务申请单信息
     * @param query
     * @return
     */
    @RequestMapping(value = "toAudit", method = RequestMethod.GET)
    public String toAudit(Model model,ServiceAuditQuery query){
    	//获取return_exchange表数据
    	try {
    		ReturnExchange re = returnExchangeService.getReturnExchangeByServiceNo(query.getServiceNo());
    		List<ServiceAudit> auditDataList = serviceAuditService.queryServiceAuditList(query);
    		RefundQuery bean = new RefundQuery();
    		bean.setServiceNo(query.getServiceNo());
    		Refund refund = refundService.getRefundByBean(bean);
    		model.addAttribute("ReturnExchange", re);
    		model.addAttribute("ServiceAuditList", auditDataList);
    		model.addAttribute("Refund", refund);
		} catch (Exception e) {
			LOG.error("serviceAudit getApply has error.", e);
		}
    	return viewPrefix + "/applyDetail";
    }
    /**
     * @description:售后审核
     * @param query
     */
    @RequestMapping(value = "doAudit", method = RequestMethod.POST)
    public Wrapper<?> doAudit(ServiceAudit serviceAudit){
    	if(null == serviceAudit){
    		return WrapMapper.wrap(Wrapper.ILLEGAL_ARGUMENT_CODE_, "售后审核参数为空!");
    	}
    	try {
    		if(serviceAuditService.update(serviceAudit)){
    			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "审核成功!");
    		}else{
    			return WrapMapper.wrap(Wrapper.ERROR_CODE, "审核失败!");
    		}
		} catch (Exception e) {
			LOG.error("#售后审核异常:" + e.getMessage());
			return WrapMapper.error();
		}
    }
}
