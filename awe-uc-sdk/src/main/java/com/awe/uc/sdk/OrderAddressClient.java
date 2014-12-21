package com.awe.uc.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.uc.sdk.response.dto.OrderAddressDto;
import com.awe.uc.sdk.request.OrderAddressRequest;
import com.awe.uc.sdk.response.OrderAddressResponse;

/**
 * 收货地址表服务的客户端
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:59
 * 
 */
public class OrderAddressClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(OrderAddressClient.class);

    /**
     * 收货地址表查询服务
     * 
     * @param request
     *            查询请求对象
     * @return OrderAddressDto 对象
     */
    public OrderAddressDto getOrderAddress(OrderAddressRequest request) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderAddress request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/orderAddress/getOrderAddress";
        OrderAddressResponse response = super.getRestTemplate().postForObject(url, request, OrderAddressResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getOrderAddress url: " + url);
            LOG.debug("getOrderAddress response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
