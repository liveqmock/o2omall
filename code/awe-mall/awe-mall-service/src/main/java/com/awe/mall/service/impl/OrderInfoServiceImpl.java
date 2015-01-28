package com.awe.mall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
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
import com.awe.order.sdk.response.OrdersResponse;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.awe.pay.sdk.TradeClient;
import com.awe.pay.sdk.request.dto.TradeRequestDto;
import com.awe.pms.sdk.ProductClient;
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
	private ProductClient productClient;
	@Autowired
	private OrdersClient ordersClient;
	@Autowired
	private TradeClient tradeClient;
	
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
	public Wrapper<?> addOrderDetails(OrdersRequestDto requestDto, String skuName, String skuNo,String skuCount,String ip) {
		String[] skuno=skuNo.split(",");
		String[] count=skuCount.split(",");
		OrderDetailsRequestDto detailsRequestDto = new OrderDetailsRequestDto();

		Map<String,String> countMap = new HashMap<String, String>();
		List<OrderInfo> listOrderInfos = new ArrayList<OrderInfo>();
		for (int i = 0; i < skuno.length; i++) {
			countMap.put(skuno[i], count[i]);
		}
		detailsRequestDto.setOrdersRequestDto(requestDto);
		detailsRequestDto.setMapSC(countMap);
		detailsRequestDto.setIpString(ip);
		
		try {
			Wrapper<?> wrapper = ordersClient.addOrdersDetails(detailsRequestDto);
			 if(wrapper.getCode() == 200){
				 return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, wrapper.getResult());
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

	/**
     * {@inheritDoc}支付
     */
	public Wrapper<?> payOrders(OrdersRequestDto requestDto,String name,Long userId) {
		TradeRequestDto tradeRequestDto = new TradeRequestDto();
		List<TradeRequestDto> listtradeDtos = new ArrayList<TradeRequestDto>();
		//1:根据订单号查询订单信息
		try {
			LOG.info("OrderInfoServiceImpl payOrders====》param》orderNo》"+requestDto.getOrderNo());
			String[] orderNo=requestDto.getOrderNo().split(",");
			List<String> listOrders = new ArrayList<String>();
			List<OrdersResponseDto> list = new ArrayList<OrdersResponseDto>();
			for (int i=0;i<orderNo.length;i++) {
				OrdersRequestDto dto = new OrdersRequestDto();
				OrdersResponseDto responseDto = new OrdersResponseDto();
				dto.setOrderNo(orderNo[i]);
				listOrders.add(orderNo[i]);//
				responseDto = ordersClient.getOrders(dto);
				list.add(responseDto);
			}
			
			//处理数据
			for(OrdersResponseDto ordersResponseDto : list) {
				TradeRequestDto trade = new TradeRequestDto();
				trade.setLoginNo(String.valueOf(userId));//账号
				trade.setLoginName(name);//账号姓名
				trade.setChannelNo(10000l);//通道编号
				trade.setChannelName("通过名称");
				trade.setOrderNo(ordersResponseDto.getOrderNo());//订单号
				trade.setBusinessName(ordersResponseDto.getSeller());//商家名称
				trade.setBusinessNo(ordersResponseDto.getSellerNo());//商家编号
				trade.setAmount(ordersResponseDto.getCommAmount());
				trade.setTradeTime(new Date());//支付时间
				Random random = new Random(9999);
				trade.setSerialNo(String.valueOf(random.nextInt()));//交易流水号
				trade.setStatus(200);
				trade.setAccountNo("我不知道我不知道啊。。");
				trade.setAccountName("曲曲折折。。。");
				trade.setCreateUser(name);
				trade.setUpdateUserId(userId);
				trade.setCreateTime(new Date());
				trade.setYn(1);
				listtradeDtos.add(trade);		
			}
			tradeRequestDto.setTradeRequestDtoList(listtradeDtos);
			Wrapper<?> wrapper = tradeClient.addBatchTrade(tradeRequestDto);
			requestDto.setListOrders(listOrders);
			requestDto.setUpdateUser(name);
			if(wrapper.getCode() == 200){
				//改变订单状态
				ordersClient.updateBatchOrders(requestDto);
				
			 return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, wrapper.getResult());
			}else{
			 return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "提交失败");
			}
		} catch (Exception e) {
			 return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "提交异常");
		}
	}

	/**
     * {@inheritDoc}
     */
	public Wrapper<?> queryOrderNo(OrdersRequestDto requestDto) {
		String[] orderNo=requestDto.getOrderNo().split(",");
		LOG.info("mall 跟订单号查询订单信息"+orderNo);
		double countPrice = 0.0;
		List<OrdersRequestDto> list = new ArrayList<OrdersRequestDto>();
		try {
			for (int i = 0; i < orderNo.length; i++) {
				OrdersRequestDto dto = new OrdersRequestDto();
				OrdersResponseDto responseDto = new OrdersResponseDto();
				dto.setOrderNo(orderNo[i]);
				responseDto = ordersClient.getOrders(requestDto);
				BeanUtils.copyProperties(responseDto, dto);
				list.add(dto);
			}
			LOG.info("传的订单号和返回的值长度是否一样==参数》"+orderNo.length+"===返回值==>"+list.size());
			if(orderNo.length != list.size()){
				return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "查询失败");
			}else{
				//算总价
				for (OrdersRequestDto ordersRequestDto : list) {
					countPrice += ordersRequestDto.getCommAmount();
				}
				return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, countPrice);
			}
		} catch (Exception e) {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.SUCCESS_MESSAGE, "查询异常");
		}		
	}
}
