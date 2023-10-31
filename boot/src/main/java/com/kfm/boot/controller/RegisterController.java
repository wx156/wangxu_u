package com.kfm.boot.controller;

import com.kfm.boot.entity.User;
import com.kfm.boot.ex.RegisterException;
import com.kfm.boot.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    private UserService userService = new UserService();
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(HttpServletRequest request) {
        // 逻辑视图名称
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, String captcha, String repassword, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        // 校验验证码
        if (!CaptchaUtil.ver(captcha, request)){
            // 验证码错误
            // 清除验证码
            CaptchaUtil.clear(request);
            // 保存错误信息
            redirectAttributes.addFlashAttribute("message", "验证码错误");
            // 重定向到注册页面
            return "redirect:/register";
        }
        // 清除验证码
        CaptchaUtil.clear(request);


        // 注册
        try {
            userService.register(user, repassword);
        } catch (RegisterException e) {
            e.printStackTrace();
            // 注册失败
            String message = e.getMessage();
            // 由于是重定向，所以这里使用 session 保存错误信息
//            request.getSession().setAttribute("message", message);
            // 使用 RedirectAttributes 保存错误信息， RedirectAttributes 用于重定向间传递数据
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/register";
        }

        redirectAttributes.addFlashAttribute("message", "注册成功");
        // 注册成功
        return "redirect:/login";
    }
}
