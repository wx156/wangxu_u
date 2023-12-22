package com.kfm.shop.system.service;

import com.kfm.shop.system.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kfm.shop.system.domain.dto.RoleGrantMenuDTO;

/**
* @author wangxu
* @description 针对表【sys_role】的数据库操作Service
* @createDate 2023-12-19 23:35:48
*/
public interface RoleService extends IService<Role> {
    boolean grant(RoleGrantMenuDTO roleGrantMenuDTO);
}
