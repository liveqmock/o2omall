package com.awe.order.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.FrontOrderCancelQuery;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.dto.OrderCancelDto;
import com.awe.order.enums.EnumOrderCancelStatus;
import com.awe.order.manager.OrderCancelManager;
import com.awe.order.sdk.api.request.dto.OrderCancelRequestDto;
import com.awe.order.service.OrderCancelService;
import com.awe.order.service.helper.OrderCancelComparator;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
 
/**
 * OrderCancelService接口的实现类
 * 
 * @author ljz,zyq
 * @version 2014-12-23 10:58:06
 * 
 */
@Service
public class OrderCancelServiceImpl implements OrderCancelService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(OrderCancelServiceImpl.class);

    @Autowired
    private OrderCancelManager orderCancelManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.batchInsert")
    public boolean insert(List<OrderCancel> orderCancelList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(orderCancelList)) {
                resultFlag = orderCancelManager.insert(orderCancelList);
            } else {
                LOG.warn("OrderCancelServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.insert")
    public boolean insert(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel) {
                if (orderCancelManager.exist(orderCancel)) {
                    throw new ExistedException();
                }
                resultFlag = orderCancelManager.insert(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("OrderCancelServiceImpl#insert failed, orderCancel has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.update")
    public boolean update(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel && null != orderCancel.getId()) {
                resultFlag = orderCancelManager.update(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.queryOrderCancelList")
    public List<OrderCancel> queryOrderCancelList(OrderCancelQuery queryBean) {
        List<OrderCancel> orderCancelList = null;
        try {
            orderCancelList = orderCancelManager.queryOrderCancelList(queryBean);
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#queryOrderCancelList has error.", e);
        }
        return orderCancelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.queryOrderCancelListWithPage")
    public List<OrderCancel> queryOrderCancelListWithPage(OrderCancelQuery queryBean, PageUtil pageUtil) {
        List<OrderCancel> orderCancelList = null;
        try {
            orderCancelList = orderCancelManager.queryOrderCancelListWithPage(queryBean, pageUtil);
            if(orderCancelList !=null && orderCancelList.size() != 0){
            	for (OrderCancel orderCancel : orderCancelList) {
					 if(orderCancel.getStatus() != null){
						 orderCancel.setStatusName(EnumOrderCancelStatus.getName(String.valueOf(orderCancel.getStatus())));
					 }
				}
            }
            
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#queryOrderCancelListWithPage has error.", e);
        }
        return orderCancelList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.delete")
    public boolean delete(OrderCancel orderCancel) {
        boolean resultFlag = false;
        try {
            if (null != orderCancel && null != orderCancel.getId()) {
                resultFlag = orderCancelManager.delete(orderCancel);
            } else {
                LOG.warn("OrderCancelServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.batchDelete")
    public boolean delete(OrderCancel[] orderCancels) {
        boolean resultFlag = false;
        try {
            if (null != orderCancels && orderCancels.length > 0) {
                resultFlag = orderCancelManager.delete(orderCancels);
            } else {
                LOG.warn("OrderCancelServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.getOrderCancelById")
    public OrderCancel getOrderCancelById(Long id) {
        OrderCancel orderCancel = null;
        try {
            if (null != id) {
                orderCancel = orderCancelManager.getOrderCancelById(id);
            } else {
                LOG.warn("OrderCancelServiceImpl#getOrderCancelById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#getOrderCancelById has error.", e);
        }
        return orderCancel;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.Cancelupdate")
	public boolean Cancelupdate(OrderCancel orderCancel) {
    	boolean resultFlag = false;
    	Map<String,Object> map= new HashMap<String, Object>();
    	List<OrderCancel> list = new ArrayList<OrderCancel>();
    	String noStr = orderCancel.getOrderNo();
    	String orderNo[] = noStr.split(",");
    	map.put("orderList", orderNo);
    	map.put("isAuditing", orderCancel.getIsAuditing());
    	map.put("remark", orderCancel.getRemark());
    	map.put("updateUser", orderCancel.getUpdateUser());
    	if(orderCancel.getIsAuditing() == 1){
    		map.put("status", "502");//待退款
    		map.put("statusName", "退款中");
    		map.put("orderStatus", "140");
    	}else{
    		map.put("status", "504");//审核驳回
    		map.put("statusName", "审核驳回");
    		map.put("orderStatus", "107");
    	}
        try {
            if (null != orderCancel && null != orderCancel.getOrderNo()) {
                resultFlag = orderCancelManager.Cancelupdate(map);
            } else {
                LOG.warn("OrderCancelServiceImpl#Cancelupdate failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#Cancelupdate has error.", e);
        }
        return resultFlag;
	}
    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "OrderCancelService.queryFrontOrderCancelListWithPage")
	public List<OrderCancel> queryFrontOrderCancelListWithPage(FrontOrderCancelQuery queryBean, PageUtil pageUtil) {
		List<OrderCancelDto> orderCancelDtoList = null;
    	List<OrderCancel> dataList = new ArrayList<OrderCancel>();
    	OrderCancel orderCancel = null;
    	OrdersItems ordersItems = null;
    	List<OrdersItems> ordersItemsList = null;
    	List<OrdersItems> tempList = null;
    	boolean isOtherOrder = false;
        try {
        	orderCancelDtoList = orderCancelManager.queryFrontOrderCancelListWithPage(queryBean, pageUtil);
        	Collections.sort(orderCancelDtoList, new OrderCancelComparator());//按订单号排序
        	for (OrderCancelDto orderCancelDto : orderCancelDtoList) {
        		if(null == orderCancel || !orderCancelDto.getOrderNo().equals(orderCancel.getOrderNo())){
        			orderCancel = new OrderCancel();
        			BeanUtils.copyProperties(orderCancelDto, orderCancel);
        			ordersItemsList = new ArrayList<OrdersItems>();
        			isOtherOrder = true;
        		}
        		ordersItems = new OrdersItems();
        		BeanUtils.copyProperties(orderCancelDto, ordersItems);
        		ordersItemsList.add(ordersItems);
        		if(!isOtherOrder){
        			tempList = ordersItemsList;
        			orderCancel.setOrdersItemsList(tempList);
        			dataList.add(orderCancel);
        		}
        		isOtherOrder = false;
			}
        } catch (Exception e) {
            LOG.error("OrderCancelServiceImpl#queryFrontOrderCancelListWithPage has error.", e);
        }
        return dataList;
	}

    /**
     * {@inheritDoc}
     */
	public OrderCancel getOrderCancelByOrderNo(String orderNo) {
		 OrderCancel orderCancel = null;
	        try {
	            if (null != orderNo) {
	                orderCancel = orderCancelManager.getOrderCancelByOrderNo(orderNo);
	            } else {
	                LOG.warn("OrderCancelServiceImpl#getOrderCancelByOrderNo failed, param is illegal.");
	            }
	        } catch (Exception e) {
	            LOG.error("OrderCancelServiceImpl#getOrderCancelByOrderNo has error.", e);
	        }
	        return orderCancel;
		
	}

}

