package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;
import com.awe.pms.manager.BusinessAuditManager;
import com.awe.pms.service.BusinessAuditService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * BusinessAuditService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
@Service
public class BusinessAuditServiceImpl implements BusinessAuditService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(BusinessAuditServiceImpl.class);

    @Autowired
    private BusinessAuditManager businessAuditManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.batchInsert")
    public boolean insert(List<BusinessAudit> businessAuditList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(businessAuditList)) {
                resultFlag = businessAuditManager.insert(businessAuditList);
            } else {
                LOG.warn("BusinessAuditServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.insert")
    public boolean insert(BusinessAudit businessAudit) {
        boolean resultFlag = false;
        try {
            if (null != businessAudit) {
                if (businessAuditManager.exist(businessAudit)) {
                    throw new ExistedException();
                }
                resultFlag = businessAuditManager.insert(businessAudit);
            } else {
                LOG.warn("BusinessAuditServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("BusinessAuditServiceImpl#insert failed, businessAudit has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.update")
    public boolean update(BusinessAudit businessAudit) {
        boolean resultFlag = false;
        try {
            if (null != businessAudit && null != businessAudit.getId()) {
                resultFlag = businessAuditManager.update(businessAudit);
            } else {
                LOG.warn("BusinessAuditServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.queryBusinessAuditList")
    public List<BusinessAudit> queryBusinessAuditList(BusinessAuditQuery queryBean) {
        List<BusinessAudit> businessAuditList = null;
        try {
            businessAuditList = businessAuditManager.queryBusinessAuditList(queryBean);
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#queryBusinessAuditList has error.", e);
        }
        return businessAuditList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.queryBusinessAuditListWithPage")
    public List<BusinessAudit> queryBusinessAuditListWithPage(BusinessAuditQuery queryBean, PageUtil pageUtil) {
        List<BusinessAudit> businessAuditList = null;
        try {
            businessAuditList = businessAuditManager.queryBusinessAuditListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#queryBusinessAuditListWithPage has error.", e);
        }
        return businessAuditList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.delete")
    public boolean delete(BusinessAudit businessAudit) {
        boolean resultFlag = false;
        try {
            if (null != businessAudit && null != businessAudit.getId()) {
                resultFlag = businessAuditManager.delete(businessAudit);
            } else {
                LOG.warn("BusinessAuditServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.batchDelete")
    public boolean delete(BusinessAudit[] businessAudits) {
        boolean resultFlag = false;
        try {
            if (null != businessAudits && businessAudits.length > 0) {
                resultFlag = businessAuditManager.delete(businessAudits);
            } else {
                LOG.warn("BusinessAuditServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessAuditService.getBusinessAuditById")
    public BusinessAudit getBusinessAuditById(Long id) {
        BusinessAudit businessAudit = null;
        try {
            if (null != id) {
                businessAudit = businessAuditManager.getBusinessAuditById(id);
            } else {
                LOG.warn("BusinessAuditServiceImpl#getBusinessAuditById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessAuditServiceImpl#getBusinessAuditById has error.", e);
        }
        return businessAudit;
    }
}

