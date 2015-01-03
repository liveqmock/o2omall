package com.awe.pms.sdk;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.dto.BusinessInfoRequestDto;
import com.awe.pms.sdk.response.dto.BusinessInfoResponseDto;

/**
 * BusinessInfoClient测试用例
 * 
 * @author ljz
 * @version 2014-12-30 16:41:56
 * 
 */
public class BusinessInfoClientTestCase {
//    String WS_DOMAIN = "http://dev.pmsws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.pmsws.shop.hbird.com:8081/";
    private BusinessInfoClient client;

    @Before
    public void init() throws Exception {
        client = new BusinessInfoClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("pms");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetBusinessInfo() {
        BusinessInfoRequestDto requestDto = new BusinessInfoRequestDto();
        requestDto.setId(1l);
        
        BusinessInfoResponseDto businessInfoResponseDto = client.getBusinessInfo(requestDto);
        Assert.notNull(businessInfoResponseDto);
    } 
    
    @Test
    public void testGetAllBusinessInfos() {
    	BusinessInfoRequestDto requestDto = new BusinessInfoRequestDto();
//    	requestDto.setId(1l);
    	
    	List<BusinessInfoResponseDto> businessInfoResponseDtos = client.getAllBusinessInfos(requestDto);
    	Assert.notNull(businessInfoResponseDtos);
    } 

}
