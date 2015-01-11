package com.awe.mall.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.AreaService;
import com.awe.uc.sdk.request.dto.AreaRequestDto;
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
	
	/**
	 * 查询县
	 * Date:2015年1月4日下午8:18:43
	 * user:js
	 * @param CityNo
	 * @return
	 */
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
	
	/**
     * 地址信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Wrapper<?> query(AreaRequestDto query) {
        try {
        	if (query != null && query.getLevel() != null) {
        		List<AreaResponseDto> list = this.areaService.getAreas(query);
        		if (!CollectionUtils.isEmpty(list)) {
        			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
        		}
        	}
        	return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询地址信息失败！");
        } catch (Exception e) {
            LOG.error("productBrand query has error.", e);
            return WrapMapper.error();
        }
    }
}
