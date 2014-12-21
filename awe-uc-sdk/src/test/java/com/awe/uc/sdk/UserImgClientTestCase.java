package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.response.dto.UserImgDto;
import com.awe.uc.sdk.request.UserImgRequest;

/**
 * UserImgClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class UserImgClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserImgClient client;

    @Before
    public void init() {
        client = new UserImgClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserImg() {
        UserImgRequest request = new UserImgRequest();
        request.setId(1L);
        UserImgDto userImgDto = client.getUserImg(request);
        Assert.notNull(userImgDto);
    } 

}
