package com.awe.test.pms.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.pms.rest.request.BusinessAuditRequest;
import com.awe.test.pms.rest.request.dto.BusinessAuditRequestDto;
import com.awe.test.pms.rest.response.BusinessAuditResponse;
import com.awe.test.pms.rest.response.dto.BusinessAuditResponseDto;

/**
 * BusinessAuditResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 15:30:05
 * 
 */
public class BusinessAuditResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetBusinessAudit() {
        String url= getServiceUrlDomain() + "/businessAudit/getBusinessAudit";

        BusinessAuditRequestDto requestDto = new BusinessAuditRequestDto();
        requestDto.setId(1l);
        BusinessAuditRequest request = new BusinessAuditRequest("pms",requestDto);
        
        BusinessAuditResponse response = super.getRestTemplate().postForObject(url, request, BusinessAuditResponse.class);
        Assert.notNull(response);
        BusinessAuditResponseDto businessAuditResponseDto = super.getResult(response);
        Assert.notNull(businessAuditResponseDto);
    }
}
