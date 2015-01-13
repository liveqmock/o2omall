package com.awe.order.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.awe.order.domain.Orders;
import com.awe.order.manager.OrdersManager;
/**
 * 查询有效待付款的订单，如果下单时间超过24小时未支付，订单状态转无效
 *OrderCancelJob	
 *
 * @author js
 * @version：2015年1月13日 上午10:53:05
 */
@SuppressWarnings("all")
public class OrderCancelJob {
	private final static Log LOG = LogFactory.getLog(OrderCancelJob.class);
	
	 @Autowired
	 private OrdersManager ordersManager;
	
	public void orderCancel(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);    //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//现在时间的前一天时间
		String yesTerDay = df.format(date);
		//查询出下单未支付超过24小时的订单号collection 
		List<Orders> listOrders = ordersManager.queryOrderListCancel(yesTerDay);
		if(!CollectionUtils.isEmpty(listOrders)){
			for (Orders orders : listOrders) {
				 orders.setRemark("下单未支付超过24小时,系统自动取消！");
				 orders.setOrderStatus(30);
				 //1:改变订单状态,2:写日志
				 boolean falg = ordersManager.updateorderCancel(orders);
				 LOG.info("下单未支付超过24小时的订单号>>>>>>>>>>>:"+orders.getOrderNo());
				 LOG.info("下单未支付超过24小时的订单号状态改完取消>>>>>>>>>>>:"+falg);
			}
		}
	}

}
