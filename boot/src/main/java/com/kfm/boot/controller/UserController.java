package com.kfm.boot.controller;

import com.kfm.boot.entity.User;
import com.kfm.boot.ex.RegisterException;
import com.kfm.boot.ex.ServiceException;
import com.kfm.boot.service.FileService;
import com.kfm.boot.service.UserService;
import com.kfm.boot.util.Constant;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService = new UserService();
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        // templates/user/list.html
        // 查询用户列表
        List<User> list = userService.list();
        // 存到域中
        model.addAttribute("list", list);
        return "user/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 查询用户信息
        User byId = userService.getById(id);
        // 存到域中
        model.addAttribute("user", byId);
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
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
    @GetMapping("/avatar")
    public String avatar(){
        return "user/avatar";
    }
    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public String changeAvatar(MultipartFile img, @SessionAttribute(Constant.LOGIN_USER) User user, RedirectAttributes redirectAttributes) throws ServiceException {
        String path = fileService.save(img, user.getId());

        // 更新用户头像
        user.setAvatar(path);
        // 更新数据库数据
        User u = new User();
        u.setId(user.getId());
        u.setAvatar(path);
        userService.update(u);

        redirectAttributes.addFlashAttribute("message", "头像修改成功");
        return "redirect:/user/avatar";
    }
}
