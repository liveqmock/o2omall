package com.awe.mall.controller.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.hbird.common.utils.DateHelper;
import com.hbird.common.web.context.LoginUser;
import com.hbird.common.web.context.UserContext;

/**
 * 基本控制器：提供通用的方法
 * 
 * @author lijianzhong
 */
public abstract class BaseController extends WrapController {

    /** KEY:登录用户名 */
    protected static final String KEY_LOGIN_USERNAME = "username";

    protected final Log logger = LogFactory.getLog(this.getClass());

    /**
     * init binder, set datetime format
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat(DateHelper.DATE_TIME_FORMAT);
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 获取登录用户信息
     * 
     * @return 用户信息
     */
    public LoginUser getLoginUser() {
        return UserContext.get().getUser();
    }

    /**
     * 获取登录用户名
     * 
     * @return
     */
    public String getLoginUserName() {
        LoginUser user = getLoginUser();
        if (null == user) {
            return null;
        }
        return user.getUserName();
    }

    /**
     * 获取登录用户的中文姓名
     * 
     * @return
     */
    public String getLoginUserCnName() {
        LoginUser user = getLoginUser();
        if (null == user) {
            return null;
        }
        return user.getCnName();
    }

    /**
     * 获取登录用户ID
     * 
     * @return
     */
    public Long getLoginUserId() {
        LoginUser user = getLoginUser();
        if (null == user) {
            return null;
        }
        return user.getUserId();
    }

    /**
     * 获取登录用户编号
     * 
     * @return
     */
    public String getLoginUserNo() {
        Long userId = getLoginUserId();
        if (null == userId) {
            return null;
        }
        return String.valueOf(userId);
    }
}
