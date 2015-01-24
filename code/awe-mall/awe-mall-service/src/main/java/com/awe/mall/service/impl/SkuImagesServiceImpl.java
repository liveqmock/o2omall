package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.SkuImagesService;
import com.awe.pms.sdk.SkuImagesClient;
import com.awe.pms.sdk.request.dto.SkuImagesRequestDto;
import com.awe.pms.sdk.response.dto.SkuImagesResponseDto;

/**
 * @author zhc
 * @email  you know
 * @version 2015-1-7 下午03:49:15 
 */
@Service
public class SkuImagesServiceImpl implements SkuImagesService {
	
	private final static Log LOG = LogFactory.getLog(SkuImagesServiceImpl.class);
	
	@Autowired
	private SkuImagesClient skuImagesClient;

	public List<SkuImagesResponseDto> querySkuImageList(SkuImagesRequestDto requestDto) {
		List<SkuImagesResponseDto> list = null;
		try {
			list = this.skuImagesClient.getSkuImageList(requestDto);
		} catch (Exception e) {
			LOG.warn("querySkuImageList has error,", e);
		}
		return list;  
	}

}
