package com.hbird.common.utils.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页记录 User: gaohongjing Date: 2014-4-3 Time: 17:42:28
 */
public class PaginatedArrayList<T> {
    /**
     * 默认每页的记录数量
     */
    public static final int PAGESIZE_DEFAULT = 20;
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 当前页。第一页是1
     */
    private int index;

    /**
     * 总记录数
     */
    private int totalItem;
    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 分页后的记录开始的地方 第一条记录是1
     */
    private int startRow;
    /**
     * 分页后的记录结束的地方
     */
    private int endRow;

    private List<T> rows = new ArrayList<T>();

    /**
     * 增加所有集合
     * 
     * @param rows
     */
    public void addAll(List<T> list) {
        getRows().addAll(list);
    }

    /**
     * 集合大小
     * 
     * @param rows
     */
    public int size() {
        return getRows().size();
    }

    /**
     * 增加对象
     * 
     * @param rows
     */
    public void add(T t) {
        getRows().add(t);
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    /**
     * 默认构造方法
     */
    public PaginatedArrayList() {
        repaginate();
        // setRows(new ArrayList<T>());
    }

    /**
     * 带当前页和页大小的构造方法
     * 
     * @param index
     *            当前页
     * @param pageSize
     *            页大小
     */
    public PaginatedArrayList(int index, int pageSize) {
        this.index = index;
        this.pageSize = pageSize;
        repaginate();
    }
    
    /**
     * 带当前页和页大小的构造方法
     * 
     * @param index
     *            当前页
     * @param pageSize
     *            页大小
     */
    public PaginatedArrayList(Query query) {
        this.index = query.getPageIndex();
        this.pageSize = query.getPageSize();
        repaginate();
    }

    /**
     * Method getPageSize returns the pageSize of this PaginatedArrayList object.
     * 
     * 每页大小
     * 
     * @return the pageSize (type int) of this PaginatedArrayList object.
     */

    public int getPageSize() {
        return pageSize;
    }

    /**
     * Method setPageSize sets the pageSize of this PaginatedArrayList object.
     * 
     * 每页大小
     * 
     * @param pageSize
     *            the pageSize of this PaginatedArrayList object.
     * 
     */

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        repaginate();
    }

    /**
     * Method getIndex returns the index of this PaginatedArrayList object.
     * 
     * 当前页。第一页是1
     * 
     * @return the index (type int) of this PaginatedArrayList object.
     */

    public int getIndex() {
        return index;
    }

    /**
     * Method setIndex sets the index of this PaginatedArrayList object.
     * 
     * 当前页。第一页是1
     * 
     * @param index
     *            the index of this PaginatedArrayList object.
     * 
     */

    public void setIndex(int index) {
        this.index = index;
        repaginate();
    }

    /**
     * Method getTotalItem returns the totalItem of this PaginatedArrayList object.
     * 
     * 总记录数
     * 
     * @return the totalItem (type int) of this PaginatedArrayList object.
     */

    public int getTotalItem() {
        return totalItem;
    }

    /**
     * Method setTotalItem sets the totalItem of this PaginatedArrayList object.
     * 
     * 总记录数
     * 
     * @param totalItem
     *            the totalItem of this PaginatedArrayList object.
     * 
     */

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
        repaginate();
    }

    /**
     * Method getTotalPage returns the totalPage of this PaginatedArrayList object.
     * 
     * 总页数
     * 
     * @return the totalPage (type int) of this PaginatedArrayList object.
     */

    public int getTotalPage() {
        return totalPage;
    }

    /**
     * Method getStartRow returns the startRow of this PaginatedArrayList object.
     * 
     * 分页后的记录开始的地方
     * 
     * @return the startRow (type int) of this PaginatedArrayList object.
     */

    public int getStartRow() {
        return startRow;
    }

    /**
     * Method getEndRow returns the endRow of this PaginatedArrayList object.
     * 
     * 分页后的记录结束的地方
     * 
     * @return the endRow (type int) of this PaginatedArrayList object.
     */

    public int getEndRow() {
        return endRow;
    }

    /**
     * Method repaginate ...
     */
    private void repaginate() {
        if (pageSize < 1) { // 防止程序偷懒，list和分页的混合使用
            pageSize = PAGESIZE_DEFAULT;
        }
        if (index < 1) {
            index = 1;// 恢复到第一页
        }
        if (totalItem > 0) {
            totalPage = totalItem / pageSize + (totalItem % pageSize > 0 ? 1 : 0);
            if (index > totalPage) {
                index = totalPage; // 最大页
            }
            endRow = index * pageSize;
            startRow = endRow - pageSize;
            if (endRow > totalItem) {
                endRow = totalItem;
            }
        }
    }

}
