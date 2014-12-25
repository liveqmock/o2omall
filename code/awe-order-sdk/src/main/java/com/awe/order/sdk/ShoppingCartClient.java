package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.ShoppingCartRequest;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.ShoppingCartResponse;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;

/**
 * 购物车服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:52:58
 * 
 */
public class ShoppingCartClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ShoppingCartClient.class);

    /**
     * 购物车查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ShoppingCartResponseDto 接口返回的数据对象
     */
    public ShoppingCartResponseDto getShoppingCart(ShoppingCartRequestDto requestDto) {
        Assert.notNull(requestDto);

        ShoppingCartRequest request = new ShoppingCartRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getShoppingCart request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/shoppingCart/getShoppingCart";
        ShoppingCartResponse response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getShoppingCart url: " + url);
            LOG.debug("getShoppingCart response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
}
