/**
 * 
 */
package com.hbird.portal.sdk.response;

import java.util.List;

import com.hbird.portal.sdk.dto.User;
import com.hbird.common.sdk.api.response.HbirdPageResponse;

/**
 * 用户集合返回对象<br/>
 * 提供接口时方法的返回集合对象,支持分页
 * 
 * @author ljz
 * 
 */
public class UserPageListResponse extends HbirdPageResponse<List<User>> {

    /**
     * 
     */
    private static final long serialVersionUID = -7270811868657607385L;

}
