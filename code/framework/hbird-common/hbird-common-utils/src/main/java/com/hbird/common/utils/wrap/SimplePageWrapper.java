package com.hbird.common.utils.wrap;

/**
 * 支持数据简单分页的包装类
 * 
 * @author ljz
 * 
 * @param <T>
 */
public class SimplePageWrapper<T> extends Wrapper<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 666985064788933395L;

    /** The total row. 总条数 */
    private int totalRow = 0;

    /** The total page.总页数 */
    private int totalPage = 0;

    /**
     * 
     */
    public SimplePageWrapper() {
        super();
    }

    /**
     * @param code
     * @param message
     */
    public SimplePageWrapper(int code, String message) {
        super(code, message);
    }

    /**
     * 
     * @param code
     * @param message
     * @param result
     * @param totalRow
     * @param totalPage
     */
    public SimplePageWrapper(int code, String message, T result, int totalRow, int totalPage) {
        super(code, message, result);
        this.setTotalRow(totalRow);
        this.setTotalPage(totalPage);
    }

    /**
     * @return the totalRow
     */
    public int getTotalRow() {
        return totalRow;
    }

    /**
     * @param totalRow
     *            the totalRow to set
     */
    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    /**
     * @return the totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage
     *            the totalPage to set
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * Sets the 分页数据 ，返回自身的引用.
     * 
     * @param totalRow
     *            the totalRow
     * @param totalPage
     *            the totalPage
     * @return the wrapper
     */
    public SimplePageWrapper<T> page(int totalRow, int totalPage) {
        this.setTotalRow(totalRow);
        this.setTotalPage(totalPage);
        return this;
    }

    /**
     * Sets the 结果数据 ，返回自身的引用.
     * 
     * @param result
     *            the new 结果数据
     * 
     * @return the wrapper
     */
    @Override
    public SimplePageWrapper<T> result(T result) {
        super.setResult(result);
        return this;
    }
}
