package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.common.ex.ServiceException;
import com.kfm.shop.system.domain.Menu;
import com.kfm.shop.system.domain.Role;
import com.kfm.shop.system.domain.User;
import com.kfm.shop.system.domain.UserRole;
import com.kfm.shop.system.mapper.MenuMapper;
import com.kfm.shop.system.mapper.UserMapper;
import com.kfm.shop.system.mapper.UserRoleMapper;
import com.kfm.shop.system.service.UserRoleService;
import com.kfm.shop.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* @author wangxu
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 23:36:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
    @Autowired
    private UserRoleService sysUserRoleService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(User entity) {
        // 保存用户信息, 自增主键会设置到 实体中
        boolean save = super.save(entity);

        Integer[] roleIds = entity.getRoleIds();
        // 没有选择角色
        if (ObjectUtils.isEmpty(roleIds)) {
            return save;
        }
        // 保存用户角色信息
        List<UserRole> UserRoles = new ArrayList<>();
        for (Integer roleId : roleIds) {
            UserRoles.add(new UserRole().setUserId(entity.getId()).setRoleId(roleId));
        }
        // 批量保存用户角色信息
        boolean b = sysUserRoleService.saveBatch(UserRoles);
        return save && b;
    }

    @Override
    public String login(User user) {
        // 校验数据有效性
        if (ObjectUtils.isEmpty(user)){
            throw new ServiceException("用户名或密码不能为空");
        }
        // 根据用户名查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        User user1 = getOne(queryWrapper);
        if (ObjectUtils.isEmpty(user1)) {
            throw new ServiceException("用户名或密码错误");
        }
        String token = new Random().nextLong() + "";
        // 存用户信息
        redisTemplate.opsForValue().set(token, user1);

        // 存用户权限信息
        // 1. 根据用户id查询角色权限
        List<Role> roles = userRoleMapper.selectRoleByUserId(user1.getId());
        // 2. 根据角色信息查询权限信息
        // 获取 roles 的所有 id
        List<Integer> ids = roles.stream().map((role) -> role.getId()).toList();
        if (ObjectUtils.isEmpty(ids)) {
            return token;
        }
        List<Menu> menus = menuMapper.selectMenusWithRoleIds(ids);

        // 3. 将所有权限存到 list 中
        List<String> permissions = new ArrayList<>();
        for(Role role : roles) {
            permissions.add("ROLE_" + role.getRoleCode().toUpperCase());
        }
        for (Menu menu : menus) {
            permissions.add(menu.getPermissionCode());
        }
        // 4. 存到 redis
        redisTemplate.opsForValue().set(token + "_permissions", permissions);
        return token;
    }
}




