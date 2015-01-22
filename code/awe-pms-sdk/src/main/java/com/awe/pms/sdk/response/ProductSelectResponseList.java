package com.awe.pms.sdk.response;

import java.util.List;

import com.awe.pms.sdk.response.dto.ProductSelectResponseDto;
import com.hbird.common.sdk.api.response.HbirdPageResponse;

/**
 * ProductSelectResponseList：商品查询综合表返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2015-1-21 10:47:35
 * 
 */
public class ProductSelectResponseList extends HbirdPageResponse<List<ProductSelectResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
