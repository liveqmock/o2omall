package com.hbird.common.utils.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 自定义Spring辅助类，实现ApplicationContextAware，获取BeanFactory中的定义的对象和ApplicationContext
 * 
 * @author ljz
 * 
 * @see org.springframework.context.ApplicationContextAware
 */
public class SpringHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringHelper.applicationContext == null) {
            SpringHelper.applicationContext = applicationContext;
        }
    }

    /**
     * get the spring ApplicationContext
     * 
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return SpringHelper.applicationContext;
    }

    /**
     * get the Bean of BeanFactory by bean name.
     * 
     * @param beanName
     *            the beanName defined in spring configure file.
     * @return
     */
    public static Object getBean(String beanName) {
        return SpringHelper.applicationContext.getBean(beanName);
    }

}
