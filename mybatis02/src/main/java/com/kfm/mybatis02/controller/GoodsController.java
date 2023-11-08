package com.kfm.mybatis02.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.GoodsModel;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.impl.GoodServiceImpl;
import com.kfm.mybatis02.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodServiceImpl goodService;
    @GetMapping("/upList")
    public ModelAndView list(){
        return new ModelAndView("/goods/upList");
    }
    @GetMapping("/page")
    public PageInfo list(@RequestParam(value = "page",defaultValue = "1") int page
            , @RequestParam(value = "limit",defaultValue = "2") int pageSize) throws ServiceException {
        return new PageInfo<>(goodService.listUpGoods(page,pageSize));
    }
    @GetMapping("/deList")
    public ModelAndView deList(){
        return new ModelAndView("/goods/deList");
    }
    @GetMapping("/dePage")
    public PageInfo deList(@RequestParam(value = "page",defaultValue = "1") int page
            , @RequestParam(value = "limit",defaultValue = "2") int pageSize) throws ServiceException {
        return new PageInfo<>(goodService.listDownGoods(page,pageSize));
    }
}
