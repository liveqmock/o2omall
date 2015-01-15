package com.awe.test.rems.rest.response;

import java.util.List;

import com.awe.test.rems.rest.response.dto.RefundResponseDto;
import com.hbird.common.sdk.api.response.HbirdPageResponse;

/**
 * RefundResponse：退款表返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
 * 
 */
public class RefundResponseList extends HbirdPageResponse<List<RefundResponseDto>> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
}
