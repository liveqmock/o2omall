package com.hbird.portal.domain.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源级别
 * 
 * @author ljz
 * @version 2014-12-10 上午10:40:59
 */
public class ResourceLevels {

    private static Map<Integer, String> levelMap;

    static {
        levelMap = new HashMap<Integer, String>(3);
        levelMap.put(1, "一级菜单(虚拟)");
        levelMap.put(2, "二级菜单");
        levelMap.put(3, "三级菜单(按钮)");
    }

    /**
     * 资源图标 ace
     * 
     * @return
     */
    public static Map<Integer, String> getLevels() {
        return levelMap;
    }

}
