package com.awe.mall.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.order.sdk.response.dto.ShoppingCartResponseDto;
import com.hbird.common.client.AbstractClient;

public class ShoppingCartServiceImplTestCase  extends AbstractClient{
	private static final Log LOG = LogFactory.getLog(ShoppingCartServiceImplTestCase.class);
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Test
	public void testQueryShoppingCartList(){
		ShoppingCartRequestDto requestDto = new ShoppingCartRequestDto();
		requestDto.setUserId(1L);
		List<ShoppingCartResponseDto> responseDtoList = shoppingCartService.queryShoppingCartList(requestDto);
		LOG.info("responseDtoList:::" + responseDtoList.size());
	}
}
