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
import com.hbird.common.utils.wrap.WrapMapper;
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
	public Wrapper<?> addOrderDetails(OrdersRequestDto requestDto, String skuName, String skuNo,String skuCount) {
		String[] name=skuName.split(",");
		String[] skuno=skuNo.split(",");
		String[] count=skuCount.split(",");
		OrderDetailsRequestDto detailsRequestDto =  new OrderDetailsRequestDto();
		//订单基本属性
		detailsRequestDto.setOrdersRequestDto(requestDto);
		//订单item集合
		List<OrdersItemsRequestDto> listRequestDtos = new ArrayList<OrdersItemsRequestDto>();
		//把skuno封装到list中
		List<String> skunos = new ArrayList<String>();
		//调用恒冲商品接口对象
		ProductSkuRequestDto skuRequestDto= new ProductSkuRequestDto();
		//存放skuno 和 数量
		Map<String,String> countMap = new HashMap<String, String>();
		List<OrderInfo> listOrderInfos = new ArrayList<OrderInfo>();
		for (int i = 0; i < skuno.length; i++) {
			skunos.add(skuno[i]);
			countMap.put(skuno[i], count[i]);
		}
		skuRequestDto.setSkuNos(skunos);
		List<ProductSkuResponseDto> listSkus = productSkuClient.getProductSkus(skuRequestDto);
		try {
			for (int i = 0; i < skuno.length; i++) {
				OrdersItemsRequestDto itemsRequestDto = new OrdersItemsRequestDto();
				itemsRequestDto.setOrderNo(requestDto.getOrderNo());
				itemsRequestDto.setSkuName(name[i]);
				itemsRequestDto.setSkuNo(skuno[i]);
				itemsRequestDto.setSkuPrice(queryOrderPrice(listSkus,skuno[i]));
				System.out.println(count[i]);
				itemsRequestDto.setCount(Integer.valueOf(count[i]));
				itemsRequestDto.setCreateUser(requestDto.getCreateUser());
				listRequestDtos.add(itemsRequestDto);
			}
			detailsRequestDto.setListOrdersItemsRequestDto(listRequestDtos);
			 Wrapper<?> wrapper = ordersClient.addOrdersDetails(detailsRequestDto);
			 if(wrapper.getCode() == 200){
			 for (ProductSkuResponseDto productSkuResponseDto : listSkus) {
				 OrderInfo info = new OrderInfo();
				 BeanUtils.copyProperties(productSkuResponseDto,info);
				 listOrderInfos.add(info);
			  }
			 for (OrderInfo orderInfo : listOrderInfos) {
					if(countMap.get(orderInfo.getSkuNo()) != null){
						orderInfo.setSkuCount(Integer.valueOf(countMap.get(orderInfo.getSkuNo())));
					}
				}
			 return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, listOrderInfos);
			 }else{
			  return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "提交失败");
			 }
		} catch (Exception e) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "提交异常");
		}
	}

	/**根据商品编号返回商品单价*/
	private Double queryOrderPrice(List<ProductSkuResponseDto> listSkus,String skuNo) {
		Double priceStr = 0.0;
		for(ProductSkuResponseDto productSkuResponseDto : listSkus) {
			if(productSkuResponseDto.getSkuNo().equals(skuNo)){
				priceStr = productSkuResponseDto.getPrice();
				break;
			}
		}
		return priceStr;
	}
}
