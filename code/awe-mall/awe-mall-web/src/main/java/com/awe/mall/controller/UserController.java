package com.awe.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.UserAccountService;
import com.awe.uc.sdk.response.dto.UserAccountResponseDto;
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
    private static final String MSG_KEY = "tips_msg";
    private static final String MSG_VALUE_LOGIN_ERROR = "用户名或密码错误";
    private static final String MSG_VALUE_REGISTER_ERROR = "注册失败，未知错误";
    private static final String MSG_VALUE_ILLEGAL = "用户名或密码不能空";
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
        model.addAttribute("navFlag", "login"); // 导航标识，无标识
        model.addAttribute(FORWARD_URL, forwardUrl);
        return VIEW_LOGIN;
    }

    /**
     * 登录事件
     * 
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String doLogin(Model model, String username, String password, HttpServletResponse response, String forwardUrl) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            // 缺少参数
            model.addAttribute(MSG_KEY, MSG_VALUE_ILLEGAL);
            return VIEW_LOGIN;
        }

        this.logger.info("doLogin: username=" + username);

        try {
            UserAccountResponseDto responseDto = userAccountService.login(username, password);
            if (responseDto != null) {
                setCookie(response, responseDto);
                if (StringUtils.isBlank(forwardUrl)) {
                    forwardUrl = VIEW_INDEX;
                }
                model.addAttribute(FORWARD_URL, forwardUrl);
                return VIEW_LOGIN_SUCCESS;
            } else {
                model.addAttribute(MSG_KEY, MSG_VALUE_LOGIN_ERROR);
                return VIEW_LOGIN;
            }
        } catch (Exception e) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("对用户[" + username + "]进行登录验证未通过,堆栈轨迹如下:", e);
            model.addAttribute(MSG_KEY, MSG_VALUE_LOGIN_ERROR);
            return VIEW_LOGIN;
        }
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
     * @param response
     * @return
     */
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    public String doRegister(Model model, String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            // 缺少参数
            model.addAttribute(MSG_KEY, MSG_VALUE_ILLEGAL);
            return VIEW_REGISTER;
        }

        this.logger.info("doRegister: username=" + username);

        try {
            Wrapper<?> wrapper = userAccountService.register(username, password);
            if (null != wrapper && wrapper.isSuccess()) {
                return VIEW_REGISTER_SUCCESS;
            } else if (null != wrapper) {
                model.addAttribute(MSG_KEY, wrapper.getMessage());
                return VIEW_REGISTER;
            } else {
                model.addAttribute(MSG_KEY, MSG_VALUE_REGISTER_ERROR);
                return VIEW_REGISTER;
            }
        } catch (Exception e) {
            model.addAttribute(MSG_KEY, MSG_VALUE_REGISTER_ERROR);
            return VIEW_REGISTER;
        }
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

}
