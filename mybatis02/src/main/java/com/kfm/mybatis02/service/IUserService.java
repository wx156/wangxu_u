package com.kfm.mybatis02.service;

import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;

import javax.sql.rowset.serial.SerialException;

public interface IUserService {
    UserModel login(UserModel userModel) throws SerialException;

    UserModel register(UserModel userModel) throws ServiceException;
}
