package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.OrderDetails;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.Orders;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.dto.OrdersDto;
import com.awe.order.dao.OrderLogDao;
import com.awe.order.dao.OrdersDao;
import com.awe.order.dao.OrdersItemsDao;
import com.awe.order.manager.OrdersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrdersManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Component
public class OrdersManagerImpl extends BaseManager implements OrdersManager {
	
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrdersItemsDao ordersItemsDao;
    @Autowired
    private OrderLogDao orderLogDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Orders> ordersList) {
        boolean resultFlag = false;
        if (null != ordersList && ordersList.size() > 0) {
            for (Orders orders : ordersList) {
                resultFlag = ordersDao.insert(orders);
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
    public boolean insert(Orders orders) {
        return ordersDao.insert(orders);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Orders orders) {
        return ordersDao.update(orders);
    }

    /**
     * {@inheritDoc}
     */
    public List<Orders> queryOrdersList(OrdersQuery queryBean) {
        return ordersDao.queryOrdersList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean,PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new OrdersQuery();
        }

        // 查询总数
        int totalItem = queryOrdersCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return ordersDao.queryOrdersListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryOrdersCount(OrdersQuery queryBean) {
        return ordersDao.queryOrdersCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Orders orders) {
        return ordersDao.delete(orders);
    }

    /**
     * {@inheritDoc}
     */
    public Orders getOrdersById(Long id) {
        return ordersDao.getOrdersById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Orders[] orderss) {
        boolean resultFlag = false;
        if (null != orderss && orderss.length > 0) {
            for (int i = 0; i < orderss.length; i++) {
                resultFlag = delete(orderss[i]);
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
    public boolean exist(Orders orders) {
        return ordersDao.exist(orders);
    }

    /**
     * {@inheritDoc}
     */
	public Orders getOrdersByOrderNO(String orderNo) {
		return ordersDao.getOrdersByOrderNO(orderNo);
	}
	/**
     * {@inheritDoc}
     */
	public List<OrdersDto> queryFrontOrdersListWithPage(FrontOrdersQuery queryBean,PageUtil pageUtil) {
		if (null == queryBean) {
            queryBean = new FrontOrdersQuery();
        }

        // 查询总数
        int totalItem = queryFrontOrdersCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return ordersDao.queryFrontOrdersListWithPage(queryBean);
        }
        return null;
	}
	/**
     * {@inheritDoc}
     */
	public int queryFrontOrdersCount(FrontOrdersQuery queryBean) {
		return ordersDao.queryFrontOrdersCount(queryBean);
	}

	/**
     * {@inheritDoc}
     */
	public boolean insertDetails(OrderDetails orderDetails) {
		 boolean resultFlag = false;
	        if (null != orderDetails) {
	        	//1:插入订单
                resultFlag = ordersDao.insert(orderDetails.getOrders());
                if (!resultFlag) {
                    throw new RuntimeException("新增订单异常异常");
                }
                //2:插入item
                if (null != orderDetails.getOrdersItemsList() && orderDetails.getOrdersItemsList().size() > 0) {
                    for (OrdersItems ordersItems : orderDetails.getOrdersItemsList()) {
                    	resultFlag = ordersItemsDao.insert(ordersItems);
                    }
                    if (!resultFlag) {
                        throw new RuntimeException("新增订单商品异常异常");
                    }
                 }
                //3:插入日志
                resultFlag = orderLogDao.insert(orderDetails.getOrderLog());
                if (!resultFlag) {
                    throw new RuntimeException("新增订单商品异常异常");
                }
	        }
	        return resultFlag;
	}

	/**
     * {@inheritDoc}
     */
	public List<Orders> queryOrderListCancel(String yesTerDay) {
		return ordersDao.queryOrderListCancel(yesTerDay);
		
	}
	
	/**
     * {@inheritDoc}
     */
	public boolean updateorderCancel(Orders orders) {
		 boolean resultFlag = false;
		//1:改变订单状态
		 resultFlag = ordersDao.update(orders);
		 if(!resultFlag){
			 throw new RuntimeException("系统取消订单异常");
		 }
		 OrderLog log = new OrderLog();
		 log.setOrderNo(orders.getOrderNo());
		 log.setStatus(30);
		 log.setStatusName("系统取消");
		 log.setLogType(100);
		 log.setCreateUser("系统操作");
		 log.setDescription("系统取消订单异常");
		 //写日志
		 resultFlag = orderLogDao.insert(log);
		 if(!resultFlag){
			 throw new RuntimeException("系统取消订单日志异常");
		 }
		return resultFlag;
	}
}
