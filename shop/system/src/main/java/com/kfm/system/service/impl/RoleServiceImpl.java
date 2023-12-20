package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.domain.Role;
import com.kfm.system.service.RoleService;
import com.kfm.system.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author wangxu
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2023-12-19 23:35:48
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




