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
import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.sdk.api.request.BusinessAuditRequest;
import com.awe.pms.sdk.api.request.dto.BusinessAuditRequestDto;
import com.awe.pms.sdk.api.response.dto.BusinessAuditResponseDto;
import com.awe.pms.service.BusinessAuditService;

/**
 * 审核商家流水表REST服务：提供有关审核商家流水表的接口
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BusinessAuditResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private BusinessAuditService businessAuditService; 

    /**
     * 查询审核商家流水表信息
     * 
     * @param request
     *            审核商家流水表请求参数
     * @return 审核商家流水表返回对象
     * 
     */
    @POST
    @Path("/businessAudit/getBusinessAudit")
    public Wrapper<?> getBusinessAudit(BusinessAuditRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getBusinessAudit 拒绝访问");
            return WrapMapper.forbidden();
        }
        
        BusinessAuditRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getBusinessAudit 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            BusinessAudit businessAudit = businessAuditService.getBusinessAuditById(requestDto.getId());
            BusinessAuditResponseDto responseDto = convert(businessAudit);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询审核商家流水表数据异常", e);
            return WrapMapper.error();
        }
    } 

    // 数据转换
    private BusinessAuditResponseDto convert(BusinessAudit businessAudit) {
        if (null == businessAudit) {
            return null;
        }

        BusinessAuditResponseDto businessAuditResponseDto = new BusinessAuditResponseDto();
        BeanUtils.copyProperties(businessAudit, businessAuditResponseDto);
        return businessAuditResponseDto;
    }

    // 数据转换
    private List<BusinessAuditResponseDto> convertList(List<BusinessAudit> businessAudits) {
        if (CollectionUtils.isEmpty(businessAudits)) {
            return null;
        }

        List<BusinessAuditResponseDto> list = new ArrayList<BusinessAuditResponseDto>(businessAudits.size());
        for (BusinessAudit businessAudit : businessAudits) {
            list.add(convert(businessAudit));
        }
        return list;
    } 

}
