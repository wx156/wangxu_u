package com.kfm.vue01.controller;

import com.kfm.vue01.util.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public Resp login(String username, String password) {
        if (username.equals("admin") && password.equals("123456")) {
            return Resp.ok();
        } else {
            return Resp.error("用户名或密码错误");
        }
    }
}
