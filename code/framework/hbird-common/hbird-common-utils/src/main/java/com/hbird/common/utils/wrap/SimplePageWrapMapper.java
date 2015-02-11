package com.hbird.common.utils.wrap;

/**
 * 简单分页包装辅助类.
 * 
 * @author ljz
 */
public class SimplePageWrapMapper {

    /**
     * Instantiates a new page wrap mapper.
     */
    private SimplePageWrapMapper() {
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
    public static <E> SimplePageWrapper<E> wrap(int code, String message, E o, int totalRow, int totalPage) {
        return new SimplePageWrapper<E>(code, message, o, totalRow, totalPage);
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
    public static <E> SimplePageWrapper<E> wrap(E o, int totalRow, int totalPage) {
        return wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, o, totalRow, totalPage);
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
    public static <E> SimplePageWrapper<E> wrap(int code, String message) {
        return wrap(code, message, null, 0, 0);
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
    public static <E> SimplePageWrapper<E> wrap(int code) {
        return wrap(code, null);
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
    public static <E> SimplePageWrapper<E> wrap(Exception e) {
        return wrap(Wrapper.ERROR_CODE, e.getMessage());
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
    public static <E> E unWrap(SimplePageWrapper<E> wrapper) {
        return wrapper.getResult();
    }

    /**
     * Wrap ERROR. code=100
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> SimplePageWrapper<E> illegalArgument() {
        return wrap(Wrapper.ILLEGAL_ARGUMENT_CODE_, Wrapper.ILLEGAL_ARGUMENT_MESSAGE);
    }

    /**
     * Wrap ERROR. code=500
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> SimplePageWrapper<E> error() {
        return wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE);
    }

    /**
     * Wrap SUCCESS. code=200
     * 
     * @param <E>
     *            the element type
     * @return the wrapper< e>
     */
    public static <E> SimplePageWrapper<E> ok() {
        return new SimplePageWrapper<E>();
    }
}
