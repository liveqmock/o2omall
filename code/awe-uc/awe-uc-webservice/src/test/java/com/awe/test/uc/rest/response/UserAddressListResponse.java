package com.awe.test.uc.rest.response;

import java.util.List;

import com.hbird.common.sdk.api.response.HbirdResponse;
import com.awe.test.uc.rest.response.dto.UserAddressResponseDto;

/**
 * UserAddressResponse：收货地址集合的返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class UserAddressListResponse extends HbirdResponse<List<UserAddressResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
