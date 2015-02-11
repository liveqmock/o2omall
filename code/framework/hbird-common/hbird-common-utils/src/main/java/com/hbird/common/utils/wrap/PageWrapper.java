package com.hbird.common.utils.wrap;

import com.hbird.common.utils.page.PageUtil;

/**
 * 支持数据分页的包装类
 * 
 * @author ljz
 * 
 * @param <T>
 */
public class PageWrapper<T> extends Wrapper<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 666985064788933395L;

    /** 分页 */
    private PageUtil pageUtil;

    /**
     * 
     */
    public PageWrapper() {
        super();
    }

    /**
     * @param code
     * @param message
     */
    public PageWrapper(int code, String message) {
        super(code, message);
    }

    /**
     * Instantiates a new pageWrapper default code=200
     * 
     * @param code
     * @param message
     * @param result
     * @param pageUtil
     */
    public PageWrapper(T result, PageUtil pageUtil) {
        super();
        this.setResult(result);
        this.setPageUtil(pageUtil);
    }

    /**
     * @param code
     * @param message
     * @param result
     * @param pageUtil
     */
    public PageWrapper(int code, String message, T result, PageUtil pageUtil) {
        super(code, message, result);
        this.pageUtil = pageUtil;
    }

    /**
     * @param pageUtil
     *            the pageUtil to set
     */
    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    /**
     * @return the pageUtil
     */
    public PageUtil getPageUtil() {
        return pageUtil;
    }

    /**
     * Sets the 分页数据 ，返回自身的引用.
     * 
     * @param result
     *            the new 分页数据
     * 
     * @return the wrapper
     */
    public PageWrapper<T> pageUtil(PageUtil pageUtil) {
        this.setPageUtil(pageUtil);
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
    public PageWrapper<T> result(T result) {
        super.setResult(result);
        return this;
    }
}
