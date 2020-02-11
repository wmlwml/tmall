package com.qf.mapper;

import com.qf.pojo.User;

import java.util.List;

public interface UserMapper {

    //删除单条数据
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    //插入数据
    int insertSelective(User record);

    //根据id查询数据
    User selectByPrimaryKey(Integer id);

    //更新用户数据
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //根据用户名查询用户
    User findByName(String name);

    //查询所有
    List<User> findAll();

}