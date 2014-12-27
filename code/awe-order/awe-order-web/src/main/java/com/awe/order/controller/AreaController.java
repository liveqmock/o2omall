package com.awe.order.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.order.controller.base.BaseController;
import com.awe.order.service.AreaService;
import com.awe.uc.sdk.response.dto.AreaResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 
 *AreaController ： 省市县控制器	
 *
 * @author js
 * @version：2014年12月27日 下午12:56:39
 */
@Controller
@RequestMapping("area")
public class AreaController extends BaseController{

	@Autowired
	private AreaService areaService;
				
	private static final Log LOG = LogFactory.getLog(AreaController.class);
	
	/**
	 * 查询 省
	 * Date:2014年12月27日下午1:00:18
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryProvince")
	@ResponseBody
	public Wrapper<?> queryProvince(){
		try {
			List<AreaResponseDto> list = areaService.getProvinces();
			if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("area queryProvinceNo has error.", e);
	         return WrapMapper.error();
		}
	}
	
	
	/**
	 * 查询市
	 * Date:2014年12月27日下午1:06:02
	 * user:js
	 * @return
	 */
	@RequestMapping(value = "queryCityNo")
	@ResponseBody
	public Wrapper<?> queryCityNo(String provinceNO){
		try {
			List<AreaResponseDto> list = areaService.getCities(provinceNO);
			if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("area queryCityNo has error.", e);
	         return WrapMapper.error();
		}
	}
	
	
	@RequestMapping(value = "queryCountyNo")
	@ResponseBody
	public Wrapper<?> queryCountyNo(String CityNo){
		try {
			List<AreaResponseDto> list = areaService.getCountys(CityNo);
			if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
		} catch (Exception e) {
			 LOG.error("area queryCityNo has error.", e);
	         return WrapMapper.error();
		}
	}
	
}
