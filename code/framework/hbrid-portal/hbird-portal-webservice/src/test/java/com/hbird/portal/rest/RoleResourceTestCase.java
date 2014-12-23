/**
 * 
 */
package com.hbird.portal.rest;

import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.hbird.common.utils.serialize.JsonHelper;
import com.hbird.portal.rest.dto.RoleResponseObj;
import com.hbird.portal.sdk.api.request.UserRequest;

/**
 * @author ljz
 * 
 */
public class RoleResourceTestCase {

    /** 依据用户ID查询用户所拥有的角色信息 */
    private static final String SERVICES_GET_ROLE_LIST = Urls.API_DOMAIN + "services/role/getUserRoleList";

    @Test
    public void test() {
        UserRequest request = new UserRequest();
        request.setId(1L);
        RestTemplate template = new RestTemplate();
        String str = template.postForObject(SERVICES_GET_ROLE_LIST, request, String.class);
        Assert.notNull(str);
        RoleResponseObj wrapper = JsonHelper.toBean(str, RoleResponseObj.class);
        Assert.notNull(wrapper);
    }

}
