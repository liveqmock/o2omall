package com.hbird.portal.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.test.BaseTransactionTestCase;

/**
 * 权限服务测试用例
 * 
 * @author ljz
 * @version 2014-11-26 下午3:37:53
 */
public class PermissionServiceTestCase extends BaseTransactionTestCase {
    private final static Logger log = LogManager.getLogger(PermissionServiceTestCase.class);

    @Autowired
    private PermissionService permissionService;

    @Test
    public void testGetPermissionByParentCode() {
        try {
            Resource resource = new Resource();
            resource.setCode("RE00084");
            System.out.println("用户拥有权限集合:" + permissionService.getPermissionByParentCode(1L, resource));
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    public void testIsPermitted() {
        try {
            Resource resource = new Resource();
            resource.setCode("103");
            System.out.println("用户是否有资源权限:" + permissionService.isPermitted(1L, resource));
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test
    public void testQueryButtonResources() {
        Long userId = 951L;
        Resource resource = new Resource();
        resource.setUrl("http://local.i.shop.hbird.com:8080/user/resetPassword");
        List<Resource> buttons = permissionService.queryButtonResources(userId, resource);
        Assert.notEmpty(buttons);

        logger.info("buttons size=" + buttons.size());
    }
}
