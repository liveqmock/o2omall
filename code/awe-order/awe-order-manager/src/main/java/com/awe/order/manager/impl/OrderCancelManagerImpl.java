package com.awe.order.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awe.order.dao.OrderCancelDao;
import com.awe.order.dao.OrderLogDao;
import com.awe.order.dao.OrdersDao;
import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.FrontOrderCancelQuery;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.dto.OrderCancelDto;
import com.awe.order.manager.OrderCancelManager;
import com.awe.order.sdk.api.request.dto.OrderCancelRequestDto;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;

/**
 * OrderCancelManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Component
public class OrderCancelManagerImpl extends BaseManager implements OrderCancelManager {
	
    @Autowired
    private OrderCancelDao orderCancelDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderLogDao logDao;
    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<OrderCancel> orderCancelList) {
        boolean resultFlag = false;
        if (null != orderCancelList && orderCancelList.size() > 0) {
            for (OrderCancel orderCancel : orderCancelList) {
                resultFlag = orderCancelDao.insert(orderCancel);
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
    public boolean insert(OrderCancel orderCancel) {
        return orderCancelDao.insert(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final OrderCancel orderCancel) {
        return orderCancelDao.update(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean) {
        return orderCancelDao.queryOrderCancelList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrderCancelQuery();
        }

        // 查询总数
        int totalItem = queryOrderCancelCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return orderCancelDao.queryOrderCancelListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrderCancelCount(OrderCancelQuery queryBean) {
        return orderCancelDao.queryOrderCancelCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(OrderCancel orderCancel) {
        return orderCancelDao.delete(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
    public OrderCancel getOrderCancelById(Long id) {
        return orderCancelDao.getOrderCancelById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final OrderCancel[] orderCancels) {
        boolean resultFlag = false;
        if (null != orderCancels && orderCancels.length > 0) {
            for (int i = 0; i < orderCancels.length; i++) {
                resultFlag = delete(orderCancels[i]);
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
    public boolean exist(OrderCancel orderCancel) {
        return orderCancelDao.exist(orderCancel);
    }

    /**
     * {@inheritDoc}
     */
	public boolean Cancelupdate(Map map) {
		boolean resultFlag = false;
		//1:根据订单编号改变取消表的数据update
		 resultFlag = orderCancelDao.Cancelupdate(map);
		 if(resultFlag){
		//2：改变订单状态update
		 resultFlag =  ordersDao.orderAudit(map);
		 }
		//3:写订单日志表insert
		 if(resultFlag){
		 resultFlag	= logDao.orderLogAudit(map);
		 }
		return resultFlag;
	}
	/**
     * {@inheritDoc}
     */
	public List<OrderCancelDto> queryFrontOrderCancelListWithPage(FrontOrderCancelQuery queryBean,PageUtil pageUtil) {
		if (null == queryBean) {
            queryBean = new FrontOrderCancelQuery();
        }

        // 查询总数
        int totalItem = queryFrontOrderCancelCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return orderCancelDao.queryFrontOrderCancelListWithPage(queryBean);
        }
        return null;
	}
	/**
     * {@inheritDoc}
     */
	public int queryFrontOrderCancelCount(FrontOrderCancelQuery queryBean) {
		return orderCancelDao.queryFrontOrderCancelCount(queryBean);
	}

	/**
     * {@inheritDoc}
     */
	public OrderCancel getOrderCancelByOrderNo(String orderNo) {
		return orderCancelDao.getOrderCancelByOrderNo(orderNo);
	}
}
