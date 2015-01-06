package com.hbird.common.sdk.api.request;

import com.hbird.common.utils.page.PageUtil;

/**
 * 安全请求对象,支持分页
 * 
 * @author ljz
 * @version 2015-1-6 下午4:58:45
 */
public class HbirdPageSecureRequest<T> extends HbirdSecureRequest<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 分页数据 */
    private PageUtil pageUtil;

    /**
     * 
     */
    public HbirdPageSecureRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public HbirdPageSecureRequest(String key, T content) {
        super(key, content);
    }

    /**
     * @param pageUtil
     */
    public HbirdPageSecureRequest(PageUtil pageUtil) {
        super();
        this.pageUtil = pageUtil;
    }

    /**
     * @param key
     * @param content
     * @param pageUtil
     */
    public HbirdPageSecureRequest(String key, T content, PageUtil pageUtil) {
        super(key, content);
        this.pageUtil = pageUtil;
    }

    /**
     * @return the pageUtil
     */
    public PageUtil getPageUtil() {
        return pageUtil;
    }

    /**
     * @param pageUtil
     *            the pageUtil to set
     */
    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

}
