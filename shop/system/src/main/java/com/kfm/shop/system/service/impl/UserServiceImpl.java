package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.domain.User;
import com.kfm.shop.system.domain.UserRole;
import com.kfm.shop.system.mapper.UserMapper;
import com.kfm.shop.system.service.UserRoleService;
import com.kfm.shop.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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
}




