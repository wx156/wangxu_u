package com.kfm.shop.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.shop.system.domain.User;
import com.kfm.shop.system.mapper.UserMapper;
import com.kfm.shop.system.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author wangxu
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 23:36:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




