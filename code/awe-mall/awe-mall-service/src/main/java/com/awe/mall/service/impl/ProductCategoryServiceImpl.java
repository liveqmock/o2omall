package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProductCategoryService;
import com.awe.pms.sdk.ProductCategoryClient;
import com.awe.pms.sdk.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-3 下午01:13:19 
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	private final static Log LOG = LogFactory.getLog(ProductCategoryServiceImpl.class);
	
	@Autowired
	private ProductCategoryClient productCategoryClient;

	public ProductCategoryResponseDto getProductCategoryById(ProductCategoryRequestDto requestDto) {
		ProductCategoryResponseDto brandResponseDto = null;
		try {
			brandResponseDto = this.productCategoryClient.getProductCategory(requestDto);
		} catch (Exception e) {
			LOG.warn("getProductCategoryById has error,", e);
		}
		return brandResponseDto;
	}

	public List<ProductCategoryResponseDto> queryProductCategoryList(ProductCategoryRequestDto requestDto) {
		List<ProductCategoryResponseDto> list = null;
		try {
			list = this.productCategoryClient.getProductCategorys(requestDto);
		} catch (Exception e) {
			LOG.warn("queryProductCategoryList has error,", e);
		}
		return list;
	}

}
