package com.hbird.common.core.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Encode
 * 
 * @author ljz
 * @version 2014-12-18 下午5:03:48
 */

public class MD5Encode {

    public static String byte2hex(byte[] b) {
        StringBuilder builder = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = java.lang.Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                builder.append("0");
            }
            builder.append(stmp);
        }
        return builder.toString().toUpperCase();
    }

    public static byte[] hex2Byte(String hex) {
        if (hex == null || hex.length() == 0)
            return null;
        byte[] result = new byte[hex.length() / 2];
        for (int index = 0; index < hex.length(); index = index + 2) {
            result[index / 2] = Integer.valueOf(hex.substring(index, index + 2), 16).byteValue();
        }
        return result;

    }

    public static String encode(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            return byte2hex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            // e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // JBOSS管理员账户密码生成
        System.out.println(encode("manager:ManagementRealm:manager0987!@#$"));
    }

}
