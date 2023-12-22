package com.kfm.shop.system.mapper;

import com.kfm.shop.system.domain.Menu;
import com.kfm.shop.system.domain.Role;
import com.kfm.shop.system.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper UserMapper;
    @Autowired
    private MenuMapper MenuMapper;


    @Test
    void selectUserByIdWithRole() {
        User user = UserMapper.selectUserByIdWithRole(1);
        System.out.println(user);

        List<Role> roles = user.getRoles();
        // 获取 roles 的所有 id
        List<Integer> ids = roles.stream().map((role) -> role.getId()).toList();

        List<Menu> sysMenus = MenuMapper.selectMenusWithRoleIds(ids);
        System.out.println(sysMenus);
    }

}