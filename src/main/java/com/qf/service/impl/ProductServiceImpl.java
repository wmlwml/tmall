package com.qf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qf.mapper.CategoryMapper;
import com.qf.mapper.ProductMapper;
import com.qf.pojo.Category;
import com.qf.pojo.Product;
import com.qf.service.ProductService;
import com.qf.vo.VProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/14/20:17
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Map<String, Object> findAll(Integer page, Integer limit, String searchInfo) {
        //设置页码
        PageHelper.startPage(page, limit);
        List<VProduct> list = productMapper.findAll(searchInfo);

        //获取总记录数
        long total = ((Page) list).getTotal();
        HashMap<String, Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    @Override
    public List<VProduct> findProductBySearch(String searchInfo) {
        List<VProduct> list = productMapper.findAll(searchInfo);

        return list;
    }

    //查询全部  前台
    @Override
    public List<VProduct> findAllFront() {
        List<VProduct> all = productMapper.findAll(null);

        return all;
    }

    @Override
    public void addProduct(Product product) {

    }

    //插入数据
    @Override
    public int insertSelective(Product record) {
        int flag = productMapper.insertSelective(record);
        return flag;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public VProduct videoAndSpeaker(Integer id) {
        return null;
    }

    //修改数据
    @Override
    public int updateById(Product product) {
        int i = productMapper.updateByPrimaryKeySelective(product);
        return i;


    }

    @Override
    public void deleteById(Integer id) {
        productMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void deleteVideoByIds(String[] arr) {

    }


    //加载分类
    @Override
    public List<Category> findAllCategory() {
        List<Category> list = categoryMapper.findAll(null);
        return list;
    }
}
