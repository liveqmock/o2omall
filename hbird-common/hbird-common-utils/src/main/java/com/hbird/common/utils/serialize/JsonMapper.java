package com.hbird.common.utils.serialize;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.type.JavaType;

import com.hbird.common.utils.DateHelper;

/**
 * 简单封装Jackson，实现JSON String<->Java Object的Mapper<br/>
 * 封装不同的输出风格, 使用不同的builder函数创建实例。<br/>
 * 简单进行json与Object转化，请参考JsonHelper。
 * 
 * @author lz
 */
public class JsonMapper {

    /** The logger. */
    private static final Log LOGGER = LogFactory.getLog(JsonMapper.class);

    /** The mapper. */
    private ObjectMapper mapper;

    /**
     * Instantiates a new json mapper.
     * 
     * @param inclusion
     *            the inclusion
     */
    public JsonMapper(Inclusion inclusion) {
        mapper = new ObjectMapper();
        // 设置输出时包含属性的风格
        mapper.setSerializationInclusion(inclusion);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 禁止使用int代表Enum的order()來反序列化Enum,非常危险
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);

        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        // 输出的设置日期格式
        mapper.setDateFormat(new SimpleDateFormat(DateHelper.DATE_TIME_FORMAT));
        //空值转换
        mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true) ; 
        
    }

    /**
     * 创建输出全部属性到Json字符串的Mapper.
     * 
     * @return the json mapper
     */
    public static JsonMapper buildNormalMapper() {
        return new JsonMapper(Inclusion.ALWAYS);
    }

    public static JsonMapper bulidNormalMapperNameData() {
        JsonMapper jsonMapper = buildNormalMapper();
        jsonMapper.getMapper().setPropertyNamingStrategy(new PropertyNamingStrategy() {
            @Override
            public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                if ("o".equals(defaultName)) {
                    return "data";
                }
                return defaultName;
            }
        });
        return jsonMapper;
    }

    /**
     * 创建只输出非空属性到Json字符串的Mapper.
     * 
     * @return the json mapper
     */
    public static JsonMapper buildNonNullMapper() {
        return new JsonMapper(Inclusion.NON_NULL);
    }

    /**
     * 创建只输出初始值被改变的属性到Json字符串的Mapper.
     * 
     * @return the json mapper
     */
    public static JsonMapper buildNonDefaultMapper() {
        return new JsonMapper(Inclusion.NON_DEFAULT);
    }

    /**
     * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper.
     * 
     * @return the json mapper
     */
    public static JsonMapper buildNonEmptyMapper() {
        return new JsonMapper(Inclusion.NON_EMPTY);
    }

    /**
     * 如果对象为Null, 返回"null". 如果集合为空集合, 返回"[]".
     * 
     * @param object
     *            the object
     * @return the string
     */
    public String toJson(Object object) {
        try {
            String returnString = mapper.writeValueAsString(object);
            // 转义单引号 为在界面序列化传值信息使用
            return returnString != null ? returnString.replace("'", "&acute;") : returnString;
        } catch (IOException e) {
            LOGGER.warn("toJson(Object) error:" + object, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * 
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
     * 
     * @param <T>
     *            the generic type
     * @param jsonString
     *            the json string
     * @param clazz
     *            the clazz
     * @return the t
     * @see #constructParametricType(Class, Class...)
     */
    @JsonCreator
    public <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            LOGGER.warn("fromJson(String, Class<T>) error:" + jsonString, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * 
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
     * 
     * @param <T>
     *            the generic type
     * @param jsonString
     *            the json string
     * @param javaType
     *            the java type
     * @return the t
     * @see #constructParametricType(Class, Class...)
     */
    @JsonCreator
    public <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            LOGGER.warn("fromJson(String, JavaType)", e);
            return null;
        }
    }

    /**
     * 
     * @param jsonString
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    @JsonCreator
    public <T> T fromJson(String jsonString, Type type) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return (T) mapper.readValue(jsonString, mapper.constructType(type));
        } catch (IOException e) {
            LOGGER.warn("fromJson(String, Type)", e);
            return null;
        }
    }

    /**
     * 构造泛型Type如List<MyBean>, 则调用constructParametricType(ArrayList.class,MyBean.class)
     * Map<String,MyBean>则调用(HashMap.class,String.class, MyBean.class)
     * 
     * @param parametrized
     *            the parametrized
     * @param parameterClasses
     *            the parameter classes
     * @return the java type
     */
    public JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * 当JSON里只含有Bean的部分属性时，更新一个已存在Bean，只覆盖该部分的属性
     * 
     * @param <T>
     *            the generic type
     * @param object
     *            the object
     * @param jsonString
     *            the json string
     * @return the t
     */
    @SuppressWarnings("unchecked")
    public <T> T update(T object, String jsonString) {
        try {
            return (T) mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException e) {
            LOGGER.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        } catch (IOException e) {
            LOGGER.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        }
        return null;
    }

    /**
     * 输出JSONP格式的数据.
     * 
     * @param functionName
     *            the function name
     * @param object
     *            the object
     * @return the string
     */
    public String toJsonP(String functionName, Object object) {
        return toJson(new JSONPObject(functionName, object));
    }

    /**
     * 设定是否使用Enum的toString函数来读写Enum, 为False时使用Enum的name()函数来读写Enum, 默认为False. 注意一定要在读写操作之前调用
     * 
     * @param value
     *            the new enum use to string
     */
    public void setEnumUseToString(boolean value) {
        mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, value);
        mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, value);
    }

    /**
     * 取出Mapper做进一步的设置或使用其他序列化API.
     * 
     * @return the mapper
     */
    public ObjectMapper getMapper() {
        return mapper;
    }
}
