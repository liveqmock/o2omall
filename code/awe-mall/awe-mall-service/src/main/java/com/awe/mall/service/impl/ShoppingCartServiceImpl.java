package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ShoppingCartService;
import com.awe.order.sdk.ShoppingCartClient;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.hbird.common.utils.wrap.Wrapper;
/**
 * 购物车
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	private static final Log LOG = LogFactory.getLog(ShoppingCartServiceImpl.class);
	
	@Autowired
	private ShoppingCartClient shoppingCartClient;
	/**
     * {@inheritDoc}
     */
	public List<ShoppingCartResponseDto> queryShoppingCartList(ShoppingCartRequestDto requestDto) {
		List<ShoppingCartResponseDto> responseDtoList = null;
		try {
			//responseDtoList = shoppingCartClient.queryShoppingCartList(requestDto);
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.queryShoppingCartList# Error:" + e);
		}
		return responseDtoList;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> deleteShoppingCart(ShoppingCartRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = shoppingCartClient.deleteShoppingCart(requestDto);
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.deleteShoppingCartById# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> addShoppingCart(ShoppingCartRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = shoppingCartClient.addShoppingCart(requestDto);
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.addShoppingCart# Error:" + e);
		}
		return wrapper;
	}
	/**
     * {@inheritDoc}
     */
	public Wrapper<?> updateShoppingCart(ShoppingCartRequestDto requestDto) {
		Wrapper<?> wrapper = null;
		try {
			wrapper = shoppingCartClient.updateShoppingCart(requestDto);
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.updateShoppingCart# Error:" + e);
		}
		return wrapper;
	}

}
