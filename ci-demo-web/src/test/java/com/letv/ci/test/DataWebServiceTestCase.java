/**
 * 
 */
package com.letv.ci.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.ci.ws.DataWebService;

/**
 * @author lijianzhong
 * 
 */
public class DataWebServiceTestCase extends BaseTestCase {

	@Autowired
	private DataWebService dataTestService;

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
