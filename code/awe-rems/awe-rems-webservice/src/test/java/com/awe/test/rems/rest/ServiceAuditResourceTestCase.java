package com.awe.test.rems.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.rems.rest.request.ServiceAuditRequest;
import com.awe.test.rems.rest.request.dto.ServiceAuditRequestDto;
import com.awe.test.rems.rest.response.ServiceAuditResponse;
import com.awe.test.rems.rest.response.dto.ServiceAuditResponseDto;
import com.awe.test.rems.rest.Urls;

/**
 * ServiceAuditResource单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ServiceAuditResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetServiceAudit() {
        String url= Urls.API_DOMAIN + "/serviceAudit/getServiceAudit";

        ServiceAuditRequestDto requestDto = new ServiceAuditRequestDto();
        requestDto.setId(1l);
        ServiceAuditRequest request = new ServiceAuditRequest("key",requestDto);
        
        ServiceAuditResponse response = super.getRestTemplate().postForObject(url, request, ServiceAuditResponse.class);
        Assert.notNull(response);
        ServiceAuditResponseDto serviceAuditResponseDto = super.getResult(response);
        Assert.notNull(serviceAuditResponseDto);
    }
}
