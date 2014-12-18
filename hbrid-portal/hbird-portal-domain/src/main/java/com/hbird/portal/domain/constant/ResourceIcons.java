package com.hbird.portal.domain.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 资源图标
 * 
 * @author ljz
 * @version 2014-12-10 上午10:04:59
 */
public class ResourceIcons {

    private static List<String> iconList;

    private static String[] icons = { "icon-desktop", "icon-laptop", "icon-cog", "icon-pencil", "icon-print",
            "icon-search", "icon-list", "icon-plus", "icon-star", "icon-leaf", "icon-globe", "icon-glass",
            "icon-table", "icon-envelope" };

    static {
        iconList = Arrays.asList(icons);
    }

    /**
     * 资源图标 ace
     * 
     * @return
     */
    public static List<String> getIcons() {
        return iconList;
    }

}
