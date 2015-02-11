package com.hbird.common.ws.wap.request;

import javax.ws.rs.QueryParam;

/**
 * WAP请求基类:支持分页
 * 
 * @author ljz
 * @version 2015-2-10 上午11:44:54
 */
public class HbirdFormPageRequest extends HbirdFormRequest {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** 分页的每页大小 */
    @QueryParam("pageSize")
    private int pageSize = 15;

    /** 分页的当前页码 */
    @QueryParam("curPage")
    private int curPage = 1;

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the curPage
     */
    public int getCurPage() {
        return curPage;
    }

    /**
     * @param curPage
     *            the curPage to set
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

}
