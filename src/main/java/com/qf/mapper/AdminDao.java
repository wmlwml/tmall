package com.qf.mapper;

import com.qf.pojo.Admin;

import java.util.List;

/**
 * @Description: 管理员数据访问接口
 * @Author: leilei
 * @Date: 2020/01/07/16:54
 */
public interface AdminDao {
    //根据用户名查询用户
    Admin findByName(String userName);

    //查询所有
    List<Admin> findAll();

    //添加数据
    void add(Admin admin);

    //删除数据
    void delete(Integer id);

    //根据id查询
    Admin findById(Integer id);

    //修改数据
    void updateById(Admin admin);


}
