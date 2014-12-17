/**
 * 
 */
package com.hbird.common.sdk.api.response;

import com.hbird.common.utils.page.PageUtil;

/**
 * 基本返回对象：支持分页
 * 
 * @author lz
 * 
 */
public class hbirdPageResponse<T> extends hbirdResponse<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** 分页数据 */
    private PageUtil pageUtil;

    /**
     * 
     */
    public hbirdPageResponse() {
        super();
    }

    /**
     * @param code
     * @param message
     */
    public hbirdPageResponse(int code, String message) {
        super(code, message);
    }

    /**
     * @param code
     * @param message
     * @param result
     */
    public hbirdPageResponse(int code, String message, T result) {
        super(code, message, result);
    }

    /**
     * @param code
     * @param message
     * @param result
     * @param pageUtil
     */
    public hbirdPageResponse(int code, String message, T result, PageUtil pageUtil) {
        super(code, message, result);
        this.pageUtil = pageUtil;
    }

    /**
     * @param result
     */
    public hbirdPageResponse(T result) {
        super(result);
    }

    /**
     * @param result
     * @param pageUtil
     */
    public hbirdPageResponse(T result, PageUtil pageUtil) {
        super(result);
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
