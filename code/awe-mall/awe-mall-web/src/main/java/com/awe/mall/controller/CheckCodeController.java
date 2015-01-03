package com.awe.mall.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.mall.service.CheckCodeService;

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

    /**
     * 生成校验码图片
     * 
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("/create")
    public void create(HttpSession session, HttpServletResponse response) throws IOException {
        // 禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        // 指定生成的响应是图片
        response.setContentType("image/jpeg");

        // String code = checkCodeService.generateRandomNumberCode();
        String code = checkCodeService.generateRandomMixedCode();
        // 将生成的验证码保存到Session中
        session.setAttribute("checkCode", code);
        ImageIO.write(checkCodeService.getImage(code), "JPEG", response.getOutputStream());
    }

    /**
     * 验证校验码
     * 
     * @param checkcode
     * @param request
     * @return 校验码正确返回true
     */
    @ResponseBody
    @RequestMapping("/validate")
    public boolean validate(String checkcode, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        String code = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if (checkcode != null && checkcode.length() > 0 && checkcode.toUpperCase().equals(code)) {
            return true;
        } else {
            return false;
        }
    }

}
