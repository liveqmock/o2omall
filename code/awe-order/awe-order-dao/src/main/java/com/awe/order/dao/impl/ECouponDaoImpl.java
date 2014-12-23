package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.ECouponDao;
import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ECouponDAO实现类<br/>
 * 对'电子券'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
@Repository
public class ECouponDaoImpl extends BaseDao implements ECouponDao {
    /** namespace */
    private final String namespace = ECouponDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ECoupon> queryECouponList(ECouponQuery queryBean) {
        return (List<ECoupon>) queryForList(namespace +".queryECouponList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ECoupon eCoupon) {
        return insert(namespace +".insert", eCoupon);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ECoupon eCoupon) {
        return update(namespace +".update", eCoupon);
    }

    /**
     * {@inheritDoc}
     */
    public int queryECouponCount(ECouponQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryECouponCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ECoupon> queryECouponListWithPage(ECouponQuery queryBean) {
        return (List<ECoupon>) queryForList(namespace +".queryECouponListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ECoupon configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ECoupon getECouponById(Long id) {
        return (ECoupon) queryForObject(namespace +".getECouponById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ECoupon eCoupon) {
        int count = (Integer) queryForObject(namespace +".exist", eCoupon);
        return count > 0;
    }
}
