package com.awe.rems.sdk.request;

import com.awe.rems.sdk.request.dto.RefundRequestDto;
import com.hbird.common.sdk.api.request.HbirdPageSecureRequest;
import com.hbird.common.utils.page.PageUtil;

/**
 * RefundRequest：退款表请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class RefundRequest extends HbirdPageSecureRequest<RefundRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public RefundRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public RefundRequest(String key, RefundRequestDto content) {
        super(key, content);
    }
    public RefundRequest(String key, RefundRequestDto content, PageUtil pageUtil) {
        super(key, content, pageUtil);
    }
}
