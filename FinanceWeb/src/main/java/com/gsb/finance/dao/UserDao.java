package com.gsb.finance.dao;

import com.gsb.finance.pojo.UserBean;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/11/14
 * Time: 11:14
 * Description：
 */
public interface UserDao {
    Integer addUser(UserBean userBean);

    Integer updateUser(UserBean userBean);
}
