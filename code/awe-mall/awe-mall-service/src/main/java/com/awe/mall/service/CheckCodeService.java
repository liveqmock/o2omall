package com.awe.mall.service;

import java.awt.image.BufferedImage;

/**
 * 验证码服务
 * 
 * @author ljz
 * @version 2014-12-29 下午1:13:20
 */
public interface CheckCodeService {

    /**
     * 产生随机数字验证码
     * 
     * @return
     */
    String generateRandomNumberCode();

    /**
     * 产生随机字母数字混合验证码
     * 
     * @return
     */
    String generateRandomMixedCode();

    /**
     * 取得验证码图片
     * 
     * @param checkCode
     * @return
     */
    BufferedImage getImage(String checkCode);

}
