package com.awe.pms.controller;
   

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.pms.controller.base.BaseController;
import com.awe.pms.service.AreaService;
import com.awe.uc.sdk.request.dto.AreaRequestDto;
import com.awe.uc.sdk.response.dto.AreaResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ProductBrandController ：商品类别品牌控制器
 * 
 * @author zhc
 * @version 2014-12-25 14:47:32
*/
@Controller
@RequestMapping("area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

    private static final Log LOG = LogFactory.getLog(AreaController.class);

    /**
     * 地址信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
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
