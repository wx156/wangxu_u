package com.kfm.mybatis02.service.impl;

import com.kfm.mybatis02.dao.IUserDao;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.IUserService;
import com.kfm.mybatis02.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public UserModel login(UserModel userModel) throws SerialException {
        if (userModel == null) {
            throw new SerialException("用户名或密码不能为空");
        }
        userModel.setPassword(MD5Util.encodePassword(userModel.getPassword(), userModel.getUsername()));
        List<UserModel> userModels = userDao.selectByUserModel(userModel);
        if (userModels.size() == 1) {
            return userModels.get(0);
        } else {
            return null;
        }
    }

    @Override
    public UserModel register(UserModel userModel) throws ServiceException {
        // 判断数据是否为空
        if (userModel == null) {
            throw new ServiceException("输入的信息有误");
        }
        if (userDao.selectByUserModel(userModel) != null) {
            throw new ServiceException("用户名已存在");
        }
        userModel.setPassword(MD5Util.encodePassword(userModel.getPassword(), userModel.getUsername()));
        userDao.insertUserModel(userModel);
        return userModel;
    }
}
