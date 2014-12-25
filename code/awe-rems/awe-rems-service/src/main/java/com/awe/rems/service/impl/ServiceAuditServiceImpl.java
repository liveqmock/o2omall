package com.awe.rems.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.manager.ServiceAuditManager;
import com.awe.rems.service.ServiceAuditService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ServiceAuditService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
@Service
public class ServiceAuditServiceImpl implements ServiceAuditService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ServiceAuditServiceImpl.class);

    @Autowired
    private ServiceAuditManager serviceAuditManager;

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
    @Profiled(tag = "ServiceAuditService.delete")
    public boolean delete(ServiceAudit serviceAudit) {
        boolean resultFlag = false;
        try {
            if (null != serviceAudit && null != serviceAudit.getId()) {
                resultFlag = serviceAuditManager.delete(serviceAudit);
            } else {
                LOG.warn("ServiceAuditServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ServiceAuditService.batchDelete")
    public boolean delete(ServiceAudit[] serviceAudits) {
        boolean resultFlag = false;
        try {
            if (null != serviceAudits && serviceAudits.length > 0) {
                resultFlag = serviceAuditManager.delete(serviceAudits);
            } else {
                LOG.warn("ServiceAuditServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ServiceAuditServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
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
}

