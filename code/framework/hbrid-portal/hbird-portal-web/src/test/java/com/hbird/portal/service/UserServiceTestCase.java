package com.hbird.portal.service;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.portal.domain.User;
import com.hbird.portal.test.BaseTransactionTestCase;

public class UserServiceTestCase extends BaseTransactionTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserByName() {
        String name = "zhangsan";
        User user = userService.getUserByName(name);
        Assert.notNull(user);
        Assert.notNull(user.getUserType());

        logger.info("UserType=" + user.getUserType() + ", Name=" + user.getName());
    }

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1l);
        Assert.notNull(user);
        Assert.notNull(user.getCnName());
        logger.info("user name=" + user.getCnName());
    }

    @Test
    public void testGetUserByIdFailure() {
        User user = userService.getUserById(-10l);
        Assert.isNull(user);
    }

}
