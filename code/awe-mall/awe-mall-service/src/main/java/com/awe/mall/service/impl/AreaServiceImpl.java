package com.awe.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.mall.service.AreaService;
import com.awe.uc.sdk.AreaClient;
import com.awe.uc.sdk.response.dto.AreaResponseDto;

/**
 * 三级地址服务
 * 
 * @author ljz,js
 * @version 2014-12-23 10:06:48
 * 
 */
@Service
public class AreaServiceImpl implements AreaService {

	private final static Log LOG = LogFactory.getLog(AreaServiceImpl.class);

	@Autowired
	private AreaClient areaClient;

	/**
	 * {@inheritDoc}
	 */
	public List<AreaResponseDto> getProvinces() {
		List<AreaResponseDto> list = null;
		try {
			list = areaClient.getProvinces();
		} catch (Exception e) {
			LOG.warn("getProvinces has error,", e);
		}
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AreaResponseDto> getCities(String provinceCode) {
		List<AreaResponseDto> list = null;
		try {
			list = areaClient.getCities(provinceCode);
		} catch (Exception e) {
			LOG.warn("getCities has error,", e);
		}
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AreaResponseDto> getCountys(String cityCode) {
		List<AreaResponseDto> list = null;
		try {
			list = areaClient.getCounties(cityCode);
		} catch (Exception e) {
			LOG.warn("getCountys has error,", e);
		}
		return list;
	}

}