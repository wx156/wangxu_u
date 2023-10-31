package com.kfm.boot.controller;

import com.kfm.boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    private final UserService userService = new UserService();
    @RequestMapping("/logout")
    public String logout (HttpServletRequest request){
        userService.logout(request);
        return "redirect:/login";
    }
}
