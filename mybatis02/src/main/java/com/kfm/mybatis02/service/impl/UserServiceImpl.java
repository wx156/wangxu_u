package com.kfm.mybatis02.service.impl;

import com.github.pagehelper.PageHelper;
import com.kfm.mybatis02.dao.IUserDao;
import com.kfm.mybatis02.exception.ServiceException;
import com.kfm.mybatis02.model.UserModel;
import com.kfm.mybatis02.service.IUserService;
import com.kfm.mybatis02.util.IdUtil;
import com.kfm.mybatis02.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.UUID;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao; // 用户数据访问接口

    /**
     * 用户登录
     *
     * @param userModel 用户模型
     * @return 用户模型
     * @throws ServiceException service exception
     */
    @Override
    public UserModel login(UserModel userModel) throws ServiceException {

        if (ObjectUtils.isEmpty(userModel) || !StringUtils.hasText(userModel.getUsername()) || !StringUtils.hasText(userModel.getPassword())){
            throw new ServiceException("用户名或密码不能为空");
        }
        userModel.setPassword(MD5Util.encodePassword(userModel.getPassword(), userModel.getUsername())); // 对密码进行加密
        List<UserModel> userModels = userDao.selectByUserModel(userModel); // 根据用户模型查询用户列表
        System.out.println(userModels.size());
        if (userModels.size() == 1) {// 判断查询结果是否符合预期
            UserModel userModel1 = userModels.get(0);
            if (userModel1.getState() == 0){
                throw new ServiceException("该用户已被禁用");
            }else {
                return userModel1; // 返回符合预期的用户模型
            }
        } else {
            return null;
        }
    }

    /**
     * 用户注册
     *
     * @param userModel 用户模型
     * @return 注册结果
     * @throws ServiceException 服务端错误
     */
    @Override
    public Integer register(UserModel userModel) throws ServiceException {
        // 判断数据是否为空
        if (userModel == null) {
            throw new ServiceException("输入的信息有误");
        }

        if (userDao.selectUserByUsername(userModel.getUsername()) != null) { // 判断用户名是否已存在
            throw new ServiceException("用户名已存在");
        }

        userModel.setPassword(MD5Util.encodePassword(userModel.getPassword(), userModel.getUsername())); // 对密码进行加密
        userModel.setId(IdUtil.uuid32());// 生成用户id
        Integer row = userDao.insertUserModel(userModel); // 插入用户模型数据
        return row;
    }

    @Override
    public List<UserModel> findAll(int page, int pageSize, UserModel userModel) {
        PageHelper.startPage(page, pageSize);
        List<UserModel> users = userDao.selectAll(userModel);
        return users;
    }

    @Override
    public UserModel findById(String id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(UserModel user) throws ServiceException {
        if (ObjectUtils.isEmpty(user)){
            throw new ServiceException("用户不能为空");
        }

        int row = 0;
        if (!StringUtils.hasText(user.getId())){
            // 新增
            user.setId(IdUtil.uuid32());
            // 密码加密
            String password = MD5Util.encodePassword(user.getPassword(), user.getUsername());
            user.setPassword(password);

            // 数据库用户名做了唯一约束，所以此处省略验证用户名是否存在
            row = userDao.insertUserModel(user);
        }else {
            row = userDao.updateByPrimaryKeySelective(user);
        }
        if (row != 1){
            throw new ServiceException("更新失败");
        }
    }

    @Override
    public void deleteById(String id) throws ServiceException {
        if (StringUtils.isEmpty(id)){
            throw new ServiceException("用户id不能为空");
        }
        userDao.deleteByPrimaryKey(id);
    }
}
