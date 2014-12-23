package com.hbird.test.common.core.redis;

import org.junit.Test;

import com.hbird.common.core.util.codegenerate.BusinessCodeGenerator;

/**
 * TODO
 * <p/>
 * User: ljz Date: 2014-6-6 Time: 下午01:08:48 Version: 1.0
 */
public class BusinessGeneratorTest {
    @Test
    public void testGetSystemCode() {
        System.out.println(BusinessCodeGenerator.getSystemCode(new Long(10)));
    }

    @Test
    public void testGetRoleCode() {
        System.out.println(BusinessCodeGenerator.getRoleCode(new Long(10)));
    }

    @Test
    public void testGetResourceCode() {
        System.out.println(BusinessCodeGenerator.getResourceCode(new Long(1000000000)));
    }
}
