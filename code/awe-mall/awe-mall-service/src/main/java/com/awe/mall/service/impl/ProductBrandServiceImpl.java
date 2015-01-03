package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProductBrandService;
import com.awe.pms.sdk.ProductBrandClient;
import com.awe.pms.sdk.request.dto.ProductBrandRequestDto;
import com.awe.pms.sdk.response.dto.ProductBrandResponseDto;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-3 下午01:13:19 
 */
@Service
public class ProductBrandServiceImpl implements ProductBrandService {
	
	private final static Log LOG = LogFactory.getLog(ProductBrandServiceImpl.class);
	
	@Autowired
	private ProductBrandClient productBrandClient;

	public ProductBrandResponseDto getProductBrandById(ProductBrandRequestDto requestDto) {
		ProductBrandResponseDto brandResponseDto = null;
		try {
			brandResponseDto = this.productBrandClient.getProductBrand(requestDto);
		} catch (Exception e) {
			LOG.warn("getProductBrandById has error,", e);
		}
		return brandResponseDto;
	}

	public List<ProductBrandResponseDto> queryProductBrandList(ProductBrandRequestDto requestDto) {
		List<ProductBrandResponseDto> list = null;
		try {
			list = this.productBrandClient.getProductBrands(requestDto);
		} catch (Exception e) {
			LOG.warn("queryProductBrandList has error,", e);
		}
		return list;
	}

}
