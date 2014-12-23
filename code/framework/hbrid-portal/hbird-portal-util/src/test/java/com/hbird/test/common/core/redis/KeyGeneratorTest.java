package com.hbird.test.common.core.redis;

import org.junit.Test;

import com.hbird.common.core.redis.KeyGenerator;

/**
 * Redis key生成器测试
 * <p/>
 * User: ljz Date: 2014-4-14 Time: 下午06:03:38 Version: 1.0
 */
public class KeyGeneratorTest {

    @Test
    public void testGenerateByMethodNameAndParam() {
        /*
         * DepQuery query = new DepQuery(); query.setPageIndex(1); query.setPageSize(10); query.setCode("001");
         * query.setStartTime(new Date()); String key =
         * KeyGenerator.generateByMethodNameAndParams("DepManagerImpl","queryList", new Object[]{query});
         * 
         * System.out.println("生成的Key：" + key);
         * 
         * String keyMD5 = KeyGenerator.generateByMethodNameAndParamsWithMD5("DepManagerImpl","queryList", new
         * Object[]{query}); System.out.println("生成的MD5加密Key：" + keyMD5); int i = 0; System.out.println();
         */
    }

    @Test
    public void testGenerateBusinessKey() {
        String businessKey = KeyGenerator.generateBusinessKey("DepManagerImpl");
        System.out.println("生成的业务类型Key：" + businessKey);
    }
}
