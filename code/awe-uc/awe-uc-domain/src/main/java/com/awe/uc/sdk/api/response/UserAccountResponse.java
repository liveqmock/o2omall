package com.awe.uc.sdk.api.response;

import com.hbird.common.sdk.api.response.HbirdResponse;
import com.awe.uc.sdk.api.response.dto.UserAccountResponseDto;

/**
 * UserAccountResponse：用户账号返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public class UserAccountResponse extends HbirdResponse<UserAccountResponseDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** 错误码：注册失败，账号已注册*/
    public static final int REGISTER_FAIL_CODE = 1001;

    /** 错误信息：注册失败，账号已注册 */
    public static final String REGISTER_FAIL_MESSAGE = "注册失败，账号已注册";

    /** 错误码：注册失败，未知错误*/
    public static final int REGISTER_ERROR_CODE = 1002;

    /** 错误信息：注册失败，未知错误 */
    public static final String REGISTER_ERROR_MESSAGE = "注册失败，未知错误";

    /** 错误码：登录失败，账号或密码错误 */
    public static final int LOGIN_FAIL_CODE = 2001;

    /** 错误信息：登录失败，账号或密码错误 */
    public static final String LOGIN_FAIL_MESSAGE = "登录失败，账号或密码错误";
}
