package com.awe.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;
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
    private static final String VIEW_INDEX = "user";

    private final Log logger = LogFactory.getLog(this.getClass());

    /**
     * 进入登录页面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        logger.debug("go to login page");
        model.addAttribute("navFlag", "login"); // 导航标识，无标识
        return VIEW_INDEX + "/login";
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
        return VIEW_INDEX + "/register";
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
        return "redirect:index";
    }

}
