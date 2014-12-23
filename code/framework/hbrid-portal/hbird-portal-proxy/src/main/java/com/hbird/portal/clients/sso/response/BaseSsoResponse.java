package com.hbird.portal.clients.sso.response;

import com.hbird.portal.clients.sso.response.dto.Respond;

/**
 * SSO通用返回对象
 * 
 * @author ljz
 * @version 2014-11-27 下午9:24:46
 * @param <T>
 *            泛型对象
 */
public abstract class BaseSsoResponse<T> implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Respond respond;

    private T objects;

    /**
     * @return the respond
     */
    public Respond getRespond() {
        return respond;
    }

    /**
     * @param respond
     *            the respond to set
     */
    public void setRespond(Respond respond) {
        this.respond = respond;
    }

    /**
     * @return the objects
     */
    public T getObjects() {
        return objects;
    }

    /**
     * @param objects
     *            the objects to set
     */
    public void setObjects(T objects) {
        this.objects = objects;
    }

}
