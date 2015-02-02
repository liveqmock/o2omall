package com.awe.rems.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.constant.CommonConstant;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.manager.ReturnExchangeManager;
import com.awe.rems.manager.ServiceAuditManager;
import com.awe.rems.service.ServiceAuditService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
 
/**
 * ServiceAuditService接口的实现类
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Service
public class ServiceAuditServiceImpl implements ServiceAuditService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ServiceAuditServiceImpl.class);

    @Autowired
    private ServiceAuditManager serviceAuditManager;
    @Autowired
    private ReturnExchangeManager returnExchangeManager;
    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.batchInsert")
    public boolean insert(List<ServiceAudit> serviceAuditList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(serviceAuditList)) {
                resultFlag = serviceAuditManager.insert(serviceAuditList);
            } else {
                LOG.warn("ServiceAuditServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.insert")
    public boolean insert(ServiceAudit serviceAudit) {
        boolean resultFlag = false;
        try {
            if (null != serviceAudit) {
                if (serviceAuditManager.exist(serviceAudit)) {
                    throw new ExistedException();
                }
                resultFlag = serviceAuditManager.insert(serviceAudit);
            } else {
                LOG.warn("ServiceAuditServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ServiceAuditServiceImpl#insert failed, serviceAudit has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.update")
    public boolean update(ServiceAudit serviceAudit) {
        boolean resultFlag = false;
        try {
            if (null != serviceAudit && null != serviceAudit.getId()) {
                resultFlag = serviceAuditManager.update(serviceAudit);
            } else {
                LOG.warn("ServiceAuditServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.queryServiceAuditList")
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean) {
        List<ServiceAudit> serviceAuditList = null;
        try {
            serviceAuditList = serviceAuditManager.queryServiceAuditList(queryBean);
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#queryServiceAuditList has error.", e);
        }
        return serviceAuditList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.queryServiceAuditListWithPage")
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean, PageUtil pageUtil) {
        List<ServiceAudit> serviceAuditList = null;
        try {
            serviceAuditList = serviceAuditManager.queryServiceAuditListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#queryServiceAuditListWithPage has error.", e);
        }
        return serviceAuditList;
    }


    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.getServiceAuditById")
    public ServiceAudit getServiceAuditById(Long id) {
        ServiceAudit serviceAudit = null;
        try {
            if (null != id) {
                serviceAudit = serviceAuditManager.getServiceAuditById(id);
            } else {
                LOG.warn("ServiceAuditServiceImpl#getServiceAuditById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#getServiceAuditById has error.", e);
        }
        return serviceAudit;
    }

	public boolean audit(ServiceAudit serviceAudit) {
		if(null == serviceAudit.getStatus() || null == serviceAudit.getServiceNo()){
			LOG.warn("ServiceAuditServiceImpl#audit failed, serviceAudit`s status or serviceNo is null");
			return false;
		}
		//ServiceAudit _serviceAudit = getServiceAuditByBean(serviceAudit);
		ReturnExchange returnExchange = returnExchangeManager.getReturnExchangeByServiceNo(serviceAudit.getServiceNo());
		switch (returnExchange.getServiceAuditStatus()) {
		case CommonConstant.ReturnExchangeStatus.USER_SUBMIT_STATUS:
			serviceAudit = saveAudit(serviceAudit,CommonConstant.ReturnExchangeStatus.AUDIT_SUCCESS_STATUS);
			break;
		case CommonConstant.ReturnExchangeStatus.AUDIT_SUCCESS_STATUS:
			serviceAudit = saveAudit(serviceAudit,CommonConstant.ReturnExchangeStatus.REFUND_SUBMIT_STATUS);
			break;
		case CommonConstant.ReturnExchangeStatus.REFUND_SUBMIT_STATUS:
			serviceAudit = saveAudit(serviceAudit,CommonConstant.ReturnExchangeStatus.COMPLETE_STATUS);
			break;
		case CommonConstant.ReturnExchangeStatus.COMPLETE_STATUS:
			break;
		}
		//todo...
		return true;
	}

	private ServiceAudit saveAudit(ServiceAudit serviceAudit,int status){
		if(serviceAudit.getStatus() == CommonConstant.AuditStatus.AUDIT_AGREE_STATUS){
			serviceAudit.setStatus(status);
		} else if(serviceAudit.getStatus() == CommonConstant.AuditStatus.AUDIT_DISAGREE_STATUS){
			serviceAudit.setStatus(CommonConstant.ReturnExchangeStatus.AUDIT_FAIL_STATUS);
		}
		return serviceAudit;
	}
	
	public ServiceAudit getServiceAuditByBean(ServiceAudit serviceAudit) {
		ServiceAudit _serviceAudit = null;
        try {
            if (null != serviceAudit && null != serviceAudit.getServiceNo()) {
            	_serviceAudit = serviceAuditManager.getServiceAuditByBean(serviceAudit);
            } else {
                LOG.warn("ServiceAuditServiceImpl#getServiceAuditByBean failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#getServiceAuditByBean  has error.", e);
        }
        return _serviceAudit;
	}
}

