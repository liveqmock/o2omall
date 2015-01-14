package com.hbird.portal.controller.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.hbird.common.utils.DateHelper;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.UserContext;
import com.hbird.portal.domain.User;

/**
 * 基本控制器：提供通用的方法
 * 
 * @author ljz
 */
public abstract class BaseController extends WrapController {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_FORMAT_START = "yyyy-MM-dd 00:00:00";
    private static final String DATE_TIME_FORMAT_END = "yyyy-MM-dd 23:59:59";

    /**
     * init binder, set datetime format
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 获取登录用户信息
     * 
     * @return 用户信息
     */
    public User getLoginUser() {
        LoginUser loginUser = UserContext.get().getUser();
        User user = null;
        if (loginUser != null) {
            user = new User();
            user.setId(loginUser.getUserId());
            user.setName(loginUser.getUserName());
            user.setCnName(loginUser.getCnName());
        }
        return user;
    }

    /**
     * 获取登录用户名
     * 
     * @return
     */
    public String getLoginUserName() {
        User user = getLoginUser();
        if (null == user) {
            return "";
        }
        return user.getName();
    }

    /**
     * 获取登录用户的中文姓名
     * 
     * @return
     */
    public String getLoginUserCnName() {
        User user = getLoginUser();
        if (null == user) {
            return "";
        }
        return user.getCnName();
    }

    /**
     * 初始化日期时间
     * 
     * @param model
     */
    protected void initDateTimePicker(Model model) {
        Date date = new Date();
        String startTime =DateHelper.format(date, DATE_TIME_FORMAT_START);
        model.addAttribute("startTime", startTime);
        String endTime = DateHelper.format(date, DATE_TIME_FORMAT_END);
        model.addAttribute("endTime", endTime);
    }

}
