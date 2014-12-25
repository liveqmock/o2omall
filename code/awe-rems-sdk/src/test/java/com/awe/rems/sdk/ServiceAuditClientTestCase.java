package com.awe.rems.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.rems.sdk.request.ServiceAuditRequest;
import com.awe.rems.sdk.request.dto.ServiceAuditRequestDto;
import com.awe.rems.sdk.response.dto.ServiceAuditResponseDto;

/**
 * ServiceAuditClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class ServiceAuditClientTestCase {
    String WS_DOMAIN = "http://dev.remsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.remsws.shop.hbird.com:8090/";
    private ServiceAuditClient client;

    @Before
    public void init() {
        client = new ServiceAuditClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetServiceAudit() {
        ServiceAuditRequestDto requestDto = new ServiceAuditRequestDto();
        requestDto.setId(1l);
        ServiceAuditRequest request = new ServiceAuditRequest("key",requestDto);
        
        ServiceAuditResponseDto serviceAuditResponseDto = client.getServiceAudit(request);
        Assert.notNull(serviceAuditResponseDto);
    } 

}
