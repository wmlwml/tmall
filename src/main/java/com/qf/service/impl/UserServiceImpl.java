package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户管理业务逻辑实现类
 * @Author: leilei
 * @Date: 2020/01/13/20:23
 */
@Service
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> userFindList(Integer page, Integer limit) {
        //设置页码
        PageHelper.startPage(page, limit);
        //调用查询
        List<User> list = userMapper.findAll();

        // 获取总记录数
        long total = ((Page) list).getTotal();
        // 获取总页数
        //int pages = ((Page) list).getPages();
        Map<String, Object> map = new HashMap();
        map.put("code", 0);//结合layui 插件，  值必须是0
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    //查询用户
    @Override
    public User findByName(User user) {
        User onUser = userMapper.findByName(user.getName());
        return onUser;
    }

    //登录
    @Override
    public User loginUser(User user) {
        User onUser = userMapper.findByName(user.getName());
        //调用数据访问层进行数据查询
        //进行逻辑判断
        if (onUser == null) {
            throw new RuntimeException("账户错误");
        }
        if (! onUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return onUser;
    }




    @Override
    public void deleteUser(User user) {

        userMapper.deleteByPrimaryKey(user.getId());
    }

    @Override
    public int updateUser(User user) {
        int flag = userMapper.updateByPrimaryKeySelective((user));
        return flag;
    }

    //插入数据
    @Override
    public int insertUser(User record) {
        int flag = userMapper.insertSelective(record);

        return flag;
    }
}
