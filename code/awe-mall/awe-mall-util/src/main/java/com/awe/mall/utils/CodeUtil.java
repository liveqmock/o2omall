package com.awe.mall.utils;

/**
 * 验证码常量类
 * 
 * @author ljz
 * @version 2015-1-2 下午5:52:46
 */
public interface CodeUtil {

    /** KEY:随机图片验证码 */
    String KEY_CHECK_CODE = "checkCode";
    
    /** KEY:随机短信验证码 */
    String KEY_SMS_CODE = "smsCode";

    /** 校验码图片宽 */
      int PICTURE_WIDTH = 90;
    /** 校验码图片高 */
      int PICTURE_HEIGHT = 36;
    /** 图片校验码长度 */
      int PICTURE_CODE_LENGTH = 4;
      
    /** 短信校验码长度 */
      int SMS_CODE_LENGTH = 6;
}
