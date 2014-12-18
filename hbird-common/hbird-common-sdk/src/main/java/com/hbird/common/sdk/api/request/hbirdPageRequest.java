/**
 * 
 */
package com.hbird.common.sdk.api.request;

import com.hbird.common.utils.page.PageUtil;

/**
 * 基本请求对象,支持分页
 * 
 * @author ljz
 * 
 */
public class HbirdPageRequest extends HbirdRequest {

    /**
     * 
     */
    private static final long serialVersionUID = -3839959616634018281L;

    /** 分页数据 */
    private PageUtil pageUtil;

    /**
     * 
     */
    public HbirdPageRequest() {
        super();
    }

    /**
     * @param pageUtil
     */
    public HbirdPageRequest(PageUtil pageUtil) {
        super();
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
