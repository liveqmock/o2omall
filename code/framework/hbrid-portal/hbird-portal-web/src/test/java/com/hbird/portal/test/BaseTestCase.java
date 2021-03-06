package com.hbird.portal.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * BaseTestCase without Transaction
 * 
 * @author ljz
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-config.xml" })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public abstract class BaseTestCase extends AbstractJUnit4SpringContextTests {

}
