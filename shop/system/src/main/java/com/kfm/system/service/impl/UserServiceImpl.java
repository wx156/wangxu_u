package com.kfm.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kfm.system.domain.User;
import com.kfm.system.service.UserService;
import com.kfm.system.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wangxu
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-12-19 23:36:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




