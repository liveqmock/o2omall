/**
 * 
 */
package com.hbird.common.utils.serialize;

import java.util.Date;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author ljz
 * 
 */
public class JsonHelperTestCase {

    @Test
    public void testToJson() {
        TestObject obj = new TestObject();
        obj.setName("jame");
        obj.setTime(new Date());
        String json = JsonHelper.toJson(obj);
        Assert.notNull(json);
        System.out.println(json);
        String json2 = JsonMapper.buildNonNullMapper().toJson(obj);
        Assert.notNull(json2);
        System.out.println(json2);
    }

    // 测试对象
    class TestObject {
        private Long id;
        private Integer type;
        private String name;
        private Date time;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

    }

}
