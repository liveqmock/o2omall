package com.hbird.common.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbird.common.core.redis.support.RedisUtil;

/**
 * User: ljz Date: 2014-4-22 Time: 下午03:50:59 Version: 1.0
 */
@Component
public class RedisAdvice {

    /**
     * 
     */
    private static final String TRUE = "true";
    @Autowired
    public RedisUtil redisUtil;
    /** 是否启用缓存，默认不启用 */
    public String cache;
    /** 是否启用注解缓存，默认注解缓存 */
    public String annotationCache;

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    /**
     * 是否启用缓存,默认不启用
     * 
     * @return
     */
    public boolean cachable() {
        return TRUE.equals(getCache());
    }

    public String getAnnotationCache() {
        return annotationCache;
    }

    public void setAnnotationCache(String annotationCache) {
        this.annotationCache = annotationCache;
    }

    /**
     * 是否启用注解缓存，默认启用，无注解不进行缓存
     * 
     * @return
     */
    public boolean annotationCacheable() {
        return TRUE.equals(getAnnotationCache());
    }
}
