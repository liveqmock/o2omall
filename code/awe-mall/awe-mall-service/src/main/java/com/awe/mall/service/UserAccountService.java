package com.awe.mall.service;

import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 用户账号服务
 * 
 * @author ljz
 * @version 2014-12-30 下午5:02:43
 */
public interface UserAccountService {
    /**
     * 用户注册
     * 
     * @param username
     *            用户注册账号
     * @param password
     *            用户注册密码
     * @return Wrapper 接口返回的数据对象
     */
    Wrapper<?> register(String username, String password);

    /**
     * 用户登录
     * 
     * @param username
     *            用户注册账号
     * @param password
     *            用户注册密码
     * @return UserAccountResponseDto 接口返回的数据对象
     */
    UserAccountResponseDto login(String username, String password);

    /**
     * 用户修改密码
     * 
     * @param requestDto
     * @return
     */
    Wrapper<?> modifyPassword(PasswordModifyRequestDto requestDto);

    /**
     * 用户重置密码
     * 
     * @param requestDto
     * @return
     */
    Wrapper<?> resetPassword(PasswordModifyRequestDto requestDto);
}
