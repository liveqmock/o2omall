/**
 * 
 */
package com.hbird.common.sdk.api.response;

import com.hbird.common.sdk.api.hbirdObject;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 基本返回对象
 * 
 * @param <T>
 *            DTO对象
 * @author lz
 * 
 */
public class hbirdResponse<T> extends Wrapper<T> implements hbirdObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public hbirdResponse() {
        super();
    }

    /**
     * @param code
     * @param message
     * @param result
     */
    public hbirdResponse(int code, String message, T result) {
        super(code, message, result);
    }

    /**
     * @param code
     * @param message
     */
    public hbirdResponse(int code, String message) {
        super(code, message);
    }

    /**
     * @param result
     */
    public hbirdResponse(T result) {
        super();
        super.setResult(result);
    }

}
