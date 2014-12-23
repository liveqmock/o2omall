package com.hbird.portal.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.User;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.LoginUserUtils;

/**
 * 系统管理控制器
 * 
 * @author ljz
 */
@Controller
@RequestMapping("manager")
public class ManagerController extends BaseController {

    private static final String LOGIN_MSG_KEY = "login_msg";
    private static final String LOGIN_MSG_VALUE_FAIL = "用户名或密码错误";
    private static final String LOGIN_MSG_VALUE_ERROR = "用户名或密码验证失败";
    private static final String VIEW_MANAGER = "manager/index";
    private static final String VIEW_INDEX = "redirect:/index";

    private final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String manager(Model model) {
        return VIEW_MANAGER;
    }

    @RequestMapping(value = "set", method = RequestMethod.POST)
    public String managerSet(User user, Model model, HttpServletResponse response) {
        if (!isValid(user)) {
            model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_FAIL);
            return VIEW_MANAGER;
        }

        try {
            setDefaultCookie(response);
            return VIEW_INDEX;
        } catch (Exception e) {
            logger.error("manager set has error", e);
            model.addAttribute(LOGIN_MSG_KEY, LOGIN_MSG_VALUE_ERROR);
            return VIEW_MANAGER;
        }
    }

    private boolean isValid(User user) {
        return user != null && "portal".equals(user.getName()) && "portal".equals(user.getPassword());
    }

    private void setDefaultCookie(HttpServletResponse response) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1L);
        loginUser.setUserName("system");
        loginUser.setCnName("系统管理员");
        LoginUserUtils.setCookie(response, loginUser);
    }

}
