package com.awe.rems.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.rems.domain.Refund;
import com.awe.rems.domain.query.RefundQuery;
import com.awe.rems.dao.RefundDao;
import com.awe.rems.manager.RefundManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RefundManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
@Component
public class RefundManagerImpl extends BaseManager implements RefundManager {
	
    @Autowired
    private RefundDao refundDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Refund> refundList) {
        boolean resultFlag = false;
        if (null != refundList && refundList.size() > 0) {
            for (Refund refund : refundList) {
                resultFlag = refundDao.insert(refund);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Refund refund) {
        return refundDao.insert(refund);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Refund refund) {
        return refundDao.update(refund);
    }

    /**
     * {@inheritDoc}
     */
    public List<Refund> queryRefundList(RefundQuery queryBean) {
        return refundDao.queryRefundList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Refund> queryRefundListWithPage(RefundQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new RefundQuery();
        }

        // 查询总数
        int totalItem = queryRefundCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return refundDao.queryRefundListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryRefundCount(RefundQuery queryBean) {
        return refundDao.queryRefundCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Refund refund) {
        return refundDao.delete(refund);
    }

    /**
     * {@inheritDoc}
     */
    public Refund getRefundById(Long id) {
        return refundDao.getRefundById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Refund[] refunds) {
        boolean resultFlag = false;
        if (null != refunds && refunds.length > 0) {
            for (int i = 0; i < refunds.length; i++) {
                resultFlag = delete(refunds[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(Refund refund) {
        return refundDao.exist(refund);
    }
}
