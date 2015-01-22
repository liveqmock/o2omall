package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.ProductSelectService;
import com.awe.pms.sdk.ProductSelectClient;
import com.awe.pms.sdk.request.dto.ProductSelectRequestDto;
import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;
import com.hbird.common.utils.page.PageUtil;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-7 下午03:49:15 
 */
@Service
public class ProductSelectServiceImpl implements ProductSelectService {
	
	private final static Log LOG = LogFactory.getLog(ProductSelectServiceImpl.class);
	
	@Autowired
	private ProductSelectClient productSelectClient;

	public List<ProductSelectResponseDto> queryProductSelects(ProductSelectRequestDto requestDto) {
		List<ProductSelectResponseDto> list = null;
		try {
			list = this.productSelectClient.getProductSelects(requestDto);
		} catch (Exception e) {
			LOG.warn("queryProductSelects has error,", e);
		}
		return list;
	}

	public List<ProductSelectResponseDto> getProductSelectsWithPage(ProductSelectRequestDto requestDto,
			PageUtil pageUtil) {
		List<ProductSelectResponseDto> list = null;
		try {
			list = this.productSelectClient.getProductSelectsWithPage(requestDto, pageUtil);
		} catch (Exception e) {
			LOG.warn("getProductSelectsWithPage has error,", e);
		}
		return list;
	}

}
