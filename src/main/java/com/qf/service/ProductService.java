package com.qf.service;

import com.qf.pojo.Category;
import com.qf.pojo.Product;
import com.qf.vo.VProduct;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/14/20:14
 */
public interface ProductService {
    //查询所有
    Map<String,Object> findAll(Integer page, Integer limit, String searchInfo);

    //前台模糊查询数据
    List<VProduct> findProductBySearch(String searchInfo);

    //查询所有前台
    List<VProduct> findAllFront();


    //插入数据
    void addProduct(Product product);
    //插入数据
    int insertSelective(Product record);

    //根据id进行查询
    Product findById(Integer id);
    VProduct videoAndSpeaker(Integer id);
    //Product selectByPrimaryKey(Integer id);

    //修改数据
    int updateById(Product product);

    //删除单条数据
    void deleteById(Integer id);

    //删除多条数据
    void deleteVideoByIds(String[] arr);

    //加载分类
    List<Category> findAllCategory();

}
