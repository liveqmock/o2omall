package com.awe.test.pms.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.BusinessAuditRequest;
import com.awe.test.pms.rest.request.dto.BusinessAuditRequestDto;
import com.awe.test.pms.rest.response.BusinessAuditResponse;
import com.awe.test.pms.rest.response.dto.BusinessAuditResponseDto;
import com.awe.test.pms.rest.Urls;

/**
 * BusinessAuditResource单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class BusinessAuditResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetBusinessAudit() {
        String url= Urls.API_DOMAIN + "/businessAudit/getBusinessAudit";

        BusinessAuditRequestDto requestDto = new BusinessAuditRequestDto();
        requestDto.setId(1l);
        BusinessAuditRequest request = new BusinessAuditRequest("key",requestDto);
        
        BusinessAuditResponse response = super.getRestTemplate().postForObject(url, request, BusinessAuditResponse.class);
        Assert.notNull(response);
        BusinessAuditResponseDto businessAuditResponseDto = super.getResult(response);
        Assert.notNull(businessAuditResponseDto);
    }
}
