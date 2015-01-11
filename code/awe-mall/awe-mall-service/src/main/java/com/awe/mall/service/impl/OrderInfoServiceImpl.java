package com.awe.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.domain.dto.OrderInfo;
import com.awe.mall.service.OrderInfoService;
import com.awe.order.sdk.OrdersClient;
import com.awe.order.sdk.request.dto.OrderDetailsRequestDto;
import com.awe.order.sdk.request.dto.OrdersItemsRequestDto;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.request.dto.ShoppingCartRequestDto;
import com.awe.pms.sdk.ProductSkuClient;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

@SuppressWarnings("all")
@Service
public class OrderInfoServiceImpl implements OrderInfoService{

	private static final Log LOG = LogFactory.getLog(OrderInfoServiceImpl.class);
	
	@Autowired
	private ProductSkuClient productSkuClient;
	@Autowired
	private OrdersClient ordersClient;
	
	/**
     * {@inheritDoc}
     */
	public List<OrderInfo> getOrderInfoBySkuNo(List<ShoppingCartRequestDto> dataList) {
		List<OrderInfo> listOrderInfos = new ArrayList<OrderInfo>();
		ProductSkuRequestDto requestDto = new ProductSkuRequestDto();
		List<String> skunos = new ArrayList<String>();
		Map<String,Integer> countMap = new HashMap<String, Integer>();
		try {
			for(ShoppingCartRequestDto shoppingCartRequestDto : dataList) {
				countMap.put(shoppingCartRequestDto.getSkuNo(), shoppingCartRequestDto.getSkuCount());
				skunos.add(shoppingCartRequestDto.getSkuNo());
			}
			requestDto.setSkuNos(skunos);
			List<ProductSkuResponseDto> listSkus = productSkuClient.getProductSkus(requestDto);
			for (ProductSkuResponseDto productSkuResponseDto : listSkus) {
				OrderInfo info = new OrderInfo();
				BeanUtils.copyProperties(productSkuResponseDto,info);
				listOrderInfos.add(info);
			}
			for (OrderInfo orderInfo : listOrderInfos) {
				if(countMap.get(orderInfo.getSkuNo()) != null){
					orderInfo.setSkuCount(countMap.get(orderInfo.getSkuNo()));
				}
			}
			
		} catch (Exception e) {
			LOG.warn("getOrderInfoBySkuNo has error,", e);
		}
		return listOrderInfos;
		
	}

	/**
     * {@inheritDoc}
     */
	public boolean addOrderDetails(OrdersRequestDto requestDto, String skuName, String skuNo) {
		//ordersClient
		OrderDetailsRequestDto detailsRequestDto =  new OrderDetailsRequestDto();
		OrdersItemsRequestDto itemsRequestDto = new OrdersItemsRequestDto();
		detailsRequestDto.setOrdersRequestDto(requestDto);
		List<OrdersItemsRequestDto> listRequestDtos = new ArrayList<OrdersItemsRequestDto>();
		String[] name=skuName.split(",");
		String[] skuno=skuNo.split(",");
		try {
			for (int i = 0; i < name.length; i++) {
				itemsRequestDto.setOrderNo(requestDto.getOrderNo());
				itemsRequestDto.setSkuName(name[i]);
				itemsRequestDto.setSkuNo(skuno[i]);
				itemsRequestDto.setCreateUser(requestDto.getCreateUser());
				listRequestDtos.add(itemsRequestDto);
			}
			detailsRequestDto.setListOrdersItemsRequestDto(listRequestDtos);
			 Wrapper<?> wrapper = ordersClient.addOrdersDetails(detailsRequestDto);
			 if(wrapper.getCode() == 200){
				 return true;
			 }else{
				 return false;
			 }
		} catch (Exception e) {
			LOG.warn("getOrderInfoBySkuNo has error,", e);
			return false;
		}
	}
}
