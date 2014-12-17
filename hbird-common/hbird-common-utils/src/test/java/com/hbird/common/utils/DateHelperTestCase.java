/**
 * 
 */
package com.hbird.common.utils;

import java.util.Date;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.utils.DateHelper;

/**
 * the DateHelperTestCase class
 * 
 * @author lz
 * 
 */
public class DateHelperTestCase {

    @Test
    public void testToday() {
        String dateString = DateHelper.today();
        Assert.notNull(dateString);
        System.out.println(dateString);
    }

    @Test
    public void testParseDate() {
        Date date = DateHelper.parseDate("2014-01-01");
        Assert.notNull(date);
        System.out.println(date);
    }

    @Test
    public void testFormatDate() {
        String dateString = DateHelper.formatDate(new Date());
        Assert.notNull(dateString);
        System.out.println(dateString);
    }
}
