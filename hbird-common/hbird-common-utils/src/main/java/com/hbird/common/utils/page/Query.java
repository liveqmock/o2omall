package com.hbird.common.utils.page;

/**
 * 公共查询类 User: ljz DateTime: 2014-4-4 下午08:03:35 Version: 1.0
 */
public class Query {

    /**
     * 分页后的记录开始的地方 第一条记录是1(Oracle)
     */
    private int startRow;
    /**
     * 分页后的记录结束的地方(Oracle)
     */
    private int endRow;

    /** 每页大小 */
    private int pageSize;

    /** 当前页 */
    private int pageIndex;

    /** 开始记录（Mysql） */
    private int startIndex;
    /** 当前页 */
    private int page;
    /** 每页记录数 */
    private int rows;

    public int getStartIndex() {
        if (startIndex == 0 && getStartRow() > 0) {
            return getStartRow() - 1;
        }

        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageIndex() {
        return (pageIndex == 0) ? 1 : pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 默认构造函数
     */
    public Query() {
    }

    /**
     * 构造函数（带分页信息）
     */
    public Query(int pageIndex, int pageSize) {
        setPageIndex(pageIndex);
        setPageSize(pageSize);
    }

    public int getStartRow() {
        int start = this.startRow;
        if (start == 0) {
            start = (getPageIndex() - 1) * getPageSize() + 1;
        }
        return start;
    }

    public int getEndRow() {
        int end = this.endRow;
        if (end == 0) {
            end = getPageIndex() * getPageSize();
        }
        return end;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPage() {
        return (page == 0) ? 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
