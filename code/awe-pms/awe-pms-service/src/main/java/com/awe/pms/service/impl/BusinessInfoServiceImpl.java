package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;
import com.awe.pms.manager.BusinessInfoManager;
import com.awe.pms.service.BusinessInfoService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * BusinessInfoService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Service
public class BusinessInfoServiceImpl implements BusinessInfoService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(BusinessInfoServiceImpl.class);

    @Autowired
    private BusinessInfoManager businessInfoManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.batchInsert")
    public boolean insert(List<BusinessInfo> businessInfoList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(businessInfoList)) {
                resultFlag = businessInfoManager.insert(businessInfoList);
            } else {
                LOG.warn("BusinessInfoServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.insert")
    public boolean insert(BusinessInfo businessInfo) {
        boolean resultFlag = false;
        try {
            if (null != businessInfo) {
                if (businessInfoManager.exist(businessInfo)) {
                    throw new ExistedException();
                }
                resultFlag = businessInfoManager.insert(businessInfo);
            } else {
                LOG.warn("BusinessInfoServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("BusinessInfoServiceImpl#insert failed, businessInfo has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.update")
    public boolean update(BusinessInfo businessInfo) {
        boolean resultFlag = false;
        try {
            if (null != businessInfo && null != businessInfo.getId()) {
                resultFlag = businessInfoManager.update(businessInfo);
            } else {
                LOG.warn("BusinessInfoServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.queryBusinessInfoList")
    public List<BusinessInfo> queryBusinessInfoList(BusinessInfoQuery queryBean) {
        List<BusinessInfo> businessInfoList = null;
        try {
            businessInfoList = businessInfoManager.queryBusinessInfoList(queryBean);
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#queryBusinessInfoList has error.", e);
        }
        return businessInfoList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.queryBusinessInfoListWithPage")
    public List<BusinessInfo> queryBusinessInfoListWithPage(BusinessInfoQuery queryBean, PageUtil pageUtil) {
        List<BusinessInfo> businessInfoList = null;
        try {
            businessInfoList = businessInfoManager.queryBusinessInfoListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#queryBusinessInfoListWithPage has error.", e);
        }
        return businessInfoList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.delete")
    public boolean delete(BusinessInfo businessInfo) {
        boolean resultFlag = false;
        try {
            if (null != businessInfo && null != businessInfo.getId()) {
                resultFlag = businessInfoManager.delete(businessInfo);
            } else {
                LOG.warn("BusinessInfoServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.batchDelete")
    public boolean delete(BusinessInfo[] businessInfos) {
        boolean resultFlag = false;
        try {
            if (null != businessInfos && businessInfos.length > 0) {
                resultFlag = businessInfoManager.delete(businessInfos);
            } else {
                LOG.warn("BusinessInfoServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "BusinessInfoService.getBusinessInfoById")
    public BusinessInfo getBusinessInfoById(Long id) {
        BusinessInfo businessInfo = null;
        try {
            if (null != id) {
                businessInfo = businessInfoManager.getBusinessInfoById(id);
            } else {
                LOG.warn("BusinessInfoServiceImpl#getBusinessInfoById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("BusinessInfoServiceImpl#getBusinessInfoById has error.", e);
        }
        return businessInfo;
    }
}

