package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.domain.Role;
import com.kfm.shop.system.domain.UserRole;
import com.kfm.shop.system.service.UserRoleService;
import com.kfm.shop.system.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wangxu
* @description 针对表【sys_user_role】的数据库操作Service实现
* @createDate 2023-12-21 16:08:34
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

    @Override
    public List<Role> selectRoleByUserId(Integer id) {
        return baseMapper.selectRoleByUserId(id);
    }
}




