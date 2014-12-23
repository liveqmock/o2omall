package com.awe.pay.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pay.dao.RefundDao;
import com.awe.pay.domain.Refund;
import com.awe.pay.domain.query.RefundQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * RefundDAO实现类<br/>
 * 对'逆向退款'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Repository
public class RefundDaoImpl extends BaseDao implements RefundDao {
    /** namespace */
    private final String namespace = RefundDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Refund> queryRefundList(RefundQuery queryBean) {
        return (List<Refund>) queryForList(namespace +".queryRefundList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Refund refund) {
        return insert(namespace +".insert", refund);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Refund refund) {
        return update(namespace +".update", refund);
    }

    /**
     * {@inheritDoc}
     */
    public int queryRefundCount(RefundQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryRefundCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Refund> queryRefundListWithPage(RefundQuery queryBean) {
        return (List<Refund>) queryForList(namespace +".queryRefundListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Refund configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Refund getRefundById(Long id) {
        return (Refund) queryForObject(namespace +".getRefundById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Refund refund) {
        int count = (Integer) queryForObject(namespace +".exist", refund);
        return count > 0;
    }
}
