package com.kfm.plus.controller;

import com.kfm.plus.domain.Dept;
import com.kfm.plus.service.impl.DeptServiceImpl;
import com.kfm.plus.util.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    @GetMapping
    public ModelAndView dept(ModelAndView modelAndView) {
        modelAndView.setViewName("dept/index");
        return modelAndView;
    }
    @GetMapping("/list")
    public Resp deptList() {
        List<Dept> deptList = deptService.list();
        return Resp.ok(deptList);
    }
}
