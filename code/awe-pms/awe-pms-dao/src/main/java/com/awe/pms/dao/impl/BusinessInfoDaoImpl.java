package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.BusinessInfoDao;
import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * BusinessInfoDAO实现类<br/>
 * 对'商家信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
@Repository
public class BusinessInfoDaoImpl extends BaseDao implements BusinessInfoDao {
    /** namespace */
    private final String namespace = BusinessInfoDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<BusinessInfo> queryBusinessInfoList(BusinessInfoQuery queryBean) {
        return (List<BusinessInfo>) queryForList(namespace +".queryBusinessInfoList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(BusinessInfo businessInfo) {
        return insert(namespace +".insert", businessInfo);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(BusinessInfo businessInfo) {
        return update(namespace +".update", businessInfo);
    }

    /**
     * {@inheritDoc}
     */
    public int queryBusinessInfoCount(BusinessInfoQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryBusinessInfoCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessInfo> queryBusinessInfoListWithPage(BusinessInfoQuery queryBean) {
        return (List<BusinessInfo>) queryForList(namespace +".queryBusinessInfoListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BusinessInfo configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public BusinessInfo getBusinessInfoById(Long id) {
        return (BusinessInfo) queryForObject(namespace +".getBusinessInfoById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(BusinessInfo businessInfo) {
        int count = (Integer) queryForObject(namespace +".exist", businessInfo);
        return count > 0;
    }
}
