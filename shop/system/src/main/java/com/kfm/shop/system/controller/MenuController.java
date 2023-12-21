package com.kfm.shop.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.common.util.Result;
import com.kfm.shop.system.domain.Menu;
import com.kfm.shop.system.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单接口",value = "菜单接口",description = "菜单接口")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    @ApiOperation(value = "获取所有菜单信息", notes = "获取所有菜单信息")
    public Result getMenu(@ApiParam(name = "menu", value = "菜单信息") Menu menu) {
//        throw new RuntimeException("模拟异常");
        return Result.ok(menuService.treeList(menu));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取菜单信息", notes = "根据id获取菜单信息")
    public Result getMenuById(@ApiParam(name = "id", value = "菜单id", required = true) @PathVariable Integer id) {
        return Result.ok(menuService.getById(id));
    }


    @PostMapping("/edit")
    @ApiOperation(value = "根据id修改菜单信息", notes = "根据id修改菜单信息")
    public Result updateMenuById(@ApiParam(name = "menu", value = "菜单信息", required = true) Menu menu) {
        return Result.ok(menuService.updateById(menu));
    }


    @PutMapping("/add")
    @ApiOperation(value = "新增菜单信息", notes = "新增菜单信息")
    public Result addMenu(@ApiParam(name = "menu", value = "菜单信息", required = true) Menu menu) {
        return Result.ok(menuService.save(menu));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除菜单信息", notes = "根据id删除菜单信息")
    public Result deleteMenuById(@ApiParam(name = "id", value = "菜单id", required = true) @PathVariable Integer id) {
        return Result.ok(menuService.removeById(id));
    }
}
