package com.kfm.boot.controller;

import com.kfm.boot.entity.User;
import com.kfm.boot.ex.RegisterException;
import com.kfm.boot.ex.ServiceException;
import com.kfm.boot.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

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


    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(Model model) {
        // templates/user/list.html
        // 查询用户列表
        List<User> list = userService.list();
        // 存到域中
        model.addAttribute("list", list);
        return "user/list";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 查询用户信息
        User byId = userService.getById(id);
        // 存到域中
        model.addAttribute("user", byId);
        return "user/edit";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String edit(User user, RedirectAttributes redirectAttributes) {
        // 修改用户信息
        try {
            userService.update(user);
            return "redirect:/user/list";
        } catch (ServiceException e) {
            // 保存错误信息
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/user/edit?id=" + user.getId();
        }
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        // 删除 id 为 1的用户，/user/delete/1
        // 删除用户信息
        try {
            userService.delete(id);
            return "redirect:/user/list";
        } catch (ServiceException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/user/list";
        }
    }


}
