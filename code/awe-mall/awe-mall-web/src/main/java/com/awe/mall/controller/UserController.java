package com.awe.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.UserAccountService;
import com.awe.mall.utils.CodeUtil;
import com.awe.uc.sdk.request.dto.PasswordModifyRequestDto;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.LoginUserUtils;

/**
 * 用户控制器：注册、登录、退出等
 * 
 * @author ljz
 * @version 2014-12-30 上午10:23:08
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private static final String VIEW_INDEX = "/index";
    private static final String VIEW_LOGIN = "user/login";
    private static final String VIEW_LOGIN_SUCCESS = "user/loginSuccess";
    private static final String VIEW_REGISTER = "user/register";
    private static final String VIEW_REGISTER_SUCCESS = "user/registerSuccess";
    private static final String KEY_MESSAGE = "tips_msg";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String MSG_VALUE_LOGIN_ERROR = "用户名或密码错误";
    private static final String MSG_VALUE_REGISTER_ERROR = "注册失败，未知错误";
    private static final String MSG_VALUE_ILLEGAL = "用户名或密码不能空";
    private static final String MSG_CHECK_CODE_ERROR = "验证码输入错误";
    private static final String REDIRECT = "redirect:";
    private static final String FORWARD_URL = "forwardUrl";

    @Autowired
    private UserAccountService userAccountService;

    private final Log logger = LogFactory.getLog(this.getClass());

    /**
     * 进入登录页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, String forwardUrl) {
        logger.debug("go to login page");
        model.addAttribute("navFlag", "login"); // 页面主要导航标识，无标识
        model.addAttribute(FORWARD_URL, forwardUrl);
        return VIEW_LOGIN;
    }

    /**
     * 登录事件
     * 
     * @param model
     * @param username
     *            账号
     * @param password
     *            密码
     * @param checkCode
     *            验证码
     * @param forwardUrl
     *            跳转url
     * @param response
     * @return
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String doLogin(Model model, String username, String password, String checkCode, String forwardUrl,
            HttpServletRequest request, HttpServletResponse response) {
        String view = VIEW_LOGIN;
        String message = null;
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            message = MSG_VALUE_ILLEGAL;
        } else if (!validateCheckCode(checkCode, request)) {
            message = MSG_CHECK_CODE_ERROR;
        } else {
            this.logger.info("doLogin: username=" + username);

            try {
                UserAccountResponseDto responseDto = userAccountService.login(username, password);
                if (responseDto == null) {
                    message = MSG_VALUE_LOGIN_ERROR;
                } else {
                    view = VIEW_LOGIN_SUCCESS;

                    setCookie(response, responseDto);

                    if (StringUtils.isBlank(forwardUrl)) {
                        forwardUrl = VIEW_INDEX;
                    }
                    model.addAttribute(FORWARD_URL, forwardUrl);
                }
            } catch (Exception e) {
                logger.error("用户[" + username + "]登录验证出现异常，", e);
                message = MSG_VALUE_LOGIN_ERROR;
            }
        }

        if (view.equals(VIEW_LOGIN)) {
            model.addAttribute(KEY_USERNAME, username);
            model.addAttribute(KEY_PASSWORD, password);
            model.addAttribute(KEY_MESSAGE, message);
        }
        return view;
    }

    /**
     * setCookie
     * 
     * @param response
     * @param loginUser
     */
    private void setCookie(HttpServletResponse response, UserAccountResponseDto responseDto) {
        if (null == responseDto) {
            return;
        }

        LoginUser user = new LoginUser();
        user.setUserId(responseDto.getId());
        user.setUserName(responseDto.getUsername());
        LoginUserUtils.setUserCookieName("_m_u_c_");
        LoginUserUtils.setCookie(response, user);
    }

    /**
     * 进入注册页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.debug("go to register page");
        model.addAttribute("navFlag", "register"); // 导航标识，无标识
        return VIEW_REGISTER;
    }

    /**
     * 注册事件
     * 
     * @param model
     * @param username
     *            账号
     * @param password
     *            密码
     * @param checkCode
     *            验证码
     * @return
     */
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public String doRegister(Model model, HttpServletRequest request, String username, String password, String checkCode) {
        String view = VIEW_REGISTER;
        String message = null;

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            message = MSG_VALUE_ILLEGAL;
        } else if (!validateCheckCode(checkCode, request)) {
            message = MSG_CHECK_CODE_ERROR;
        } else {
            this.logger.info("doRegister: username=" + username);

            try {
                Wrapper<?> wrapper = userAccountService.register(username, password);
                if (null != wrapper && wrapper.isSuccess()) {
                    return VIEW_REGISTER_SUCCESS;
                } else if (null != wrapper) {
                    message = wrapper.getMessage();
                } else {
                    message = MSG_VALUE_REGISTER_ERROR;
                }
            } catch (Exception e) {
                logger.error("用户[" + username + "]注册出现异常，", e);
                message = MSG_VALUE_REGISTER_ERROR;
            }
        }

        if (view.equals(VIEW_REGISTER)) {
            model.addAttribute(KEY_USERNAME, username);
            model.addAttribute(KEY_PASSWORD, password);
            model.addAttribute(KEY_MESSAGE, message);
        }
        return view;
    }

    /**
     * 退出事件
     * 
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("quit")
    public String quit(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 用户登出
        LoginUserUtils.invalidateCookie(response);
        return REDIRECT + VIEW_INDEX;
    }

    /**
     * 进入用户修改密码页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "modifyPassword", method = RequestMethod.GET)
    public String modifyPassword(Model model) {
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
        model.addAttribute("leftFlag", "modifyPassword");// 我的订单-左边菜单标志
        return "user/modifyPassword";
    }

    /**
     * 用户修改密码事件
     * 
     * @param model
     * @param request
     * @param username
     *            账号
     * @param oldPassword
     *            原始密码
     * @param newPassword
     *            新密码
     * @param smsCode
     *            短信验证码
     * @param checkCode
     *            随机图片验证码
     * @return
     */
    @RequestMapping("doModifyPassword")
    @ResponseBody
    public Wrapper<?> doModifyPassword(Model model, HttpServletRequest request, String username, String oldPassword,
            String newPassword, String smsCode, String checkCode) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)
                || StringUtils.isBlank(smsCode) || StringUtils.isBlank(checkCode)) {
            return WrapMapper.error().message(MSG_VALUE_ILLEGAL);
        } else if (!validateCheckCode(checkCode, request) || !validateSmsCode(smsCode, request)) {
            return WrapMapper.error().message(MSG_CHECK_CODE_ERROR);
        }

        this.logger.info("modifyPassword: username=" + username);
        try {
            PasswordModifyRequestDto requestDto = new PasswordModifyRequestDto();
            requestDto.setUsername(username);
            requestDto.setOldPassword(oldPassword);
            requestDto.setNewPassword(newPassword);
            requestDto.setMobile(username);
            Wrapper<?> wrapper = userAccountService.modifyPassword(requestDto);
            if (null != wrapper) {
                return wrapper;
            } else {
                logger.error("modifyPassword fail.");
                return WrapMapper.error();
            }
        } catch (Exception e) {
            logger.error("modifyPassword has error,", e);
            return WrapMapper.error();
        }

    }

    /**
     * 进入用户重置密码页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "resetPassword", method = RequestMethod.GET)
    public String resetPassword(Model model) {
        return "user/resetPassword";
    }

    /**
     * 用户重置密码事件
     * 
     * @param model
     * @param request
     * @param username
     *            账号
     * @param newPassword
     *            新密码
     * @param smsCode
     *            短信验证码
     * @param checkCode
     *            随机图片验证码
     * @return
     */
    @RequestMapping("doResetPassword")
    @ResponseBody
    public Wrapper<?> doResetPassword(Model model, HttpServletRequest request, String username, String newPassword,
            String smsCode, String checkCode) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(newPassword) || StringUtils.isBlank(smsCode)
                || StringUtils.isBlank(checkCode)) {
            return WrapMapper.error().message(MSG_VALUE_ILLEGAL);
        } else if (!validateCheckCode(checkCode, request) || !validateSmsCode(smsCode, request)) {
            return WrapMapper.error().message(MSG_CHECK_CODE_ERROR);
        }

        this.logger.info("resetPassword: username=" + username);
        try {
            PasswordModifyRequestDto requestDto = new PasswordModifyRequestDto();
            requestDto.setUsername(username);
            requestDto.setNewPassword(newPassword);
            requestDto.setMobile(username);
            Wrapper<?> wrapper = userAccountService.resetPassword(requestDto);
            if (null != wrapper) {
                return wrapper;
            } else {
                logger.error("resetPassword fail.");
                return WrapMapper.error();
            }
        } catch (Exception e) {
            logger.error("resetPassword has error,", e);
            return WrapMapper.error();
        }
    }

    /**
     * 校验用户输入的随机图片验证码
     * 
     * @param checkCode
     * @param request
     * @return
     */
    boolean validateCheckCode(String checkCode, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }

        String code = (String) session.getAttribute(CodeUtil.KEY_CHECK_CODE);
        session.removeAttribute(CodeUtil.KEY_CHECK_CODE);      
        logger.info(checkCode);
        logger.info(code);

        return StringUtils.isNotBlank(checkCode) && checkCode.toUpperCase().equals(code);
    }

    /**
     * 校验用户输入的短信验证码
     * 
     * @param checkCode
     * @param request
     * @return
     */
    boolean validateSmsCode(String checkCode, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        String code = (String) session.getAttribute(CodeUtil.KEY_SMS_CODE);
        session.removeAttribute(CodeUtil.KEY_SMS_CODE);
        logger.info(checkCode);
        logger.info(code);
        return StringUtils.isNotBlank(checkCode) && checkCode.toUpperCase().equals(code);
    }

}
