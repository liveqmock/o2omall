/**
 * 
 */
package com.hbird.portal.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.portal.test.BaseTestCase;

/**
 * 单点登录验证和加密的TestCase
 * 
 * @author ljz
 * 
 */
public class SSOServiceTestCase extends BaseTestCase {

    @Autowired
    private SSOService ssoService;

    @Test
    public void testCheckUser() {
        String name = "a";
        String password = "a";
        boolean result = ssoService.checkUser(name, password);
        Assert.isTrue(!result);
    }

    @Test
    public void testEncode() {
        String password = "a2";
        String result = ssoService.encode(password);
        Assert.notNull(result);
        logger.info("encode result : " + result);
    }
}
