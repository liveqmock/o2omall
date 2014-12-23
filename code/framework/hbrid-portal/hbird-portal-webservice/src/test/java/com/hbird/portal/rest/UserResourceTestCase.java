/**
 * 
 */
package com.hbird.portal.rest;

import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.hbird.portal.sdk.api.request.UserRequest;

/**
 * @author ljz
 * 
 */
public class UserResourceTestCase {

    /** 查询用户 */
    private static final String SERVICES_GET_USER = Urls.API_DOMAIN + "services/user/getUser";
    /** 模糊查询用户 */
    private static final String SERVICES_GET_USER_LIST = Urls.API_DOMAIN + "services/user/getUserListByName";

    /** 模糊查询用户 */
    private static final String SERVICES_GET_USER_LIST_BY_ROLEID = Urls.API_DOMAIN
            + "services/user/getUserListByRoleId";

    @Test
    public void testGetUserById() {
        UserRequest request = new UserRequest();
        request.setId(1l);
        RestTemplate template = new RestTemplate();
        String str = template.postForObject(SERVICES_GET_USER, request, String.class);
        Assert.notNull(str);
    }

    @Test
    public void testGetUserByName() {
        UserRequest request = new UserRequest();
        request.setName("zhangsan");
        RestTemplate template = new RestTemplate();
        String str = template.postForObject(SERVICES_GET_USER, request, String.class);
        Assert.notNull(str);
    }

    @Test
    public void testGetUserListByName() {
        UserRequest request = new UserRequest();
        request.setName("zh");
        RestTemplate template = new RestTemplate();
        String str = template.postForObject(SERVICES_GET_USER_LIST, request, String.class);
        Assert.notNull(str);
    }

    @Test
    public void testGetUserListByRoleId() {
        UserRequest request = new UserRequest();
        request.setId(1l);
        RestTemplate template = new RestTemplate();
        String str = template.postForObject(SERVICES_GET_USER_LIST_BY_ROLEID, request, String.class);
        System.out.println(str);
        Assert.notNull(str);
    }
}
