package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;
import com.awe.order.dao.ECouponDao;
import com.awe.order.manager.ECouponManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ECouponManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Component
public class ECouponManagerImpl extends BaseManager implements ECouponManager {
	
    @Autowired
    private ECouponDao eCouponDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ECoupon> eCouponList) {
        boolean resultFlag = false;
        if (null != eCouponList && eCouponList.size() > 0) {
            for (ECoupon eCoupon : eCouponList) {
                resultFlag = eCouponDao.insert(eCoupon);
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
    public boolean insert(ECoupon eCoupon) {
        return eCouponDao.insert(eCoupon);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ECoupon eCoupon) {
        return eCouponDao.update(eCoupon);
    }

    /**
     * {@inheritDoc}
     */
    public List<ECoupon> queryECouponList(ECouponQuery queryBean) {
        return eCouponDao.queryECouponList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ECoupon> queryECouponListWithPage(ECouponQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ECouponQuery();
        }

        // 查询总数
        int totalItem = queryECouponCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return eCouponDao.queryECouponListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryECouponCount(ECouponQuery queryBean) {
        return eCouponDao.queryECouponCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ECoupon eCoupon) {
        return eCouponDao.delete(eCoupon);
    }

    /**
     * {@inheritDoc}
     */
    public ECoupon getECouponById(Long id) {
        return eCouponDao.getECouponById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ECoupon[] eCoupons) {
        boolean resultFlag = false;
        if (null != eCoupons && eCoupons.length > 0) {
            for (int i = 0; i < eCoupons.length; i++) {
                resultFlag = delete(eCoupons[i]);
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
    public boolean exist(ECoupon eCoupon) {
        return eCouponDao.exist(eCoupon);
    }
}
