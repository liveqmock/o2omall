package com.awe.pms.sdk.request;

import com.hbird.common.sdk.api.request.HbirdSecureRequest;
import com.awe.pms.sdk.request.dto.SkuImagesRequestDto;

/**
 * SkuImagesRequest：sku图片请求参数
 * 
 * @author ljz
 * @version 2014-12-25 9:31:58
 * 
 */
public class SkuImagesRequest extends HbirdSecureRequest<SkuImagesRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public SkuImagesRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public SkuImagesRequest(String key, SkuImagesRequestDto content) {
        super(key, content);
    }
}
