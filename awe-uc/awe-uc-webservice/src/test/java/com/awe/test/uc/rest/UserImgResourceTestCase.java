package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.dto.UserImg;
import com.awe.test.uc.rest.request.UserImgRequest;
import com.awe.test.uc.rest.response.UserImgResponse;
import com.awe.test.uc.rest.Urls;

/**
 * UserImgResource单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class UserImgResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserImg() {
        String url= Urls.API_DOMAIN + "/userImg/getUserImg";

        UserImgRequest request = new UserImgRequest();
        request.setId(1l);
        UserImgResponse response = super.getRestTemplate().postForObject(url, request, UserImgResponse.class);
        Assert.notNull(response);
        UserImg userImg = super.getResult(response);
        Assert.notNull(userImg);
    }
}
