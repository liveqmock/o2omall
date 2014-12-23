package com.hbird.portal.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.hbird.portal.sdk.request.PermissionCheckRequest;
import com.hbird.portal.sdk.request.PermissionQueryRequest;
import com.hbird.portal.sdk.response.ButtonResourceDto;

/**
 * PermissionClient测试用例
 * 
 * @author ljz
 * @version 2014-11-21 上午11:04:39
 */
public class PermissionClientTestCase {
    protected final Log logger = LogFactory.getLog(getClass());

    // String WS_DOMAIN = "http://dev.iapi.shop.hbird.com/";
    String WS_DOMAIN = "http://local.iapi.shop.hbird.com:8090/";
    PermissionClient client;

    @Before
    public void init() throws Exception {
        client = new PermissionClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
        client.afterPropertiesSet();
    }

    @Test
    public void testIsPermitted() {
        Assert.notNull(client);
        PermissionCheckRequest request = new PermissionCheckRequest();
        request.setUserId(1L);
        request.setResourceCode("103");
        Boolean result = client.isPermitted(request);
        Assert.isTrue(result);
    }

    @Test
    public void testIsPermittedFailure() {
        Assert.notNull(client);
        PermissionCheckRequest request = new PermissionCheckRequest();
        request.setUserId(1L);
        request.setResourceCode("103NONE");// 不存在的资源码
        Boolean result = client.isPermitted(request);
        Assert.isTrue(null == result || !result);
    }

    @Test
    public void testGetPermissionByParentCode() {
        Assert.notNull(client);
        PermissionQueryRequest request = new PermissionQueryRequest();
        request.setUserId(1L);
        request.setParentResourceCode("RE00084");

        List<String> list = client.getPermissionByParentCode(request);
        Assert.notEmpty(list);
    }

    @Test
    public void testGetPermissionByParentCodeFailure() {
        Assert.notNull(client);
        PermissionQueryRequest request = new PermissionQueryRequest();
        request.setUserId(1L);
        request.setParentResourceCode("RE00084NONE");// 不存在的资源码
        List<String> list = client.getPermissionByParentCode(request);
        Assert.isTrue(CollectionUtils.isEmpty(list));
    }

    @Test
    public void testButtonResource() {
        Assert.notNull(client);
        PermissionCheckRequest request = new PermissionCheckRequest();
        request.setUserId(951L);
        request.setResourceUrl("http://local.i.shop.hbird.com:8080/user/resetPassword");

        List<ButtonResourceDto> list = client.buttonResource(request);
        Assert.notEmpty(list);
    }

}
