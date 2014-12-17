package com.hbird.common.web.context;

import org.apache.commons.lang.StringUtils;

/**
 * 检查字符串是否包含字符
 * 
 * @author lz
 * 
 */
public class ExcludeRequstPath {

    /**
     * 判断请求的URL是否包含在排除路径之中
     * 
     * @param excludePaths
     *            排除路径
     * @param requestUrl
     *            请求的URL
     * @return
     */
    public static boolean isExclude(String excludePaths, String requestUrl) {
        if (StringUtils.isBlank(excludePaths) || StringUtils.isBlank(requestUrl)) {
            return false;
        }

        String[] excludeArray = excludePaths.split(",");
        for (String exclude : excludeArray) {
            if (requestUrl.contains(exclude)) {
                return true;
            }
        }

        return false;
    }
}
