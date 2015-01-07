package com.awe.mall.service;

import java.util.List;

import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 购物车
 * @author zyq
 * @version 1.0.0
 * @since 2015-1-4
 */
public interface ShoppingCartService {

	/**
	 * 购物车列表数据获取
	 * @param requestDto
	 * @return
	 */
	public List<ShoppingCartResponseDto> queryShoppingCartList(ShoppingCartRequestDto requestDto);
	
	/**
	 * 删除购物车指定商品数据
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> deleteShoppingCart(ShoppingCartRequestDto requestDto);
	
	/**
	 * 添加购物车
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> addShoppingCart(ShoppingCartRequestDto requestDto);
	/**
	 * 更新购物车数据
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> updateShoppingCart(ShoppingCartRequestDto requestDto);
}
