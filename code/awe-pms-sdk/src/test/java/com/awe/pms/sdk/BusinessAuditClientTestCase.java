package com.awe.pms.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.BusinessAuditRequestDto;
import com.awe.pms.sdk.response.dto.BusinessAuditResponseDto;

/**
 * BusinessAuditClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class BusinessAuditClientTestCase {
    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8090/";
    private BusinessAuditClient client;

    @Before
    public void init() throws Exception {
        client = new BusinessAuditClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetBusinessAudit() {
        BusinessAuditRequestDto requestDto = new BusinessAuditRequestDto();
        requestDto.setId(1l);
        
        BusinessAuditResponseDto businessAuditResponseDto = client.getBusinessAudit(requestDto);
        Assert.notNull(businessAuditResponseDto);
    } 

}
