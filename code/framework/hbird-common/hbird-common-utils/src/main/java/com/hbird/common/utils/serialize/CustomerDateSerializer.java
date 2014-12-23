package com.hbird.common.utils.serialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.hbird.common.utils.DateHelper;

/**
 * java日期对象经过Jackson库转换成JSON日期格式化自定义类
 * 
 * @author ljz
 */
public class CustomerDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat(DateHelper.DATE_TIME_FORMAT);
        String formattedDate = formatter.format(value);
        jgen.writeString(formattedDate);
    }
}
