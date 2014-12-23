package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
import com.awe.order.dao.OrderLogDao;
import com.awe.order.manager.OrderLogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderLogManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Component
public class OrderLogManagerImpl extends BaseManager implements OrderLogManager {
	
    @Autowired
    private OrderLogDao orderLogDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<OrderLog> orderLogList) {
        boolean resultFlag = false;
        if (null != orderLogList && orderLogList.size() > 0) {
            for (OrderLog orderLog : orderLogList) {
                resultFlag = orderLogDao.insert(orderLog);
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
    public boolean insert(OrderLog orderLog) {
        return orderLogDao.insert(orderLog);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final OrderLog orderLog) {
        return orderLogDao.update(orderLog);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderLog> queryOrderLogList(OrderLogQuery queryBean) {
        return orderLogDao.queryOrderLogList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderLog> queryOrderLogListWithPage(OrderLogQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrderLogQuery();
        }

        // 查询总数
        int totalItem = queryOrderLogCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return orderLogDao.queryOrderLogListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderLogCount(OrderLogQuery queryBean) {
        return orderLogDao.queryOrderLogCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderLog orderLog) {
        return orderLogDao.delete(orderLog);
    }

    /**
     * {@inheritDoc}
     */
    public OrderLog getOrderLogById(Long id) {
        return orderLogDao.getOrderLogById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final OrderLog[] orderLogs) {
        boolean resultFlag = false;
        if (null != orderLogs && orderLogs.length > 0) {
            for (int i = 0; i < orderLogs.length; i++) {
                resultFlag = delete(orderLogs[i]);
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
    public boolean exist(OrderLog orderLog) {
        return orderLogDao.exist(orderLog);
    }
}
