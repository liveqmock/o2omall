package com.hbird.common.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.hbird.common.sdk.api.response.HbirdPageResponse;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.page.PageUtil;

/**
 * 抽象rest服务客户端实现类，使用默认的RestTemplate实现，支持配置服务地址和超时时间
 * 
 * @author ljz
 * @see org.springframework.web.client.RestTemplate
 * @see org.springframework.http.client.SimpleClientHttpRequestFactory
 */
public abstract class AbstractClient implements InitializingBean {

    protected final Log logger = LogFactory.getLog(this.getClass());

    /**
     * 链接超时时间
     */
    private int connectTimeout = -1;

    /**
     * 读超时时间
     */
    private int readTimeout = -1;

    /**
     * restTemplate
     */
    private RestTemplate restTemplate;

    /**
     * 服务地址, 如its rest service : http://itsws.shop.hbird.com/
     */
    private String serviceUrlDomain;

    /**
     * get the ServiceUrlDomain
     * 
     * @return the serviceUrlDomain
     */
    public String getServiceUrlDomain() {
        return serviceUrlDomain;
    }

    /**
     * set the ServiceUrlDomain
     * 
     * @param serviceUrlDomain
     *            the serviceUrlDomain to set
     */
    public void setServiceUrlDomain(String serviceUrlDomain) {
        this.serviceUrlDomain = serviceUrlDomain;
    }

    /**
     * getRestTemplate
     * 
     * @return the RestTemplate
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * set the RestTemplate
     * 
     * @param restTemplate
     *            the restTemplate to set
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        if (null != restTemplate) {
            this.restTemplate = restTemplate;
        }
    }

    /**
     * @return the connectTimeout
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * @return the readTimeout
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * 设置连接超时时间，单位：毫秒
     * 
     * @param connectTimeout
     *            the connectTimeout to set. Default is the system's default timeout.
     * @see org.springframework.http.client.SimpleClientHttpRequestFactory#setConnectTimeout
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * 设置连接超时时间，单位：毫秒
     * 
     * @param readTimeout
     *            the readTimeout to set. Default is the system's default timeout.
     * @see org.springframework.http.client.SimpleClientHttpRequestFactory#setReadTimeout
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(serviceUrlDomain, "请配置服务域名(属性serviceUrlDomain)的值，class=" + this.getClass().getName());
        if (null == restTemplate) {
            restTemplate = new RestTemplate();
        }
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(readTimeout);
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(connectTimeout);
    }

    /**
     * 判断返回值是否是成功
     * 
     * @param response
     * @return
     * @see com.hbird.common.utils.wrap.Wrapper#isSuccess
     */
    public <T> boolean isSuccess(HbirdResponse<T> response) {
        return null != response && response.isSuccess();
    }

    /**
     * get response's result
     * 
     * @param response
     * @return
     * @see com.hbird.common.utils.wrap.Wrapper#getResult
     */
    public <T> T getResult(HbirdResponse<T> response) {
        if (this.isSuccess(response)) {
            return response.getResult();
        }
        return null;
    }

    /**
     * get response's PageUtil
     * 
     * @param response
     * @return
     * @see com.hbird.common.sdk.api.response.HbirdPageResponse#getPageUtil
     */
    public <T> PageUtil getPageUtil(HbirdPageResponse<T> response) {
        if (this.isSuccess(response)) {
            return response.getPageUtil();
        }
        return null;
    }
}
