package com.hbird.common.core.annotation.cache;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 清除缓存类
 * <p/>
 * User: ljz Date: 2014-4-24 Time: 下午05:06:11 Version: 1.0
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CacheEvict {

    /**
     * Qualifier value for the specified cached operation.
     * <p>
     * May be used to determine the target cache (or caches), matching the qualifier value (or the bean name(s)) of (a)
     * specific bean definition.
     */
    String[] value();

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

    /**
     * Whether or not all the entries inside the cache(s) are removed or not. By default, only the value under the
     * associated key is removed.
     * <p>
     * Note that specifying setting this parameter to true and specifying a {@link CacheKey key} is not allowed.
     */
    boolean allEntries() default true;

    /**
     * Whether the eviction should occur after the method is successfully invoked (default) or before. The latter causes
     * the eviction to occur irrespective of the method outcome (whether it threw an exception or not) while the former
     * does not.
     */
    boolean beforeInvocation() default true;
}
