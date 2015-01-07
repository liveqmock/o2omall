package com.awe.order.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.order.sdk.request.ShoppingCartRequest;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.ShoppingCartResponse;
import com.awe.order.sdk.response.ShoppingCartResponseList;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

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
    /**
     * 购物车列表数据获取
     * @param requestDto
     * @return
     */
    public List<ShoppingCartResponseDto> queryShoppingCartList(ShoppingCartRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("queryShoppingCartList request: " + JsonHelper.toJson(requestDto));
        }
    	ShoppingCartRequest request = new ShoppingCartRequest(super.getKey(), requestDto);
    	ShoppingCartResponseList responseList = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/shoppingCart/queryShoppingCartList";
    		 responseList = super.getRestTemplate().postForObject(url, request, ShoppingCartResponseList.class);
		} catch (Exception e) {
			LOG.error("#ShoppingCartClient.queryShoppingCartList# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("queryShoppingCartList url: " + url);
            LOG.debug("queryShoppingCartList response: " + JsonHelper.toJson(responseList));
        }
		return super.getResult(responseList);
    }
    /**
     * 删除购物车指定商品数据
     * @param requestDto
     * @return
     */
    public Wrapper<?> deleteShoppingCart(ShoppingCartRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("deleteShoppingCart request: " + JsonHelper.toJson(requestDto));
        }
    	ShoppingCartRequest request = new ShoppingCartRequest(super.getKey(), requestDto);
    	ShoppingCartResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/shoppingCart/deleteShoppingCart";
    	     response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
		} catch (Exception e) {
			LOG.error("#ShoppingCartClient.deleteShoppingCart# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("deleteShoppingCart url: " + url);
            LOG.debug("deleteShoppingCart response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 添加购物车
     * @param requestDto
     * @return
     */
    public Wrapper<?> addShoppingCart(ShoppingCartRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("addShoppingCart request: " + JsonHelper.toJson(requestDto));
        }
    	ShoppingCartRequest request = new ShoppingCartRequest(super.getKey(), requestDto);
    	ShoppingCartResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/shoppingCart/addShoppingCart";
    	     response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
		} catch (Exception e) {
			LOG.error("#ShoppingCartClient.addShoppingCart# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("addShoppingCart url: " + url);
            LOG.debug("addShoppingCart response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
    /**
     * 更新购物车数据
     * @param requestDto
     * @return
     */
    public Wrapper<?> updateShoppingCart(ShoppingCartRequestDto requestDto){
    	if (LOG.isDebugEnabled()) {
            LOG.debug("updateShoppingCart request: " + JsonHelper.toJson(requestDto));
        }
    	ShoppingCartRequest request = new ShoppingCartRequest(super.getKey(), requestDto);
    	ShoppingCartResponse response = null;
    	String url = null;
    	try {
    		 url = super.getServiceUrlDomain() + "services/shoppingCart/updateShoppingCart";
    	     response = super.getRestTemplate().postForObject(url, request, ShoppingCartResponse.class);
		} catch (Exception e) {
			LOG.error("#ShoppingCartClient.updateShoppingCart# ERROR:" + e);
		}
		if (LOG.isDebugEnabled()) {
            LOG.debug("updateShoppingCart url: " + url);
            LOG.debug("updateShoppingCart response: " + JsonHelper.toJson(response));
        }
		if (null != response) {
            return WrapMapper.wrap(response.getCode(), response.getMessage());
        } else {
            return WrapMapper.error();
        }
    }
}
