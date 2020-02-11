package com.qf.service;

import com.qf.pojo.PropertyValue;

import java.util.Map;

/**
 * @Description: 属性值管理业务逻辑接口
 * @Author: leilei
 * @Date: 2020/01/15/14:33
 */
public interface PropertyValueService {
    //查询所有
    Map<String, Object> findByProductId(Integer page, Integer limit,
                                        String searchInfo, Integer productId);

    //插入数据
    int insert(PropertyValue record);

    //删除数据
    int deleteByPrimaryKey(Integer id);

    //更新数据
    int updateByPrimaryKey(PropertyValue record);


}
