package com.hbird.common.core.redis;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.hbird.common.core.annotation.cache.Cacheable;
import com.hbird.common.core.util.StringUtil;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * Redis Spring Aop查询切面类
 * <p/>
 * 实现基本的查询数据库服务拦截，在查询数据库前先查询Redis<br/>
 * 若Redis有数据，返回；若Redis无数据，查询数据库，缓存数据，返回
 * <p/>
 * Redis缓存基于业务类型存储，同业务类型数据放到一个hash里面;<br/>
 * 当某业务数据变更，清除掉同业务类型hash数据，保证数据的同步和时效.<br/>
 * 针对业务数据，同一类型的业务数据存储在同一hash内，此处的key为hash内部的field.<br/>
 * <p/>
 * 
 * User: ljz Date: 2014-4-11 Time: 上午11:35:08 Version: 1.0
 */
@Component
public class RedisQueryAdvice extends RedisAdvice implements MethodInterceptor {

    private static final Logger log = LogManager.getLogger(RedisQueryAdvice.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        // 不启用缓存
        if (!cachable()) {
            return methodInvocation.proceed();
        }

        // 方法
        Method method = methodInvocation.getMethod();

        // 注解缓存
        Cacheable cache = method.getAnnotation(Cacheable.class);
        // 若启用注解，无注解不启用缓存
        if (annotationCacheable() && null == cache) {
            return methodInvocation.proceed();
        }

        // 类
        Class<?> clz = method.getDeclaringClass();
        // 类名
        String className = StringUtils.substringAfterLast(clz.getName(), StringUtil.SEP_COMMA);
        // 方法名
        String methodName = method.getName();
        // 参数集合
        Object[] params = methodInvocation.getArguments();

        // 缓存Key
        String key = "";
        // 业务类型Hash key
        String hashKey = "";

        if (null != cache) {
            if (StringUtils.isNotEmpty(cache.value())) {
                hashKey = cache.value();
            }
            if (StringUtils.isNotEmpty(cache.key())) {
                key = cache.key();
            }
        }

        if (StringUtils.isEmpty(hashKey)) {
            hashKey = KeyGenerator.generateBusinessKey(className);
        }

        if (StringUtils.isEmpty(key)) {
            key = KeyGenerator.generateByMethodNameAndParamsWithMD5(className, methodName, params);
        }

        // 从Redis获取缓存数据
        String cacheValue = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug("从Redis获取数据,hash key：" + hashKey + "; field:" + key);
            }
            cacheValue = getRedisUtil().hGet(hashKey, key);
        } catch (Exception e) {
            log.error("从Redis获取数据失败，hash key：" + hashKey + "; field:" + key, e);
        }

        // 若缓存中不存在查询数据库，若缓存中存在直接返回值
        if (StringUtils.isNotEmpty(cacheValue)) {
            // 返回值类
            Class<?> returnClz = method.getReturnType();
            // 返回值类
            Type returnType = method.getGenericReturnType();

            // 如果是泛型类型
            if (returnType instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();

                String tName = null;
                for (Type type : types) {
                    tName = type.toString().substring(6);
                }

                log.debug("缓存泛型集合，泛型对象为:" + tName);
                // 集合泛型实体序列化
                return JsonHelper.toCollectionBean(cacheValue, returnClz, Class.forName(tName));
            } else {
                // 非集合泛型实体
                return JsonHelper.toBean(cacheValue, returnClz);
            }
        } else {
            Object returnData = methodInvocation.proceed();

            // 将业务数据存储到缓存
            try {
                if (log.isDebugEnabled()) {
                    log.debug("将数据存储到Redis,hash key：" + hashKey + "; field:" + key + ";value:"
                            + JsonHelper.toJson(returnData));
                }
                getRedisUtil().hSetNX(hashKey, key, JsonHelper.toJson(returnData));
            } catch (Exception e) {
                log.error(
                        "将数据存储到Redis失败，hash key：" + hashKey + "; field:" + key + ";value:"
                                + JsonHelper.toJson(returnData), e);
            }
            return returnData;
        }
    }
}
