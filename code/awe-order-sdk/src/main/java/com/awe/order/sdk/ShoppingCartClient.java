package com.awe.order.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.common.client.AbstractClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.awe.order.sdk.request.ShoppingCartRequest;
import com.awe.order.sdk.response.ShoppingCartResponse;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;

/**
 * 购物车服务的客户端
 * 
 * @author ljz
 * @version 2014-12-23 10:58:10
 * 
 */
public class ShoppingCartClient extends AbstractClient {
    
    private final static Log LOG = LogFactory.getLog(ShoppingCartClient.class);

    /**
     * 购物车查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ShoppingCartDto 对象
     */
    public ShoppingCartResponseDto getShoppingCart(ShoppingCartRequest request) {
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
