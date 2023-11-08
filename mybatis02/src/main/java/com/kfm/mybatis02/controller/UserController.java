package com.kfm.mybatis02.controller;

import com.github.pagehelper.PageInfo;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.impl.UserServiceImpl;
import com.kfm.mybatis02.util.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserServiceImpl userServiceImpl;
    @GetMapping("/list")
    public ModelAndView list(UserModel userModel) throws ServiceException {
        return new ModelAndView("user/list");
    }
    @GetMapping("/page")
    public PageInfo list(@RequestParam(value = "page",defaultValue = "1") int page
            , @RequestParam(value = "limit",defaultValue = "2") int pageSize, UserModel userModel) throws ServiceException {
        return new PageInfo<>(userServiceImpl.findAll(page,pageSize,userModel));
    }
    @GetMapping("/edit")
    public ModelAndView add(@RequestParam(required = false) String id) throws ServiceException {
        ModelAndView modelAndView = new ModelAndView("user/edit");
        if (id != null) {
            // 修改
            modelAndView.addObject("user", userServiceImpl.findById(id));
        } else {
            modelAndView.addObject("user", new UserModel());
        }
        return modelAndView;
    }
    @PostMapping("/edit")
    public Resp edit(UserModel user){
        try {
            userServiceImpl.update(user);
            return Resp.ok();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error("更新失败，请重试");
        }
    }
    @GetMapping("/delete")
    public Resp delete(@RequestParam("id") String id){
        try {
            userServiceImpl.deleteById(id);
            return Resp.ok();
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error("删除失败，请重试");
        }
    }
}
