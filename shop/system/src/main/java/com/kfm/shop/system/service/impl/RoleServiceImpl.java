package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.domain.Role;
import com.kfm.shop.system.domain.RoleMenu;
import com.kfm.shop.system.domain.dto.RoleGrantMenuDTO;
import com.kfm.shop.system.service.RoleMenuService;
import com.kfm.shop.system.service.RoleService;
import com.kfm.shop.system.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @author wangxu
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2023-12-19 23:35:48
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean grant(RoleGrantMenuDTO roleGrantMenuDTO) {
        // 先将原来的权限删掉，再添加新权限
        roleMenuService.removeById(roleGrantMenuDTO.getRoleId());

        Integer[] menuIds = roleGrantMenuDTO.getMenuIds();
        List<RoleMenu> list = new ArrayList<>();
        for (Integer menuId : menuIds){
            list.add(new RoleMenu(roleGrantMenuDTO.getRoleId(), menuId));
        }

        return roleMenuService.saveBatch(list);
    }
}




