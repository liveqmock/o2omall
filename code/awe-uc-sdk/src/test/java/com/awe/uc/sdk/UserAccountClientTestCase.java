package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.dto.UserAccountRequestDto;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserAccountClient测试用例
 * 
 * @author ljz
 * @version 2014-12-25 17:48:02
 * 
 */
public class UserAccountClientTestCase {
    // String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserAccountClient client;

    @Before
    public void init() throws Exception {
        client = new UserAccountClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setKey("uc");
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testGetUserAccount() {
        UserAccountRequestDto requestDto = new UserAccountRequestDto();
        requestDto.setId(1l);

        UserAccountResponseDto userAccountResponseDto = client.getUserAccount(requestDto);
        Assert.notNull(userAccountResponseDto);
    }

    @Test
    public void testGetUserRegister() {
        Wrapper<?> w = client.register("user5", "123456");
        Assert.notNull(w);
    }

    @Test
    public void testGetUserLogin() {
        UserAccountResponseDto userAccountResponseDto = client.login("user1", "123456");
        Assert.notNull(userAccountResponseDto);
    }

}
