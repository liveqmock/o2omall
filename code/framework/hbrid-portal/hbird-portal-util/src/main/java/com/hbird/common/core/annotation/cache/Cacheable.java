package com.hbird.common.core.annotation.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 增加缓存注解
 * <p/>
 * User: ljz Date: 2014-4-24 Time: 下午05:03:16 Version: 1.0
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {

    /**
     * Name of the caches in which the update takes place.
     * <p>
     * May be used to determine the target cache (or caches), matching the qualifier value (or the bean name(s)) of (a)
     * specific bean definition.
     */
    String value() default "";

    /**
     * Spring Expression Language (SpEL) attribute for computing the key dynamically.
     * <p>
     * Default is "", meaning all method parameters are considered as a key.
     */
    String key() default "";

    /**
     * Spring Expression Language (SpEL) attribute used for conditioning the method caching.
     * <p>
     * Default is "", meaning the method is always cached.
     */
    String condition() default "";
}
