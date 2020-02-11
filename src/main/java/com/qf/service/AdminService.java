package com.qf.service;

import com.qf.pojo.Admin;

import java.util.Map;

/**
 * @Description: 管理员业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/07/17:01
 */
public interface AdminService {
    /**
     * 功能描述: <登录方法>
     *
     * @Param: [userName, password]
     * @Return: com.qf.entity.Admin
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 17:03
     */
    Admin login(String userName, String password);


    //分页查询
    Map<String,Object> adminList(Integer page, Integer limit);

    //添加数据
    void addAdmin(Admin admin);

    //删除数据
    void delAdmin(Admin admin);


    //根据id查询
    Admin adminById(Integer id);

    //修改数据
    void updateById(Admin admin);

}
