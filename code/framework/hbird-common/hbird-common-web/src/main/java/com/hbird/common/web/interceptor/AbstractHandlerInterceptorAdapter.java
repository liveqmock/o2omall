package com.hbird.common.web.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 抽象的拦截器：定义排除路径
 * 
 * @author ljz
 * @version 2014-12-2 下午6:03:09
 */
public abstract class AbstractHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    /** URL拦截器的排除路径，多个以逗号隔开 */
    private String excludePaths;

    /**
     * @return the excludePaths
     */
    public String getExcludePaths() {
        return excludePaths;
    }

    /**
     * @param excludePaths
     *            the excludePaths to set
     */
    public void setExcludePaths(String excludePaths) {
        this.excludePaths = excludePaths;
    }
}
