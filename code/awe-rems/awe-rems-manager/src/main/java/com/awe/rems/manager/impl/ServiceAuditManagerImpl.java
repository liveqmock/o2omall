package com.awe.rems.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awe.rems.dao.RefundDao;
import com.awe.rems.dao.ReturnExchangeDao;
import com.awe.rems.dao.ServiceAuditDao;
import com.awe.rems.domain.Refund;
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.constant.CommonConstant;
import com.awe.rems.domain.query.RefundQuery;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.manager.ServiceAuditManager;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;

/**
 * ServiceAuditManager接口的实现类
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Component
public class ServiceAuditManagerImpl extends BaseManager implements ServiceAuditManager {
	
    @Autowired
    private ServiceAuditDao serviceAuditDao;
    @Autowired
    private ReturnExchangeDao returnExchangeDao;
    @Autowired
    private RefundDao refundDao;
    
    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ServiceAudit> serviceAuditList) {
        boolean resultFlag = false;
        if (null != serviceAuditList && serviceAuditList.size() > 0) {
            for (ServiceAudit serviceAudit : serviceAuditList) {
                resultFlag = serviceAuditDao.insert(serviceAudit);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ServiceAudit serviceAudit) {
        return serviceAuditDao.insert(serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ServiceAudit serviceAudit) {
        return serviceAuditDao.update(serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean) {
        return serviceAuditDao.queryServiceAuditList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ServiceAuditQuery();
        }

        // 查询总数
        int totalItem = queryServiceAuditCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return serviceAuditDao.queryServiceAuditListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryServiceAuditCount(ServiceAuditQuery queryBean) {
        return serviceAuditDao.queryServiceAuditCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public ServiceAudit getServiceAuditById(Long id) {
        return serviceAuditDao.getServiceAuditById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(ServiceAudit serviceAudit) {
        return serviceAuditDao.exist(serviceAudit);
    }
    /**
     * {@inheritDoc}
     */
	public ServiceAudit getServiceAuditByBean(ServiceAudit serviceAudit) {
		return serviceAuditDao.getServiceAuditByBean(serviceAudit);
	}
	/**
     * {@inheritDoc}
     */
	public boolean audit(ServiceAudit serviceAudit) {
		boolean auditRet = insert(serviceAudit);
		if(auditRet && serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.REFUND_SUBMIT_STATUS){
			Refund refund = new Refund();
			refund.setBusinessName(serviceAudit.getBusinessName());
			refund.setBusinessNo(serviceAudit.getBusinessNo());
			refund.setOrderNo(serviceAudit.getOrderNo());
			refund.setReturnExchangeId(serviceAudit.getReturnExchangeId());
			refund.setStatus(serviceAudit.getStatus());
			refund.setServiceNo(serviceAudit.getServiceNo());
			refund.setUpdateUser(serviceAudit.getUpdateUser());
			refund.setCreateUser(serviceAudit.getCreateUser());
			refund.setUpdateUserId(serviceAudit.getUpdateUserId());
			refund.setCreateUserId(serviceAudit.getCreateUserId());
			refund.setUserId(serviceAudit.getUserId());
			refundDao.insert(refund);
		}
		if(auditRet && (serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.COMPLETE_STATUS
				|| serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.AUDIT_FAIL_STATUS)){
			RefundQuery queryBean = new RefundQuery();
			queryBean.setServiceNo(serviceAudit.getServiceNo());
			Refund refund = refundDao.getRefundByBean(queryBean);
			boolean ret = refundDao.update(refund);
		}
		if(auditRet && (serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.AUDIT_SUCCESS_STATUS
				|| serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.REFUND_SUBMIT_STATUS
				|| serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.COMPLETE_STATUS
				|| serviceAudit.getStatus() == CommonConstant.ReturnExchangeStatus.AUDIT_FAIL_STATUS)){
			ReturnExchange returnExchange = returnExchangeDao.getReturnExchangeByServiceNo(serviceAudit.getServiceNo());
			boolean ret = returnExchangeDao.update(returnExchange);
		}
		return auditRet;
	}
}
