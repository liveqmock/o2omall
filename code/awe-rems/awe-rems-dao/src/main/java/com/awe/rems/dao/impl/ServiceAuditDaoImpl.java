package com.awe.rems.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.rems.dao.ServiceAuditDao;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ServiceAuditDAO实现类<br/>
 * 对'退换货审核流表'表进行基本的操作
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Repository
public class ServiceAuditDaoImpl extends BaseDao implements ServiceAuditDao {
    /** namespace */
    private final String namespace = ServiceAuditDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean) {
        return (List<ServiceAudit>) queryForList(namespace +".queryServiceAuditList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ServiceAudit serviceAudit) {
        return insert(namespace +".insert", serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ServiceAudit serviceAudit) {
        return update(namespace +".update", serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public int queryServiceAuditCount(ServiceAuditQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryServiceAuditCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean) {
        return (List<ServiceAudit>) queryForList(namespace +".queryServiceAuditListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public ServiceAudit getServiceAuditById(Long id) {
        return (ServiceAudit) queryForObject(namespace +".getServiceAuditById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ServiceAudit serviceAudit) {
        int count = (Integer) queryForObject(namespace +".exist", serviceAudit);
        return count > 0;
    }
}
