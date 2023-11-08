package com.kfm.mybatis02.service;

import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

public interface IUserService {
    UserModel login(UserModel userModel) throws SerialException, ServiceException;

    Integer register(UserModel userModel) throws ServiceException;

    List<UserModel> findAll(int page, int pageSize, UserModel userModel) throws ServiceException;
    UserModel findById(String id);


    void update(UserModel user) throws ServiceException;

    void deleteById(String id) throws ServiceException;

}
