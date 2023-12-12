package com.kfm.mybatis02.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.GoodsModel;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.impl.GoodServiceImpl;
import com.kfm.mybatis02.util.MD5Util;
import com.kfm.mybatis02.util.Resp;
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
    public ModelAndView list() {
        return new ModelAndView("/goods/upList");
    }

    @GetMapping("/page")
    public PageInfo list(@RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "2") int pageSize , GoodsModel goodsModel) throws ServiceException {
        return new PageInfo<>(goodService.listUpGoods(page, pageSize,goodsModel));
    }

    @GetMapping("/deList")
    public ModelAndView deList() {
        return new ModelAndView("/goods/deList");
    }

    @GetMapping("/dePage")
    public PageInfo deList(@RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "2") int pageSize, GoodsModel goodsModel) throws ServiceException {
        return new PageInfo<>(goodService.listDownGoods(page, pageSize,goodsModel));
    }

    @GetMapping("/delete")
    public Resp delete(@RequestParam("id") int id) {
        try {
            Integer deleteById = goodService.deleteById(id);
            if (deleteById == id) {
                return Resp.ok();
            }
            return Resp.error("删除失败");
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error(e.getMessage());
        }
    }
    @GetMapping("/putAway")
    public Resp putAway(@RequestParam("id") int id) {
        try {
            Integer putAwayById = goodService.putAwayById(id);
            if (putAwayById == id) {
                return Resp.ok();
            }
            return Resp.error("上架失败");
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error(e.getMessage());
        }
    }
    @GetMapping("/undercarriage")
    public Resp down(@RequestParam("id") int id) {
        try {
            Integer downById = goodService.downById(id);
            if (downById == id) {
                return Resp.ok();
            }
            return Resp.error("下架失败");
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error(e.getMessage());
        }
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer id) throws ServiceException {
        ModelAndView modelAndView = new ModelAndView("user/edit");
        if (id != null) {
            // 修改
            GoodsModel byId = goodService.findById(id);
            modelAndView.addObject("good", byId);
        } else {
            modelAndView.addObject("good", new GoodsModel());
        }
        return modelAndView;
    }
    @PostMapping("/edit")
    public Resp edit(@RequestBody GoodsModel goodsModel) {
        try {
            Integer save = goodService.update(goodsModel);
            if (save == 1) {
                return Resp.ok();
            }
            return Resp.error("保存失败");
        } catch (ServiceException e) {
            e.printStackTrace();
            return Resp.error(e.getMessage());
        }
    }
}
