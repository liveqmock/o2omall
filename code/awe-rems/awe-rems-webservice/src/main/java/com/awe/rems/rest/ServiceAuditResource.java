package com.awe.rems.rest;

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
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.sdk.api.request.ServiceAuditRequest;
import com.awe.rems.sdk.api.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.api.response.dto.ServiceAuditResponseDto;
import com.awe.rems.service.ServiceAuditService;

/**
 * 退换货审核流表REST服务：提供有关退换货审核流表的接口
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServiceAuditResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ServiceAuditService serviceAuditService; 

    /**
     * 查询退换货审核流表信息
     * 
     * @param request
     *            退换货审核流表请求参数
     * @return 退换货审核流表返回对象
     * 
     */
    @POST
    @Path("/serviceAudit/getServiceAudit")
    public Wrapper<?> getServiceAudit(ServiceAuditRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getServiceAudit 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        ServiceAuditRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getServiceAudit 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            ServiceAudit serviceAudit = serviceAuditService.getServiceAuditById(requestDto.getId());
            ServiceAuditResponseDto responseDto = convert(serviceAudit);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询退换货审核流表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private ServiceAuditResponseDto convert(ServiceAudit serviceAudit) {
        if (null == serviceAudit) {
            return null;
        }

        ServiceAuditResponseDto serviceAuditResponseDto = new ServiceAuditResponseDto();
        BeanUtils.copyProperties(serviceAudit, serviceAuditResponseDto);
        return serviceAuditResponseDto;
    }

    // 数据转换
    private List<ServiceAuditResponseDto> convertList(List<ServiceAudit> serviceAudits) {
        if (CollectionUtils.isEmpty(serviceAudits)) {
            return null;
        }

        List<ServiceAuditResponseDto> list = new ArrayList<ServiceAuditResponseDto>(serviceAudits.size());
        for (ServiceAudit serviceAudit : serviceAudits) {
            list.add(convert(serviceAudit));
        }
        return list;
    } 

}
