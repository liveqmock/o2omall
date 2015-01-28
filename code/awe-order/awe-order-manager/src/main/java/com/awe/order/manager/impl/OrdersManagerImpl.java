package com.awe.order.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awe.order.dao.OrderCancelDao;
import com.awe.order.dao.OrderLogDao;
import com.awe.order.dao.OrdersDao;
import com.awe.order.dao.OrdersItemsDao;
import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.OrderDetails;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.Orders;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.dto.OrdersDto;
import com.awe.order.manager.OrdersManager;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;

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
    @Autowired
    private OrderCancelDao cancelDao;

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
	public boolean insertDetails(List<OrderDetails> orderDetails) {
		 boolean resultFlag = false;
		 int a=0;
	        if (null != orderDetails) {
	        	for (OrderDetails orders : orderDetails) {
	        	//1:插入订单
                resultFlag = ordersDao.insert(orders.getOrders());
                if (!resultFlag) {
                    throw new RuntimeException("新增订单异常异常");
                }
                //2:插入item
                if (null != orders.getOrdersItemsList() && orders.getOrdersItemsList().size() > 0) {
                	if(a == 0){
	                    for (OrdersItems ordersItems : orders.getOrdersItemsList()) {
	                    	resultFlag = ordersItemsDao.insert(ordersItems);
	                    }
	                    if (!resultFlag) {
	                        throw new RuntimeException("新增订单商品异常异常");
	                    }
	                    a=1;
                	}
                 }
                //3:插入日志
                resultFlag = orderLogDao.insert(orders.getOrderLog());
                if (!resultFlag) {
                    throw new RuntimeException("新增订单商品异常异常");
                }
	        }
	        }
	        a=0;
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
		 log.setDescription("系统取消订单");
		 //写日志
		 resultFlag = orderLogDao.insert(log);
		 if(!resultFlag){
			 throw new RuntimeException("系统取消订单日志异常");
		 }
		return resultFlag;
	}

	/**
     * {@inheritDoc}
     */
	public boolean cancelOrders(Orders orders) {
		 boolean resultFlag = false;
		 int count = 0;
		/**
		 * 订单取消要用分2步
		 */
        if (null != orders) {
        	OrderLog log = new OrderLog();
        	OrderCancel cancel = new OrderCancel();
        	// 1：改变订单表状态
            //1.1 判断订单是否支付，如果没有支付，就直接取消，支付的话，需要走后台审核
        	count = ordersDao.queryOrderCancelStatus(orders.getOrderNo());
        	if(count != 0){//已支付 状态改待审核
        		//--订单信息
        		orders.setOrderStatus(110);
        		orders.setRemark(orders.getRemark()+",订单已支付,取消需要审核！");
        		resultFlag = ordersDao.update(orders);
        		//--取消表信息
        		cancel.setStatus(501);
        		//--日志信息
        		log.setStatusName("订单审核");
        		log.setStatus(110);
        	}else{//木有支付 乃就取消
        		//--订单信息
        		orders.setOrderStatus(10);
        		orders.setRemark(orders.getRemark()+",用户取消订单！");
        		resultFlag = ordersDao.update(orders);
        		//--取消表信息
        		cancel.setStatus(506);
        		//--日志信息
        		log.setStatusName("用户取消");
        		log.setStatus(10);
        	}
        	if (!resultFlag) {
                throw new RuntimeException("取消订单订单异常");
            }
        	//--写取消表
        	cancel.setOrderNo(orders.getOrderNo());
        	cancel.setCancelReason(orders.getRemark());
        	cancel.setCreateUser(orders.getUpdateUser());
        	cancel.setUserId(orders.getUserId());
        	resultFlag = cancelDao.insert(cancel);
        	if (!resultFlag) {
                throw new RuntimeException("取消订单异常");
            }
        	// 2：写日志
    		 log.setOrderNo(orders.getOrderNo());
    		 log.setLogType(100);
    		 log.setCreateUser(orders.getUpdateUser());
     		 log.setDescription(orders.getRemark());
    		 //写日志
    		 resultFlag = orderLogDao.insert(log);
    		 if (!resultFlag) {
                 throw new RuntimeException("取消订单日志异常");
             }
        }
		return resultFlag;
	}

	/**
     * {@inheritDoc}
     */
	public boolean updateOrder(Map<String, Object> map) {
		boolean resultFlag = false;
		resultFlag = ordersDao.updateOrder(map);
		if (!resultFlag) {
            throw new RuntimeException("修改订单状态异常");
        }
		map.put("status", 50);
		map.put("statusName", "已付款");
		map.put("description", "订单支付成功!");
		map.put("logType", "100");
		resultFlag = orderLogDao.insertBatchLogDao(map);
		if (!resultFlag) {
            throw new RuntimeException("订单日志异常");
        }
		return resultFlag;
	}
}
