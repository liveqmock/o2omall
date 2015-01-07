package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProductService;
import com.awe.pms.sdk.ProductClient;
import com.awe.pms.sdk.request.dto.ProductRequestDto;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-7 下午03:49:15 
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private final static Log LOG = LogFactory.getLog(ProductServiceImpl.class);
	
	@Autowired
	private ProductClient productClient;

	public ProductResponseDto getProduct(ProductRequestDto requestDto) {
		ProductResponseDto responseDto = null;
		try {
			responseDto = this.productClient.getProduct(requestDto);
		} catch (Exception e) {
			LOG.warn("getProduct has error,", e);
		}
		return responseDto;
	}

	public ProductResponseDto getProductBySkuNo(ProductSkuRequestDto requestDto) {
		ProductResponseDto responseDto = null;
		try {
			responseDto = this.productClient.getProductBySkuNo(requestDto);
		} catch (Exception e) {
			LOG.warn("getProductBySkuNo has error,", e);
		}
		return responseDto;
	}

	public List<ProductResponseDto> queryProducts(ProductRequestDto requestDto) {
		List<ProductResponseDto> list = null;
		try {
			list = this.productClient.getProducts(requestDto);
		} catch (Exception e) {
			LOG.warn("queryProducts has error,", e);
		}
		return list;
	}

}
