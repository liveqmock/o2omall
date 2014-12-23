package com.hbird.common.utils.wrap;

import com.hbird.common.utils.page.PageUtil;

/**
 * 分页包装辅助类.
 * 
 * @author ljz
 */
public class PageWrapMapper {

    /**
     * Instantiates a new page wrap mapper.
     */
    private PageWrapMapper() {
    }

    /**
     * Wrap.
     * 
     * @param <E>
     *            the element type
     * @param code
     *            the code
     * @param message
     *            the message
     * @param o
     *            the o
     * @param pageUtil
     *            the pageUtil
     * @return the wrapper
     */
    public static <E> PageWrapper<E> wrap(int code, String message, E o, PageUtil pageUtil) {
        return new PageWrapper<E>(code, message, o, pageUtil);
    }

    /**
     * Wrap data with default code=200.
     * 
     * @param <E>
     *            the element type
     * @param o
     *            the o
     * @param pageUtil
     *            the pageUtil
     * @return the wrapper
     */
    public static <E> PageWrapper<E> wrap(E o, PageUtil pageUtil) {
        return wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, o, pageUtil);
    }

    /**
     * Wrap.
     * 
     * @param <E>
     *            the element type
     * @param code
     *            the code
     * @param message
     *            the message
     * @return the wrapper
     */
    public static <E> PageWrapper<E> wrap(int code, String message) {
        return wrap(code, message, null, null);
    }

    /**
     * Wrap.
     * 
     * @param <E>
     *            the element type
     * @param code
     *            the code
     * @return the wrapper< e>
     */
    public static <E> PageWrapper<E> wrap(int code) {
        return wrap(code, null, null, null);
    }

    /**
     * Wrap.
     * 
     * @param <E>
     *            the element type
     * @param e
     *            the e
     * @return the wrapper
     */
    public static <E> PageWrapper<E> wrap(Exception e) {
        return new PageWrapper<E>(Wrapper.ERROR_CODE, e.getMessage(), null, null);
    }

    /**
     * Un wrapper.
     * 
     * @param <E>
     *            the element type
     * @param wrapper
     *            the wrapper
     * @return the e
     */
    public static <E> E unWrap(PageWrapper<E> wrapper) {
        return wrapper.getResult();
    }

    /**
     * Wrap ERROR. code=100
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> PageWrapper<E> illegalArgument() {
        return wrap(Wrapper.ILLEGAL_ARGUMENT_CODE_, Wrapper.ILLEGAL_ARGUMENT_MESSAGE, null, null);
    }

    /**
     * Wrap ERROR. code=500
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> PageWrapper<E> error() {
        return wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE, null, null);
    }

    /**
     * Wrap SUCCESS. code=200
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> PageWrapper<E> ok() {
        return new PageWrapper<E>();
    }
}
