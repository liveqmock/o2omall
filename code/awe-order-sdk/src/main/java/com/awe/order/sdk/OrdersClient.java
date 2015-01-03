package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.OrdersRequest;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.OrdersResponse;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 订单服务的客户端
 * 
 * @author ljz,zyq
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrdersClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(OrdersClient.class);

    /**
     * 订单查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrdersResponseDto 接口返回的数据对象
     */
    public OrdersResponseDto getOrders(OrdersRequestDto requestDto) {
        Assert.notNull(requestDto);

        OrdersRequest request = new OrdersRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrders request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orders/getOrders";
        OrdersResponse response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrders url: " + url);
            LOG.debug("getOrders response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    /**
     * 获取已下单订单列表
     * @param requestDto
     * @return
     */
    public Wrapper<?> queryFrontOrdersListWithPage(OrdersRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("queryFrontOrdersListWithPage request: " + JsonHelper.toJson(requestDto));
        }
    	OrdersRequest request = new OrdersRequest(super.getKey(), requestDto);
    	OrdersResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/orders/queryFrontOrdersListWithPage";
    	     response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);
		} catch (Exception e) {
			LOG.error("#OrdersClient.queryFrontOrdersListWithPage# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("queryFrontOrdersListWithPage url: " + url);
            LOG.debug("queryFrontOrdersListWithPage response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 订单取消
     * @param requestDto
     * @return
     */
    public Wrapper<?> cancelOrders(OrdersRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("cancelOrders request: " + JsonHelper.toJson(requestDto));
        }
    	OrdersRequest request = new OrdersRequest(super.getKey(), requestDto);
    	OrdersResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/orders/cancelOrders";
    	     response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);
		} catch (Exception e) {
			LOG.error("#OrdersClient.cancelOrders# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("cancelOrders url: " + url);
            LOG.debug("cancelOrders response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 删除订单数据
     * @param requestDto
     * @return
     */
    public Wrapper<?> deleteOrders(OrdersRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("deleteOrders request: " + JsonHelper.toJson(requestDto));
        }
    	OrdersRequest request = new OrdersRequest(super.getKey(), requestDto);
    	OrdersResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/orders/deleteOrders";
    	     response = super.getRestTemplate().postForObject(url, request, OrdersResponse.class);
		} catch (Exception e) {
			LOG.error("#OrdersClient.deleteOrders# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("deleteOrders url: " + url);
            LOG.debug("deleteOrders response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    
}
