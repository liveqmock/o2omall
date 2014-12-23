package com.hbird.portal.web.util;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-9 下午05:37:38
 */
public class JsonResult {

    public static final int CODE_SUCCESS = 200;
    public static final String MESSAGE_SUCCESS = "操作成功";
    public static final int CODE_PARAM_ERROR = 10000;
    public static final String MESSAGE_PARAM_ERROR = "参数有误";
    public static final int CODE_SERVER_ERROR = 20000;
    public static final String MESSAGE_SERVER_ERROR = "服务器异常";
    public static final int CODE_FAIL = 30000;
    public static final String MESSAGE_FAIL = "操作失败，请稍后重试";
    public static final int CODE_EXIST_ERROR = 40000;
    public static final String MESSAGE_EXIST_ERROR = "已存在，不能重复添加";

    /**
     * The result code.
     */
    private int code;

    /**
     * The result message.
     */
    private String message;

    /** The result. */
    private Object result;

    public JsonResult() {
        this.code = CODE_SUCCESS;
        this.message = MESSAGE_SUCCESS;
    }

    public JsonResult(Object result) {
        this.code = CODE_SUCCESS;
        this.message = MESSAGE_SUCCESS;
        this.result = result;
    }

    public JsonResult(int code, Object result) {
        this.code = code;
        this.result = result;
    }

    public JsonResult(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /** set error result */
    public void setError() {
        this.setCode(CODE_SERVER_ERROR);
        this.setMessage(MESSAGE_SERVER_ERROR);
    }

    /** set fail result */
    public void setFail() {
        this.setCode(CODE_FAIL);
        this.setMessage(MESSAGE_FAIL);
    }

    /** set error result */
    public void setExist() {
        this.setCode(CODE_EXIST_ERROR);
        this.setMessage(MESSAGE_EXIST_ERROR);
    }

}
