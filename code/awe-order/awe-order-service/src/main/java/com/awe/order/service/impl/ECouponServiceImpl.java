package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;
import com.awe.order.manager.ECouponManager;
import com.awe.order.service.ECouponService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ECouponService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Service
public class ECouponServiceImpl implements ECouponService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ECouponServiceImpl.class);

    @Autowired
    private ECouponManager eCouponManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.batchInsert")
    public boolean insert(List<ECoupon> eCouponList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(eCouponList)) {
                resultFlag = eCouponManager.insert(eCouponList);
            } else {
                LOG.warn("ECouponServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.insert")
    public boolean insert(ECoupon eCoupon) {
        boolean resultFlag = false;
        try {
            if (null != eCoupon) {
                if (eCouponManager.exist(eCoupon)) {
                    throw new ExistedException();
                }
                resultFlag = eCouponManager.insert(eCoupon);
            } else {
                LOG.warn("ECouponServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ECouponServiceImpl#insert failed, eCoupon has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.update")
    public boolean update(ECoupon eCoupon) {
        boolean resultFlag = false;
        try {
            if (null != eCoupon && null != eCoupon.getId()) {
                resultFlag = eCouponManager.update(eCoupon);
            } else {
                LOG.warn("ECouponServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.queryECouponList")
    public List<ECoupon> queryECouponList(ECouponQuery queryBean) {
        List<ECoupon> eCouponList = null;
        try {
            eCouponList = eCouponManager.queryECouponList(queryBean);
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#queryECouponList has error.", e);
        }
        return eCouponList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.queryECouponListWithPage")
    public List<ECoupon> queryECouponListWithPage(ECouponQuery queryBean, PageUtil pageUtil) {
        List<ECoupon> eCouponList = null;
        try {
            eCouponList = eCouponManager.queryECouponListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#queryECouponListWithPage has error.", e);
        }
        return eCouponList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.delete")
    public boolean delete(ECoupon eCoupon) {
        boolean resultFlag = false;
        try {
            if (null != eCoupon && null != eCoupon.getId()) {
                resultFlag = eCouponManager.delete(eCoupon);
            } else {
                LOG.warn("ECouponServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.batchDelete")
    public boolean delete(ECoupon[] eCoupons) {
        boolean resultFlag = false;
        try {
            if (null != eCoupons && eCoupons.length > 0) {
                resultFlag = eCouponManager.delete(eCoupons);
            } else {
                LOG.warn("ECouponServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ECouponService.getECouponById")
    public ECoupon getECouponById(Long id) {
        ECoupon eCoupon = null;
        try {
            if (null != id) {
                eCoupon = eCouponManager.getECouponById(id);
            } else {
                LOG.warn("ECouponServiceImpl#getECouponById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ECouponServiceImpl#getECouponById has error.", e);
        }
        return eCoupon;
    }
}

