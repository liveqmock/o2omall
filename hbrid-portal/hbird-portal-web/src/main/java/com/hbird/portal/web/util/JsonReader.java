package com.hbird.portal.web.util;

import com.hbird.common.utils.page.PaginatedArrayList;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-10 上午11:18:08
 */
public class JsonReader extends JsonResult {

    /**
     * 当前页数
     */
    private int currpage;

    /**
     * 总页数
     */
    private int totalpages;

    /**
     * 总记录数
     */
    private int totalrecords;

    public JsonReader() {
        super();
    }

    public JsonReader(int currpage) {
        this();
        this.currpage = currpage;
    }

    /**
     * 设置返回分页对象
     * 
     * @param paginatedData
     */
    public void setPaginatedData(@SuppressWarnings("rawtypes") PaginatedArrayList paginatedData) {
        this.totalpages = paginatedData.getTotalPage();
        this.totalrecords = paginatedData.getTotalItem();
        setResult(paginatedData.getRows());
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public int getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(int totalrecords) {
        this.totalrecords = totalrecords;
    }
}
