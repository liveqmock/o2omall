package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.awe.mall.domain.dto.OrderInfo;
import com.awe.mall.service.OrderInfoService;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.pms.sdk.ProductSkuClient;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;

@SuppressWarnings("all")
public class OrderInfoServiceImpl implements OrderInfoService{

	
	private static final Log LOG = LogFactory.getLog(OrderInfoServiceImpl.class);
	@Autowired
	private ProductSkuClient productSkuClient;
	
	public List<OrderInfo> getOrderInfoBySkuNo(List<ShoppingCartRequestDto> dataList) {
		List<ProductSkuResponseDto> listSkuResponseDtos = null;
		for(ShoppingCartRequestDto shoppingCartRequestDto : dataList) {
			ProductSkuRequestDto skuRequestDto = new ProductSkuRequestDto(); 
			skuRequestDto.setSkuNo(shoppingCartRequestDto.getSkuNo());
			ProductSkuResponseDto request = productSkuClient.getProductSku(skuRequestDto);
			listSkuResponseDtos.add(request);
		}
		return null;
		
	}
}
