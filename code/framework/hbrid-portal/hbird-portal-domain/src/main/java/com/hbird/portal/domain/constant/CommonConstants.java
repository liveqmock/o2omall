package com.hbird.portal.domain.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 * 
 * @author ljz
 * @version 2014-11-27 下午9:54:49
 */
public class CommonConstants {
    /** 菜单 资源 */
    public final static int RESOURCE_MENU = 1;
    /** 按钮 资源 */
    public final static int RESOURCE_BUTTON = 2;
    /** 资源的图标的KEY */
    public static final String RESOURCE_ICONS_KEY = "icons";
    /** 资源的级别的KEY */
    public static final String RESOURCE_LEVELS_KEY = "levels";
    /** 登录用户的KEY */
    public static final String LOGIN_USER_KEY = "user";
    /** 登录用户的菜单的KEY */
    public static final String LOGIN_MENUS_KEY = "menus";

    /**
     * RESTEasy URL
     */
    public final static String REST_URL = "services";

    /**
     * 是否删除，删除，无效
     */
    public final static int Y = 1;
    /**
     * 是否删除，不删除，有效
     */
    public final static int N = 0;

    /**
     * 员工类型-内部员工
     */
    public final static int USER_TYPE_INNER = 1;
    /**
     * 员工类型-外派员工
     */
    public final static int USER_TYPE_OUTER = 2;

    public static Map<Integer, String> getUserType() {
        Map<Integer, String> userTypeMap = new HashMap<Integer, String>();
        userTypeMap.put(USER_TYPE_INNER, "内部");
        userTypeMap.put(USER_TYPE_OUTER, "外派");
        return userTypeMap;
    }

    /**
     * 员工状态-在职
     */
    public final static int USER_STATUS_ON = 1;
    public final static String SYNC_USER_STATUS_ON = "N";
    /**
     * 员工状态-离职
     */
    public final static int USER_STATUS_OFF = 2;
    public final static String SYNC_USER_STATUS_OFF = "T";

    public static Map<Integer, String> getUserStatus() {
        Map<Integer, String> userStatusMap = new HashMap<Integer, String>();
        userStatusMap.put(USER_STATUS_ON, "在职");
        userStatusMap.put(USER_STATUS_OFF, "离职");
        return userStatusMap;
    }
}
