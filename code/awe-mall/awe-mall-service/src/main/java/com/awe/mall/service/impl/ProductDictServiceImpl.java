package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProductDictService;
import com.awe.pms.sdk.ProductDictClient;
import com.awe.pms.sdk.request.dto.ProductDictRequestDto;
import com.awe.pms.sdk.response.dto.ProductDictResponseDto;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-17 下午09:41:50 
 */
@Service
public class ProductDictServiceImpl implements ProductDictService {
	
	private final static Log LOG = LogFactory.getLog(ProductDictServiceImpl.class);
	
	@Autowired
	private ProductDictClient productDictClient;

	public ProductDictResponseDto getProductDict(ProductDictRequestDto requestDto) {
		ProductDictResponseDto brandResponseDto = null;
		try {
			brandResponseDto = this.productDictClient.getProductDict(requestDto);
		} catch (Exception e) {
			LOG.warn("getProductDict has error,", e);
		}
		return brandResponseDto;
	}

	public List<ProductDictResponseDto> queryProductDictList(ProductDictRequestDto requestDto) {
		List<ProductDictResponseDto> list = null;
		try {
			list = this.productDictClient.getAllProductDict(requestDto);
		} catch (Exception e) {
			LOG.warn("queryProductBrandList has error,", e);
		}
		return list;
	}

}
