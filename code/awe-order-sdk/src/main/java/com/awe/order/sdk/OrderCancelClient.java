package com.awe.order.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.OrderCancelRequest;
import com.awe.order.sdk.request.dto.OrderCancelRequestDto;
import com.awe.order.sdk.response.OrderCancelResponse;
import com.awe.order.sdk.response.OrderCancelResponseList;
import com.awe.order.sdk.response.dto.OrderCancelResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 订单取消服务的客户端
 * 
 * @author ljz,zyq
 * @version 2014-12-25 17:52:58
 * 
 */
public class OrderCancelClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(OrderCancelClient.class);

    /**
     * 订单取消查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrderCancelResponseDto 接口返回的数据对象
     */
    public OrderCancelResponseDto getOrderCancel(OrderCancelRequestDto requestDto) {
        Assert.notNull(requestDto);

        OrderCancelRequest request = new OrderCancelRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderCancel request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orderCancel/getOrderCancel";
        OrderCancelResponse response = super.getRestTemplate().postForObject(url, request, OrderCancelResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderCancel url: " + url);
            LOG.debug("getOrderCancel response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    /**
     * 获取取消了的订单列表
     * @param requestDto
     * @return
     */
    public List<OrderCancelResponseDto> queryFrontOrderCancelListWithPage(OrderCancelRequestDto requestDto,PageUtil pageUtil){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("queryFrontOrderCancelListWithPage request: " + JsonHelper.toJson(requestDto));
        }
    	OrderCancelRequest request = new OrderCancelRequest(super.getKey(), requestDto);
    	List<OrderCancelResponseDto> responseDtoList = null;
    	OrderCancelResponseList responseList = null;
    	String url = null;
    	try {
    		int totalRow;
    		 url = super.getServiceUrlDomain() + "services/orderCancel/queryFrontOrderCancelListWithPage";
    		 responseList = super.getRestTemplate().postForObject(url, request, OrderCancelResponseList.class);
    		 responseDtoList = responseList.getResult();
    		 totalRow = responseList.getPageUtil().getTotalRow();
    		 pageUtil.setTotalRow(totalRow);
    		 pageUtil.init();
		} catch (Exception e) {
			LOG.error("#OrderCancelClient.queryFrontOrderCancelListWithPage# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("queryFrontOrderCancelListWithPage url: " + url);
            LOG.debug("queryFrontOrderCancelListWithPage responseList: " + JsonHelper.toJson(responseList));
        }
		return responseDtoList;
    }
}
