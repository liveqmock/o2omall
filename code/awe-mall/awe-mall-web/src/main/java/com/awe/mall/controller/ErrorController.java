package com.awe.mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误统一处理的 Controller
 * 
 * @author ljz
 */
@Controller
@RequestMapping("error")
public class ErrorController {

    private static final String ERROR_PAGE = "error/index";
    private static final String ERROR_UNCAUGHT_PAGE = "error/uncaught";
    private static final String ERROR_NOPERMISSION_PAGE = "error/noPermission";
    private static final String ERROR_CODE_KEY = "errorCode";
    private static final String ERROR_MSG_KEY = "errorMsg";
    private static final String ERROR_MSG_DEFAULT = "未知的其他错误";

    private static final Integer ERROR_400 = 400;
    private static final Integer ERROR_401 = 401;
    private static final Integer ERROR_403 = 403;
    private static final Integer ERROR_404 = 404;
    private static final Integer ERROR_405 = 405;
    private static final Integer ERROR_500 = 500;
    private static final Map<Integer, String> ERROR_MAP = new HashMap<Integer, String>();

    static {
        ERROR_MAP.put(ERROR_400, "请求出现语法错误");
        ERROR_MAP.put(ERROR_401, "客户试图未经授权访问受密码保护的页面");
        ERROR_MAP.put(ERROR_403, "资源不可用");
        ERROR_MAP.put(ERROR_404, "无法找到指定位置的资源");
        ERROR_MAP.put(ERROR_405, "请求方法（GET、POST、PUT等）对指定的资源不适用");
        ERROR_MAP.put(ERROR_500, "服务器内部出错");
    }

    private final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "")
    public String index(Integer code, Model model) {
        logger.warn("访问出错，code = " + code);

        model.addAttribute(ERROR_CODE_KEY, code);
        if (ERROR_MAP.containsKey(code)) {
            model.addAttribute(ERROR_MSG_KEY, ERROR_MAP.get(code));
        } else {
            model.addAttribute(ERROR_MSG_KEY, ERROR_MSG_DEFAULT);
        }

        return ERROR_PAGE;
    }

    @RequestMapping(value = "uncaught")
    public String uncaught(Model model) {
        logger.warn("访问出错，uncaught error ");
        return ERROR_UNCAUGHT_PAGE;
    }

    @RequestMapping(value = "noPermission")
    public String noPermission(String user, String resource, Model model) {
        logger.warn("noPermission, user =" + user);
        logger.warn("noPermission, resource =" + resource);

        model.addAttribute("user", user);
        model.addAttribute("resource", resource);
        return ERROR_NOPERMISSION_PAGE;
    }
}
