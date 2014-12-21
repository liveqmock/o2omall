package com.awe.test.uc.rest;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.client.AbstractClient;
import com.awe.test.uc.rest.dto.UserBasic;
import com.awe.test.uc.rest.request.UserBasicRequest;
import com.awe.test.uc.rest.response.UserBasicResponse;
import com.awe.test.uc.rest.Urls;

/**
 * UserBasicResource单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:55
 * 
 */
public class UserBasicResourceTestCase extends AbstractClient {
    
    @Test
    public void testGetUserBasic() {
        String url= Urls.API_DOMAIN + "/userBasic/getUserBasic";

        UserBasicRequest request = new UserBasicRequest();
        request.setId(1l);
        UserBasicResponse response = super.getRestTemplate().postForObject(url, request, UserBasicResponse.class);
        Assert.notNull(response);
        UserBasic userBasic = super.getResult(response);
        Assert.notNull(userBasic);
    }
}
