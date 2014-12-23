package com.hbird.portal.clients.sso;

import com.hbird.common.client.AbstractClient;

/**
 * @author ljz
 * @version 2014-11-27 下午8:02:59
 */
public class AbstractSsoClient extends AbstractClient {
    protected static final int MILLIS_PER_SECOND = 1000;
    /** site */
    private String site;

    /** signKey */
    private String signKey;

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site
     *            the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * @return the signKey
     */
    public String getSignKey() {
        return signKey;
    }

    /**
     * @param signKey
     *            the signKey to set
     */
    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    /**
     * 获取当前时间戳 ：以秒为单位
     * 
     * @return
     */
    protected String getTimestamp() {
        int second = (int) (System.currentTimeMillis() / MILLIS_PER_SECOND);
        return String.valueOf(second);
    }
}
