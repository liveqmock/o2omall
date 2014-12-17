package com.hbird.common.utils.serialize;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.JavaType;

/**
 * Json序列化和反序列化的助手类
 * 
 * @see JsonMapper
 * 
 * @author lz
 */
public class JsonHelper {

    private static JsonMapper jsonMapper;

    /**
     * @param jsonMapper
     *            the jsonMapper to set
     */
    public static void setJsonMapper(JsonMapper jsonMapper) {
        JsonHelper.jsonMapper = jsonMapper;
    }

    /**
     * 如果没有调用setJsonMapper设置JsonMapper, 则默认创建只输出非空属性到Json字符串的Mapper.
     * 
     * @return
     */
    private static JsonMapper getJsonMapper() {
        if (null != JsonHelper.jsonMapper) {
            return JsonHelper.jsonMapper;
        }
        return JsonMapper.buildNonNullMapper();
    }

    /**
     * from bean to json
     * 
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return getJsonMapper().toJson(obj);
    }

    /**
     * from json to bean
     * 
     * @param json
     * @param responseType
     * @return
     */
    public static <T> T toBean(String json, Class<T> responseType) {
        return getJsonMapper().fromJson(json, responseType);
    }

    /**
     * from json to collection bean
     * 
     * @param json
     * @param entity
     * @return
     */
    @Deprecated
    public static Object toCollectionBean(String json, Class<?> collectionClass, Class<?>... elementClasses) {
        JsonMapper jsonMapper = getJsonMapper();
        JavaType javaType = jsonMapper.constructParametricType(collectionClass, elementClasses);
        return jsonMapper.fromJson(json, javaType);
    }

    /**
     * from json to List bean
     * 
     * @param json
     * @param entity
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> parameterClass) {
        JsonMapper jsonMapper = getJsonMapper();
        JavaType javaType = jsonMapper.constructParametricType(List.class, parameterClass);
        return jsonMapper.fromJson(json, javaType);
    }

    /**
     * from json to Map bean
     * 
     * @param json
     * @param entity
     * @return
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> keyClass, Class<V> valueClass) {
        JsonMapper jsonMapper = getJsonMapper();
        JavaType javaType = jsonMapper.constructParametricType(Map.class, keyClass, valueClass);
        return jsonMapper.fromJson(json, javaType);
    }

}
