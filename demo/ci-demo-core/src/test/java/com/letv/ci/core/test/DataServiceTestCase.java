/**
 * 
 */
package com.letv.ci.core.test;

import org.junit.Test;
import org.springframework.util.Assert;

import com.letv.ci.service.DataService;
import com.letv.ci.service.impl.DataServiceImpl;

/**
 * @author lijianzhong
 * 
 */
public class DataServiceTestCase {

    private DataService dataTestService = new DataServiceImpl();

    @Test
    public void testNull() {
        Assert.isTrue(!dataTestService.isNotEmpty(null));
    }

    @Test
    public void testBlank() {
        Assert.isTrue(!dataTestService.isNotEmpty(""));
    }

    @Test
    public void testBlankSpace() {
        Assert.isTrue(dataTestService.isNotEmpty(" "));
    }

    @Test
    public void testStr() {
        Assert.isTrue(dataTestService.isNotEmpty("bob"));
    }

    @Test
    public void testStrWithBlank() {
        Assert.isTrue(dataTestService.isNotEmpty(" bob "));
    }
}
