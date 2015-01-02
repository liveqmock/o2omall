package com.awe.uc.sdk.api.response;

import com.hbird.common.sdk.api.response.HbirdResponse;

/**
 * PasswordModifyResponse：用户密码修改的返回对象<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2015-1-2 下午4:47:39
 */
public class PasswordModifyResponse extends HbirdResponse<Object> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /** 错误码：账号错误或不存在 */
    public static final int ACCOUNT_ERROR_CODE = 1001;

    /** 错误信息：账号错误或不存在 */
    public static final String ACCOUNT_ERROR_MESSAGE = "账号错误或不存在";

    /** 错误码：修改失败，原始密码错误 */
    public static final int MODIFY_FAIL_CODE = 1002;

    /** 错误信息：修改失败，原始密码错误 */
    public static final String MODIFY_FAIL_MESSAGE = "修改密码失败，原始密码错误";
}
