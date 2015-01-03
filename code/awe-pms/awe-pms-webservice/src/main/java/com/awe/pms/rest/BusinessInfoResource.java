package com.awe.pms.rest;

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
import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.sdk.api.request.BusinessInfoRequest;
import com.awe.pms.sdk.api.request.dto.BusinessInfoRequestDto;
import com.awe.pms.sdk.api.response.dto.BusinessInfoResponseDto;
import com.awe.pms.service.BusinessInfoService;

/**
 * 商家信息REST服务：提供有关商家信息的接口
 * 
 * @author ljz
 * @version 2014-12-30 16:41:55
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BusinessInfoResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private BusinessInfoService businessInfoService; 

    /**
     * 查询商家信息信息
     * 
     * @param request
     *            商家信息请求参数
     * @return 商家信息返回对象
     * 
     */
    @POST
    @Path("/businessInfo/getBusinessInfo")
    public Wrapper<?> getBusinessInfo(BusinessInfoRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getBusinessInfo 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        BusinessInfoRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getBusinessInfo 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            BusinessInfo businessInfo = businessInfoService.getBusinessInfoById(requestDto.getId());
            BusinessInfoResponseDto responseDto = convert(businessInfo);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询商家信息数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private BusinessInfoResponseDto convert(BusinessInfo businessInfo) {
        if (null == businessInfo) {
            return null;
        }

        BusinessInfoResponseDto businessInfoResponseDto = new BusinessInfoResponseDto();
        BeanUtils.copyProperties(businessInfo, businessInfoResponseDto);
        return businessInfoResponseDto;
    }

    // 数据转换
    private List<BusinessInfoResponseDto> convertList(List<BusinessInfo> businessInfos) {
        if (CollectionUtils.isEmpty(businessInfos)) {
            return null;
        }

        List<BusinessInfoResponseDto> list = new ArrayList<BusinessInfoResponseDto>(businessInfos.size());
        for (BusinessInfo businessInfo : businessInfos) {
            list.add(convert(businessInfo));
        }
        return list;
    } 

}
