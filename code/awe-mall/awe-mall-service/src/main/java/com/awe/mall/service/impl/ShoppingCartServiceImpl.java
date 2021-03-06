package com.awe.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ShoppingCartService;
import com.awe.order.sdk.ShoppingCartClient;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.awe.pms.sdk.ProductSkuClient;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;
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
	@Autowired
	private ProductSkuClient productSkuClient;
	/**
     * {@inheritDoc}
     */
	public List<ShoppingCartResponseDto> queryShoppingCartList(ShoppingCartRequestDto requestDto) {
		List<ShoppingCartResponseDto> responseDtoList = null;
		List<ShoppingCartResponseDto> dataList = new ArrayList<ShoppingCartResponseDto>();
		try {
			responseDtoList = shoppingCartClient.queryShoppingCartList(requestDto);
			for (ShoppingCartResponseDto shoppingCartResponseDto : responseDtoList) {
				ProductSkuRequestDto skuRequestDto = new ProductSkuRequestDto();
				skuRequestDto.setSkuNo(shoppingCartResponseDto.getSkuNo());
				ProductSkuResponseDto productSkuResponseDto = productSkuClient.getProductSku(skuRequestDto);
				BeanUtils.copyProperties(productSkuResponseDto, shoppingCartResponseDto);
				dataList.add(shoppingCartResponseDto);
			}
		} catch (Exception e) {
			LOG.error("#ShoppingCartServiceImpl.queryShoppingCartList# Error:" + e);
		}
		return dataList;
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
