package com.awe.uc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.awe.uc.domain.Area;
import com.awe.uc.sdk.api.request.AreaRequest;
import com.awe.uc.sdk.api.request.dto.AreaRequestDto;
import com.awe.uc.sdk.api.response.dto.AreaResponseDto;
import com.awe.uc.service.AreaService;

/**
 * 三级地址REST服务：提供有关三级地址的接口
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AreaResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private AreaService areaService; 

    /**
     * 查询三级地址信息
     * 
     * @param request
     *            三级地址请求参数
     * @return 三级地址返回对象
     * 
     */
    @POST
    @Path("/area/getArea")
    public Wrapper<?> getArea(AreaRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getArea 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        AreaRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getArea 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            Area area = areaService.getAreaById(requestDto.getId());
            AreaResponseDto responseDto = convert(area);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询三级地址数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private AreaResponseDto convert(Area area) {
        if (null == area) {
            return null;
        }

        AreaResponseDto areaResponseDto = new AreaResponseDto();
        BeanUtils.copyProperties(area, areaResponseDto);
        return areaResponseDto;
    }

    // 数据转换
    private List<AreaResponseDto> convertList(List<Area> areas) {
        if (CollectionUtils.isEmpty(areas)) {
            return null;
        }

        List<AreaResponseDto> list = new ArrayList<AreaResponseDto>(areas.size());
        for (Area area : areas) {
            list.add(convert(area));
        }
        return list;
    } 

}
