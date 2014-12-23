package com.hbird.common.utils.file;

import java.io.IOException;
import java.net.URLEncoder;

import com.hbird.common.utils.encode.Encodes;

/**
 * 文件助手类
 * 
 * @author ljz
 * @version 2014-8-18 下午8:41:47
 */
public class FileUtils {

    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     * 
     * @param filename
     *            下载文件名
     * @param agent
     *            客户端浏览器
     * @return 编码后的下载附件名
     * @throws IOException
     */
    public static String encodeFilename(String filename, String agent) throws IOException {
        if (agent.contains("Firefox")) { // 火狐浏览器
            filename = "=?UTF-8?B?" + Encodes.encodeBase64(filename.getBytes("utf-8")) + "?=";
            filename = filename.replaceAll("\r\n", "");
        } else { // IE及其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        }
        return filename;
    }
}
