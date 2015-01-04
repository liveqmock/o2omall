package com.awe.mall.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.service.CheckCodeService;
import com.awe.mall.service.SmsService;
import com.awe.mall.utils.CodeUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 验证码 控制器
 * 
 * @author ljz
 * @version 2014-12-27 下午6:54:30
 */
@Controller
@RequestMapping("/checkCode")
public class CheckCodeController {

    @Autowired
    private CheckCodeService checkCodeService;
    @Autowired
    private SmsService smsService;

    /**
     * 生成校验码图片
     * 
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("/createImage")
    public void createImage(HttpSession session, HttpServletResponse response) throws IOException {
        // 禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        // 指定生成的响应是图片
        response.setContentType("image/jpeg");

        String code = checkCodeService.generateRandomMixedCode(CodeUtil.PICTURE_CODE_LENGTH);
        // 将生成的验证码保存到Session中
        session.setAttribute(CodeUtil.KEY_CHECK_CODE, code);
        BufferedImage image = checkCodeService.getImage(code, CodeUtil.PICTURE_WIDTH, CodeUtil.PICTURE_HEIGHT);
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    /**
     * 生成短信校验码
     * 
     * @param session
     * @param mobile
     *            手机号
     * @return
     */
    @RequestMapping("/createSms")
    @ResponseBody
    public Wrapper<?> createSms(HttpSession session, String mobile) {

        String code = checkCodeService.generateRandomNumberCode(CodeUtil.SMS_CODE_LENGTH);
        // 将生成的验证码保存到Session中
        session.setAttribute(CodeUtil.KEY_SMS_CODE, code);
        String content = String.format("您申请的手机验证码是：%s，请输入后进行验证，谢谢！", code);
        smsService.send(mobile, content);
        // TODO 发短信到手机
        return WrapMapper.ok();
    }

}
