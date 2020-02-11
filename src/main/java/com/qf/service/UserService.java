package com.qf.service;

import com.qf.pojo.User;

import java.util.Map;

/**
 * @Description: 用户管理业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/13/20:21
 */
public interface UserService {
    //分页查询
    Map<String,Object> userFindList(Integer page, Integer limit);

    //根据用户名查询用户
    User findByName(User user);

    //根据用户名查询用户
    User loginUser(User user);

    //删除用户数据
    void deleteUser(User user);

    //更新用户数据
    int updateUser(User user);

    //插入数据
    int insertUser(User record);
}
