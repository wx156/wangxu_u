package com.kfm.boot.service;

import com.kfm.boot.dao.UserDao;
import com.kfm.boot.entity.User;
import com.kfm.boot.ex.RegisterException;
import com.kfm.boot.ex.ServiceException;
import com.kfm.boot.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private UserDao userDao = new UserDao();


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 User 对象，登录失败返回 null
     */
    public User login(String username, String password) {
        // 参数校验
        if (!StringUtils.hasText(username)
                || !StringUtils.hasText(password)) {
            return null;
        }

        // 密码加密
        password = MD5Util.encodePassword(password, username);

        try {
            // 查询数据库
            return userDao.selectByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void register(User user, String repass) throws RegisterException {
        // 参数校验
        if (ObjectUtils.isEmpty(user) || !StringUtils.hasText(user.getUsername())
                || !StringUtils.hasText(user.getPassword())
                || !StringUtils.hasText(repass)) {
            throw new RegisterException(0, "参数校验失败");
        }

        // 校验两次密码是否一致
        if (!user.getPassword().equals(repass)) {
            throw new RegisterException(2, "两次密码不一致");
        }

        try {
            // 用户名是否存在
            User user1 = userDao.selectByUsername(user.getUsername());
            if (user1 != null) {
                throw new RegisterException(1, "用户名已存在");
            }
            // 密码加密
            String encodePassword = MD5Util.encodePassword(user.getPassword(), user.getUsername());

            user.setPassword(encodePassword);
            // 插入数据
            int rows = userDao.insert(user);

            if (rows != 1) {
                throw new RegisterException(3, "未知错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RegisterException(3, "数据库异常");
        }
    }


    public List<User> list() {

        try {
            return userDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getById(Integer id) {
        if (id == null) {
            return null;
        }
        try {
            return userDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) throws ServiceException {
        if (user == null || user.getId() == null) {
            throw new ServiceException("修改用户信息：参数校验失败");
        }
        try {
            int rows = userDao.updateById(user);
            if (rows != 1) {
                throw new ServiceException("修改用户信息：数据操作失败");
            }
        } catch (SQLException e) {
            throw new ServiceException("修改用户信息：数据库异常", e);
        }
    }

    public void delete(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException("删除用户信息：参数校验失败");
        }
        try {
            int rows = userDao.deleteById(id);
            if (rows != 1) {
                throw new ServiceException("删除用户信息：数据操作失败");
            }
        } catch (SQLException e) {
            throw new ServiceException("删除用户信息：数据库异常", e);
        }
    }

    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
