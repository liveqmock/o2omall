package com.hbird.common.core.redis;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.core.util.StringUtil;
import com.hbird.common.utils.security.MD5Util;
import com.hbird.common.utils.page.Query;

/**
 * Redis key 生成器
 * <p/>
 * 基于方法名+参数信息生成Redis存储缓存数据的key值
 * <p/>
 * User: ljz Date: 2014-4-11 Time: 上午11:52:08 Version: 1.0
 */
public class KeyGenerator {

    private final static Logger LOG = LogManager.getLogger(KeyGenerator.class);

    /** 截取类名字符串长度 */
    private static final int CLASS_SUB_LENGTH = 5;

    /**
     * 根据类名、方法名和参数生成key
     * 
     * @param className
     *            类名
     * @param methodName
     *            方法名
     * @param param
     *            参数对象
     * @return
     */
    public static String generateByMethodNameAndParams(String className, String methodName, Object[] params) {
        if (StringUtils.isEmpty(methodName)) {
            throw new NullPointerException("Param methodName is null!");
        }

        if (null == params) {
            throw new NullPointerException("Param Object[] params is null!");
        }

        if (params.length == 0) {
            throw new IllegalArgumentException("Param Object[] params length is 0!");
        }

        StringBuilder builder = new StringBuilder();
        builder.append(className);
        builder.append(StringUtil.SEP_COMMA);
        builder.append(methodName);

        for (Object param : params) {
            // 参数类
            Class<?> objClass = param.getClass();

            // 根据类和对象获取对象属性和值集合字符串
            builder.append(StringUtil.SEP_LINE);
            builder.append(getObjectFiledAndValues(objClass, param));
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Redis查询key:" + builder.toString());
        }

        return builder.toString();
    }

    /**
     * 根据类名、方法名和参数生成key(MD5)
     * 
     * @param className
     *            类名
     * @param methodName
     *            方法名
     * @param param
     *            参数对象
     * @return
     */
    public static String generateByMethodNameAndParamsWithMD5(String className, String methodName, Object[] param) {
        return MD5Util.md5Hex(generateByMethodNameAndParams(className, methodName, param));
    }

    /**
     * 根据类名获取业务类型Key
     * 
     * @param className
     *            类名
     * @return
     */
    public static String generateBusinessKey(String className) {
        if (StringUtils.isEmpty(className)) {
            throw new NullPointerException("Param className is null!");
        }

        String businessKey = "";
        if (className.length() >= CLASS_SUB_LENGTH) {
            businessKey = className.substring(0, CLASS_SUB_LENGTH);
        } else {
            businessKey = className;
        }
        return businessKey.toLowerCase();
    }

    /**
     * 根据类和对象获取对象属性和值集合字符串
     * 
     * @param clazz
     *            类
     * @param param
     *            参数集合
     */
    private static String getObjectFiledAndValues(Class<?> clazz, Object param) {
        StringBuilder key = new StringBuilder();
        key.append(StringUtils.substringAfterLast(clazz.getName(), StringUtil.SEP_COMMA));
        key.append(StringUtil.SEP_LEFT_BRACKETS);

        String paramClz = clazz.toString();
        if (paramClz.endsWith("Integer") || paramClz.endsWith("String") || paramClz.endsWith("Long")) {
            key.append(param.toString());
        } else {// java对象，非基础对象
            // 参数属性集合
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 设定属性可访问
                field.setAccessible(true);

                try {
                    // 获取属性值
                    Object value = field.get(param);
                    if (null != value) {
                        // 获取属性类型
                        String type = field.getType().toString();
                        if (type.endsWith("String")) {
                            if (StringUtils.isNotEmpty(value.toString())) {
                                appendParam(key, field.getName(), value.toString());
                            }
                        } else if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("Long")) {
                            appendParam(key, field.getName(), value.toString());
                        } else if (type.endsWith("Date")) {
                            appendParam(key, field.getName(), value.toString());
                        } else {
                            appendParam(key, field.getName(), value.toString());
                        }
                    }
                } catch (IllegalArgumentException e) {
                    LOG.error("根据属性和对象获取对象属性值不合法异常，对象：" + clazz.getName() + ";属性：" + field.getName(), e);
                } catch (IllegalAccessException e) {
                    LOG.error("根据属性和对象获取对象属性值无操作权限异常，对象：" + clazz.getName() + ";属性：" + field.getName(), e);
                }
            }

            // 递归获取父类属性
            Class<?> superClz = clazz.getSuperclass();
            if (null != superClz) {
                key.append(getObjectFiledAndValues(superClz, param));
            }
        }

        key.append(StringUtil.SEP_RIGHT_BRACKETS);

        return key.toString();
    }

    /**
     * Key追加参数属性和值
     * 
     * @param key
     * @param param
     * @param value
     */
    private static void appendParam(StringBuilder key, String param, String value) {
        key.append(StringUtil.SEP_COMMA);
        key.append(param);
        key.append(StringUtil.SEP_COLON);
        key.append(value);
    }

    /**
     * 从参数集合中获取查询类参数
     * 
     * @param params
     * @return
     */
    public static Object getQueryParam(Object[] params) {
        if (null == params) {
            throw new NullPointerException("Param Object[] params is null!");
        }

        if (params.length == 0) {
            throw new IllegalArgumentException("Param Object[] params length is 0!");
        }

        for (Object param : params) {
            if (param.getClass().toString().endsWith("Query") || param instanceof Query) {
                return param;
            }
        }
        return null;
    }

}
