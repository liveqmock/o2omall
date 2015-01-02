package com.awe.uc.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.awe.uc.sdk.api.request.PasswordModifyRequest;
import com.awe.uc.sdk.api.request.UserAccountRequest;
import com.awe.uc.sdk.api.request.dto.PasswordModifyRequestDto;
import com.awe.uc.sdk.api.request.dto.UserAccountRequestDto;
import com.awe.uc.sdk.api.response.PasswordModifyResponse;
import com.awe.uc.sdk.api.response.UserAccountResponse;
import com.awe.uc.sdk.api.response.dto.UserAccountResponseDto;
import com.awe.uc.service.UserAccountService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.security.MD5Util;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 用户账号REST服务：提供有关用户账号的接口
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
@Component
@Path("services")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UserAccountResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserAccountService userAccountService;

    /**
     * 查询用户账号信息
     * 
     * @param request
     *            用户账号请求参数
     * @return 用户账号返回对象
     * 
     */
    @POST
    @Path("/userAccount/getUserAccount")
    public Wrapper<?> getUserAccount(UserAccountRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("getUserAccount 拒绝访问");
            return WrapMapper.forbidden();
        }

        UserAccountRequestDto requestDto = request.getContent();
        if (null == requestDto || null == requestDto.getId()) {
            this.logger.error("getUserAccount 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccount userAccount = userAccountService.getUserAccountById(requestDto.getId());
            UserAccountResponseDto responseDto = convert(userAccount);
            return WrapMapper.ok().result(responseDto);
        } catch (Exception e) {
            this.logger.error("查询用户账号数据异常", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户注册
     * 
     * @param request
     *            用户账号请求参数
     * @return 用户注册结果
     * 
     */
    @POST
    @Path("/userAccount/register")
    public Wrapper<?> register(UserAccountRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("register 拒绝访问");
            return WrapMapper.forbidden();
        }

        UserAccountRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isBlank(requestDto.getUsername())
                || StringUtils.isBlank(requestDto.getPassword())) {
            this.logger.error("register 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(requestDto.getUsername());
            userAccount.setPassword(MD5Util.md5Hex(requestDto.getPassword()));
            userAccount.setCreateUser(requestDto.getUsername());
            userAccount.setLoginTimes(0);
            boolean result = userAccountService.insert(userAccount);
            if (result) {
                return WrapMapper.ok();
            } else {
                logger.warn("用户注册失败，未知错误， username=" + requestDto.getUsername());
                return WrapMapper.wrap(UserAccountResponse.REGISTER_ERROR_CODE,
                        UserAccountResponse.REGISTER_ERROR_MESSAGE);
            }
        } catch (ExistedException e) {
            logger.warn("用户注册失败，账号已经存在，username=" + requestDto.getUsername());
            return WrapMapper.wrap(UserAccountResponse.REGISTER_FAIL_CODE, UserAccountResponse.REGISTER_FAIL_MESSAGE);
        } catch (Exception e) {
            this.logger.error("用户注册异常，username=" + requestDto.getUsername(), e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户登录
     * 
     * @param request
     *            用户账号请求参数
     * @return 用户账号返回对象
     * 
     */
    @POST
    @Path("/userAccount/login")
    public Wrapper<?> login(UserAccountRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("login 拒绝访问");
            return WrapMapper.forbidden();
        }

        UserAccountRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isBlank(requestDto.getUsername())
                || StringUtils.isBlank(requestDto.getPassword())) {
            this.logger.error("login 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccountQuery queryBean = new UserAccountQuery();
            queryBean.setUsername(requestDto.getUsername());

            UserAccount userAccount = null;
            List<UserAccount> list = userAccountService.queryUserAccountList(queryBean);
            if (!CollectionUtils.isEmpty(list)) {
                userAccount = list.get(0);
            }
            if (null != userAccount && MD5Util.md5Hex(requestDto.getPassword()).equals(userAccount.getPassword())) {
                UserAccountResponseDto responseDto = convert(userAccount);
                return WrapMapper.ok().result(responseDto);
            } else {
                logger.warn("用户登录失败， username=" + requestDto.getUsername());
                return WrapMapper.wrap(UserAccountResponse.LOGIN_FAIL_CODE, UserAccountResponse.LOGIN_FAIL_MESSAGE);
            }
        } catch (Exception e) {
            this.logger.error("用户登录异常，username=" + requestDto.getUsername(), e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户修改密码
     * 
     * @param request
     * @return
     */
    @POST
    @Path("/userAccount/modifyPassword")
    public Wrapper<?> modifyPassword(PasswordModifyRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("modifyPassword 拒绝访问");
            return WrapMapper.forbidden();
        }

        PasswordModifyRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isBlank(requestDto.getUsername())
                || StringUtils.isBlank(requestDto.getOldPassword()) || StringUtils.isBlank(requestDto.getNewPassword())
                || StringUtils.isBlank(requestDto.getMobile())) {
            this.logger.error("modifyPassword 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccountQuery queryBean = new UserAccountQuery();
            queryBean.setUsername(requestDto.getUsername());

            UserAccount userAccount = null;
            List<UserAccount> list = userAccountService.queryUserAccountList(queryBean);
            if (!CollectionUtils.isEmpty(list)) {
                userAccount = list.get(0);
            }

            if (null == userAccount) {
                logger.warn("modifyPassword 用户账号不存在， usernasme=" + requestDto.getUsername());
                return WrapMapper.wrap(PasswordModifyResponse.ACCOUNT_ERROR_CODE,
                        PasswordModifyResponse.ACCOUNT_ERROR_MESSAGE);
            } else if (!MD5Util.md5Hex(requestDto.getOldPassword()).equals(userAccount.getPassword())) {
                logger.warn("modifyPassword 原始密码错误， usernasme=" + requestDto.getUsername());
                return WrapMapper.wrap(PasswordModifyResponse.MODIFY_FAIL_CODE,
                        PasswordModifyResponse.MODIFY_FAIL_MESSAGE);
            }

            UserAccount account = new UserAccount();
            account.setId(userAccount.getId());
            account.setPassword(MD5Util.md5Hex(requestDto.getNewPassword()));
            account.setUpdateUser(requestDto.getUsername());
            if (userAccountService.update(account)) {
                logger.info("用户修改密码成功， username=" + requestDto.getUsername());
                return WrapMapper.ok();
            } else {
                logger.warn("用户修改密码失败， username=" + requestDto.getUsername());
                return WrapMapper.error();
            }
        } catch (Exception e) {
            logger.error("修改登录密码异常， username=" + requestDto.getUsername(),e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户重置密码
     * 
     * @param request
     * @return
     */
    @POST
    @Path("/userAccount/resetPassword")
    public Wrapper<?> resetPassword(PasswordModifyRequest request) {
        if (null == request || !request.checkSign()) {
            this.logger.error("resetPassword 拒绝访问");
            return WrapMapper.forbidden();
        }

        PasswordModifyRequestDto requestDto = request.getContent();
        if (null == requestDto || StringUtils.isBlank(requestDto.getUsername())
                || StringUtils.isBlank(requestDto.getOldPassword()) || StringUtils.isBlank(requestDto.getNewPassword())
                || StringUtils.isBlank(requestDto.getMobile())) {
            this.logger.error("resetPassword 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserAccountQuery queryBean = new UserAccountQuery();
            queryBean.setUsername(requestDto.getUsername());

            UserAccount userAccount = null;
            List<UserAccount> list = userAccountService.queryUserAccountList(queryBean);
            if (!CollectionUtils.isEmpty(list)) {
                userAccount = list.get(0);
            }

            if (null == userAccount) {
                logger.warn("resetPassword 用户账号不存在， usernasme=" + requestDto.getUsername());
                return WrapMapper.wrap(PasswordModifyResponse.ACCOUNT_ERROR_CODE,
                        PasswordModifyResponse.ACCOUNT_ERROR_MESSAGE);
            }

            UserAccount account = new UserAccount();
            account.setId(userAccount.getId());
            account.setPassword(MD5Util.md5Hex(requestDto.getNewPassword()));
            account.setUpdateUser(requestDto.getUsername());
            if (userAccountService.update(account)) {
                logger.info("用户重置密码成功， username=" + requestDto.getUsername());
                return WrapMapper.ok();
            } else {
                logger.warn("用户重置密码失败， username=" + requestDto.getUsername());
                return WrapMapper.error();
            }
        } catch (Exception e) {
            logger.error("用户重置密码异常， username=" + requestDto.getUsername(),e);
            return WrapMapper.error();
        }
    }

    // 数据转换
    private UserAccountResponseDto convert(UserAccount userAccount) {
        if (null == userAccount) {
            return null;
        }

        UserAccountResponseDto userAccountResponseDto = new UserAccountResponseDto();
        BeanUtils.copyProperties(userAccount, userAccountResponseDto);
        return userAccountResponseDto;
    }

}
