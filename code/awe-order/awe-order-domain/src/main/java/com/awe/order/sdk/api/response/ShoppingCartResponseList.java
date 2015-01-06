package com.awe.order.sdk.api.response;

import java.util.List;

import com.awe.order.sdk.api.response.dto.ShoppingCartResponseDto;
import com.hbird.common.sdk.api.response.HbirdResponse;

/**
 * ShoppingCartResponse：购物车返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public class ShoppingCartResponseList extends HbirdResponse<List<ShoppingCartResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
