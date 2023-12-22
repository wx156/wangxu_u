package com.kfm.shop.system.mapper;

import com.kfm.shop.system.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wangxu
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2023-12-19 23:36:21
* @Entity com.kfm.system.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    User selectUserByIdWithRole(Integer i);
}




