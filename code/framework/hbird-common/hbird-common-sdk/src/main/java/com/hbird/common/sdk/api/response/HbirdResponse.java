/**
 * 
 */
package com.hbird.common.sdk.api.response;

import com.hbird.common.sdk.api.HbirdObject;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 基本返回对象
 * 
 * @param <T>
 *            DTO对象
 * @author ljz
 * 
 */
public class HbirdResponse<T> extends Wrapper<T> implements HbirdObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public HbirdResponse() {
        super();
    }

    /**
     * @param code
     * @param message
     * @param result
     */
    public HbirdResponse(int code, String message, T result) {
        super(code, message, result);
    }

    /**
     * @param code
     * @param message
     */
    public HbirdResponse(int code, String message) {
        super(code, message);
    }

    /**
     * @param result
     */
    public HbirdResponse(T result) {
        super();
        super.setResult(result);
    }

}
