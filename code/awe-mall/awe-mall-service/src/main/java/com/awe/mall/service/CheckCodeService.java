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
     * @param codeLength
     *            验证码长度
     * @return
     */
    String generateRandomNumberCode(int codeLength);

    /**
     * 产生随机字母数字混合验证码
     * 
     * @param codeLength
     *            验证码长度
     * @return
     */
    String generateRandomMixedCode(int codeLength);

    /**
     * 取得验证码图片
     * 
     * @param checkCode
     *            验证码
     * @param width
     *            图片宽度
     * @param height
     *            图片 高度
     * @return
     */
    BufferedImage getImage(String checkCode, int width, int height);

}
