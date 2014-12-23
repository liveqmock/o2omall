package com.hbird.common.core.redis;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.core.annotation.cache.CacheEvict;
import com.hbird.common.core.util.StringUtil;

/**
 * Redis Spring Aop变更切面类
 * <p/>
 * 实现数据操作（插入，修改，删除）功能的拦截，清除操作类型的数据
 * <p/>
 * User: ljz Date: 2014-4-17 Time: 下午04:19:01 Version: 1.0
 */
public class RedisChangeAdvice extends RedisAdvice implements MethodInterceptor {
    private static final Logger log = LogManager.getLogger(RedisQueryAdvice.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 不启用缓存
        if (!cachable()) {
            return methodInvocation.proceed();
        }

        // 方法
        Method method = methodInvocation.getMethod();
        // 注解缓存
        CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
        // 若启用注解，无注解不启用缓存
        if (annotationCacheable() && null == cacheEvict) {
            return methodInvocation.proceed();
        }

        // 类
        Class<?> clz = method.getDeclaringClass();

        // 类名
        String className = StringUtils.substringAfterLast(clz.getName(), StringUtil.SEP_COMMA);

        // 缓存Key
        String key = "";
        // 业务类型Hash key 默认KeyGenerator.generateBusinessKey(className)
        String[] hashKeys = null;
        // 是否删除hash所有缓存
        boolean allEntries = true;

        if (null != cacheEvict) {
            hashKeys = cacheEvict.value();

            if (StringUtils.isNotEmpty(cacheEvict.key())) {
                key = cacheEvict.key();
            }

            allEntries = cacheEvict.allEntries();
        }

        // 清除Redis同业务类型数据，先清除Redis数据,防止变更数据库成功后，Redis失败，数据不一致
        try {
            if (null == hashKeys || hashKeys.length < 1) {
                hashKeys = new String[] { KeyGenerator.generateBusinessKey(className) };
            }

            if (log.isDebugEnabled()) {
                log.debug("从Redis删除[" + Arrays.toString(hashKeys) + "]业务数据!");
            }

            for (String hashKey : hashKeys) {
                // 1、若allEntries为true 删除整个业务hash
                // 2、若allEntries为fasle，key为空，删除整个业务hash
                // 3、若allEntries为fasle，key不为空，删除hash field
                if (allEntries || StringUtils.isEmpty(key)) {
                    getRedisUtil().del(hashKey);
                } else {
                    getRedisUtil().hDel(hashKey, key);
                }
            }
        } catch (Exception e) {
            log.error("从Redis删除[" + Arrays.toString(hashKeys) + "]业务数据失败!", e);
        }

        return methodInvocation.proceed();
    }

}
