package com.kfm.shop.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.common.util.Result;
import com.kfm.shop.system.domain.User;
import com.kfm.shop.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户接口",value = "用户接口",description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    public Result getUser(@ApiParam(name = "menu", value = "用户信息") User user) {
//        throw new RuntimeException("模拟异常");
        // 构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(user.getName())) {
            queryWrapper.like("name", user.getName());
        }
        if (!ObjectUtils.isEmpty(user.getPhone())){
            queryWrapper.eq("status", user.getPhone());
        }
        // 分页
        PageHelper.startPage(user.getPage(), user.getSize());
        return Result.ok(userService.list(queryWrapper));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id获取用户信息")
    public Result getUserById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(userService.getById(id));
    }


    @PostMapping("/edit")
    @ApiOperation(value = "根据id修改用户信息", notes = "根据id修改用户信息")
    public Result updateUserById(@ApiParam(name = "menu", value = "用户信息", required = true) User user) {
        return Result.ok(userService.updateById(user));
    }


    @PutMapping("/add")
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    public Result addUser(@ApiParam(name = "menu", value = "用户信息", required = true) User user) {
        return Result.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息")
    public Result deleteUserById(@ApiParam(name = "id", value = "用户id", required = true) @PathVariable Integer id) {
        return Result.ok(userService.removeById(id));
    }
}
