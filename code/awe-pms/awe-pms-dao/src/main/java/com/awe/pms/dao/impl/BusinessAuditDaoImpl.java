package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.BusinessAuditDao;
import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * BusinessAuditDAO实现类<br/>
 * 对'审核商家流水表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
@Repository
public class BusinessAuditDaoImpl extends BaseDao implements BusinessAuditDao {
    /** namespace */
    private final String namespace = BusinessAuditDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<BusinessAudit> queryBusinessAuditList(BusinessAuditQuery queryBean) {
        return (List<BusinessAudit>) queryForList(namespace +".queryBusinessAuditList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(BusinessAudit businessAudit) {
        return insert(namespace +".insert", businessAudit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(BusinessAudit businessAudit) {
        return update(namespace +".update", businessAudit);
    }

    /**
     * {@inheritDoc}
     */
    public int queryBusinessAuditCount(BusinessAuditQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryBusinessAuditCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessAudit> queryBusinessAuditListWithPage(BusinessAuditQuery queryBean) {
        return (List<BusinessAudit>) queryForList(namespace +".queryBusinessAuditListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BusinessAudit configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public BusinessAudit getBusinessAuditById(Long id) {
        return (BusinessAudit) queryForObject(namespace +".getBusinessAuditById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(BusinessAudit businessAudit) {
        int count = (Integer) queryForObject(namespace +".exist", businessAudit);
        return count > 0;
    }
}
