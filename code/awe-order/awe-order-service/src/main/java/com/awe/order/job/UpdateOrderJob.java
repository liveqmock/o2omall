package com.awe.order.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.awe.order.domain.Orders;
import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
import com.awe.order.manager.OrdersManager;
import com.awe.order.manager.TaskOrdersManager;

/**
 * 订单支付成功后，改变订单状态失败，通过此定时器完成操作 UpdateOrderJob
 * 
 * @author js
 * @version：2015年1月29日 下午3:54:16
 */
@SuppressWarnings("all")
public class UpdateOrderJob {
	private final static Log LOG = LogFactory.getLog(UpdateOrderJob.class);
	boolean flag = false;
	@Autowired
	private TaskOrdersManager taskOrdersManager;
	@Autowired
	private OrdersManager ordersManager;

	public void updateOrder() {
		/*// 存放修改成功的数据
		List<Orders> listSuccess = new ArrayList<Orders>();
		// 存放修改成功的数据
		List<Orders> listFail = new ArrayList<Orders>();*/
		// 1:查询出没有执行成功的数据
		TaskOrdersQuery queryBean = new TaskOrdersQuery();
		// 查询task任务
		queryBean.setYn(1);
		queryBean.setTaskStatus(1);
		queryBean.setBusinessno("000000");
		queryBean.setBusinesstype("payTask");
		List<TaskOrders> listTaskOrders = taskOrdersManager.queryTaskOrdersList(queryBean);
		// 2:循环调用修改订单状态接口,同时写日志，每次查询100条数据
		for (TaskOrders taskOrders : listTaskOrders) {
			Orders queryOrders = new Orders();
			queryOrders.setOrderNo(taskOrders.getKeyword1());// 订单号
			queryOrders.setUserId(Long.getLong(taskOrders.getKeyword2()));// 用户ID
			queryOrders.setCreateUser(taskOrders.getCreateUser());// 创建人
			flag = ordersManager.updateOrderLog(queryOrders);
			if (flag) {
				TaskOrders task = new TaskOrders();
				task.setKeyword1(taskOrders.getKeyword1());// 订单号
				task.setBusinessno("000000");
				task.setBusinesstype("payTask");
				task.setTaskStatus(2);// 成功
				// 成功后改变task状态
				boolean flag = taskOrdersManager.update(taskOrders);
				LOG.info("改变订单状态成功 falg--------》》》" + flag);
			} else {
				// 执行次数加1,如果执行次数大于6时,改变task状态为失败
				TaskOrders taskObject = taskOrdersManager.getTaskOrdersById(taskOrders.getId());
				//
				TaskOrders taskFail = new TaskOrders();
				taskFail.setKeyword1(taskOrders.getKeyword1());// 订单号
				taskFail.setBusinessno("000000");
				taskFail.setBusinesstype("payTask");
				if (taskObject.getExecuteCount() >= 6) {
					taskFail.setTaskStatus(3);// 失败
					boolean flag = taskOrdersManager.update(taskFail);
					LOG.info("改变订单状态失败次数大于六 falg--------》》》" + flag);
				} else {
					taskFail.setTaskStatus(1);
					taskFail.setExecuteCount(taskObject.getExecuteCount() + 1);
					boolean flag = taskOrdersManager.update(taskFail);
					LOG.info("改变订单状态失败次数小于六 falg--------》》》" + flag);
				}
			}
		}
	}
}
