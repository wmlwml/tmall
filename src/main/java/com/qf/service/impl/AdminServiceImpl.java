package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.AdminDao;
import com.qf.pojo.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 管理员管理业务逻辑实现类
 * @Author: leilei
 * @Date: 2020/01/07/17:05
 */
@Service
public class AdminServiceImpl implements AdminService {
    //依赖注入
    @Autowired
    private AdminDao adminDao;

    /**
     * 功能描述: <登录方法>
     *
     * @Param: [userName, password]
     * @Return: com.qf.entity.Admin
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 17:12
     */
    public Admin login(String userName, String password) {
        //调用数据访问层进行数据查询
        Admin admin = adminDao.findByName(userName);
        //进行逻辑判断
        if (admin == null) {
            throw new RuntimeException("账户错误");
        }
        if (! admin.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return admin;
    }



    /**
     * 功能描述: <分页查询全部>
     *
     * @Param: [page, limit]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 14:15
     */
    @Override
    public Map<String, Object> adminList(Integer page, Integer limit) {

        //设置页码
        PageHelper.startPage(page, limit);
        //调研查询
        List<Admin> list = adminDao.findAll();

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

    @Override
    public void addAdmin(Admin admin) {
        adminDao.add(admin);

    }

    //删除数据
    @Override
    public void delAdmin(Admin admin) {
        adminDao.delete(admin.getId());


    }

    //根据id 进行查询数据
    @Override
    public Admin adminById(Integer id) {
        Admin admin = adminDao.findById(id);
        return admin;
    }

    //更新数据
    @Override
    public void updateById(Admin admin) {
        adminDao.updateById(admin);

    }
}
