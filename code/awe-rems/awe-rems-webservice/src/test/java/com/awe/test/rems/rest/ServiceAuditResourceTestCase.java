package com.awe.test.rems.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.test.rems.rest.request.ServiceAuditRequest;
import com.awe.test.rems.rest.request.dto.ServiceAuditRequestDto;
import com.awe.test.rems.rest.response.ServiceAuditResponse;
import com.awe.test.rems.rest.response.ServiceAuditResponseList;
import com.awe.test.rems.rest.response.dto.ServiceAuditResponseDto;
import com.hbird.common.client.AbstractClient;

/**
 * ServiceAuditResource单元测试
 * 
 * @author zyq
 * @version 2014-12-25 15:29:57
 * 
 */
public class ServiceAuditResourceTestCase extends AbstractClient {
    
    @Before
    public void init() throws Exception {
        setServiceUrlDomain(Urls.API_DOMAIN);
        afterPropertiesSet();
    }
    
    @Test
    public void testGetServiceAudit() {
        String url= getServiceUrlDomain() + "/serviceAudit/getServiceAudit";

        ServiceAuditRequestDto requestDto = new ServiceAuditRequestDto();
        requestDto.setId(1l);
        ServiceAuditRequest request = new ServiceAuditRequest("rems",requestDto);
        
        ServiceAuditResponse response = super.getRestTemplate().postForObject(url, request, ServiceAuditResponse.class);
        Assert.notNull(response);
        ServiceAuditResponseDto serviceAuditResponseDto = super.getResult(response);
        Assert.notNull(serviceAuditResponseDto);
    }
    
    @Test
    public void queryServiceAuditList(){
    	String url= getServiceUrlDomain() + "/serviceAudit/queryServiceAuditList";

        ServiceAuditRequestDto requestDto = new ServiceAuditRequestDto();
        requestDto.setServiceNo("T000000001");
        requestDto.setUserId(1l);
        ServiceAuditRequest request = new ServiceAuditRequest("rems",requestDto);
        ServiceAuditResponseList responseList = super.getRestTemplate().postForObject(url, request, ServiceAuditResponseList.class);
        Assert.notNull(responseList);
    }
}
