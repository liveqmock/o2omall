package com.hbird.portal.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.utils.page.PageUtil;
import com.hbird.portal.sdk.PortalClient;
import com.hbird.portal.sdk.dto.Role;
import com.hbird.portal.sdk.dto.User;

/**
 * PortalClient测试用例
 * 
 * @author ljz
 * @version 2014-8-1 11:21:47
 */
public class PortalClientTestCase {
    protected final Log logger = LogFactory.getLog(getClass());

    String WS_DOMAIN = "http://dev.itsws.shop.hbird.com/";
    // String MAIL_WS_DOMAIN = "http://local.itsws.shop.hbird.com:8090/";
    PortalClient client;

    @Before
    public void init() {
        client = new PortalClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserById() {
        Assert.notNull(client);
        User u = new User();
        u.setId(1L);
        User user = client.getUser(u);
        Assert.notNull(user);
        logger.info("user " + user.getCnName());
    }

    @Test
    public void testGetUserByName() {
        Assert.notNull(client);
        User u = new User();
        u.setName("acs");
        User user = client.getUser(u);
        Assert.notNull(user);
        logger.info("user " + user.getCnName());
    }

    @Test
    public void testGetUserListByName() {
        Assert.notNull(client);
        User u = new User();
        // u.setName("zh");
        u.setCnName("张");
        PageUtil pageUtil = new PageUtil(1, 20);
        List<User> list = client.getUserListByName(u, pageUtil);
        Assert.notEmpty(list);
        for (User user : list) {
            logger.info("user " + user.getCnName());
        }
    }

    @Test
    public void testGetUserRoleList() {
        Assert.notNull(client);
        User u = new User();
        u.setId(1L);
        List<Role> list = client.getUserRoleList(u);
        Assert.notEmpty(list);
        for (Role r : list) {
            logger.info("role name: " + r.getName());
        }
    }

}
