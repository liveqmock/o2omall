package com.awe.mall.service;

import java.util.List;

import com.awe.uc.sdk.response.dto.AreaResponseDto;


/**
 * 三级地址服务
 * 
 * @author ljz，js
 * @version 2014-12-23 10:06:48
 * 
 */
public interface AreaService {

	/**
	 * 获取所有省
	 * 
	 * @return
	 */
	List<AreaResponseDto> getProvinces();

	/**
	 * 获取省下面的所有市
	 * 
	 * @param provinceCode
	 *            省编码
	 * @return
	 */
	List<AreaResponseDto> getCities(String provinceCode);

	/**
	 * 获取市下面的所有县
	 * 
	 * @param cityCode
	 *            市编码
	 * @return
	 */
	List<AreaResponseDto> getCountys(String cityCode);

}