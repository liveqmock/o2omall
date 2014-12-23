package com.awe.pay.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pay.domain.Refund;
import com.awe.pay.domain.query.RefundQuery;
import com.awe.pay.manager.RefundManager;
import com.awe.pay.service.RefundService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * RefundService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
@Service
public class RefundServiceImpl implements RefundService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(RefundServiceImpl.class);

    @Autowired
    private RefundManager refundManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.batchInsert")
    public boolean insert(List<Refund> refundList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(refundList)) {
                resultFlag = refundManager.insert(refundList);
            } else {
                LOG.warn("RefundServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.insert")
    public boolean insert(Refund refund) {
        boolean resultFlag = false;
        try {
            if (null != refund) {
                if (refundManager.exist(refund)) {
                    throw new ExistedException();
                }
                resultFlag = refundManager.insert(refund);
            } else {
                LOG.warn("RefundServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("RefundServiceImpl#insert failed, refund has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.update")
    public boolean update(Refund refund) {
        boolean resultFlag = false;
        try {
            if (null != refund && null != refund.getId()) {
                resultFlag = refundManager.update(refund);
            } else {
                LOG.warn("RefundServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.queryRefundList")
    public List<Refund> queryRefundList(RefundQuery queryBean) {
        List<Refund> refundList = null;
        try {
            refundList = refundManager.queryRefundList(queryBean);
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#queryRefundList has error.", e);
        }
        return refundList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.queryRefundListWithPage")
    public List<Refund> queryRefundListWithPage(RefundQuery queryBean, PageUtil pageUtil) {
        List<Refund> refundList = null;
        try {
            refundList = refundManager.queryRefundListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#queryRefundListWithPage has error.", e);
        }
        return refundList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.delete")
    public boolean delete(Refund refund) {
        boolean resultFlag = false;
        try {
            if (null != refund && null != refund.getId()) {
                resultFlag = refundManager.delete(refund);
            } else {
                LOG.warn("RefundServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.batchDelete")
    public boolean delete(Refund[] refunds) {
        boolean resultFlag = false;
        try {
            if (null != refunds && refunds.length > 0) {
                resultFlag = refundManager.delete(refunds);
            } else {
                LOG.warn("RefundServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "RefundService.getRefundById")
    public Refund getRefundById(Long id) {
        Refund refund = null;
        try {
            if (null != id) {
                refund = refundManager.getRefundById(id);
            } else {
                LOG.warn("RefundServiceImpl#getRefundById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("RefundServiceImpl#getRefundById has error.", e);
        }
        return refund;
    }
}

