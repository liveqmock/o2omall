package com.hbird.portal.clients.sso.response.dto;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-16 上午09:00:31
 */
public class Respond implements java.io.Serializable {

    private static final long serialVersionUID = -5561454712665303569L;

    private String status;

    private String code;

    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
