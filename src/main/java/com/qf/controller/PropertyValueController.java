package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.PropertyValue;
import com.qf.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description: 属性值控制器
 * @Author: leilei
 * @Date: 2020/01/15/14:43
 */
@Controller
@ResponseBody
@RequestMapping("propertyValue/")
public class PropertyValueController {
    //依赖注入
    @Autowired
    private PropertyValueService propertyValueService;

    /**
     * 功能描述: <综合查询 属性值>
     *
     * @Param: [page, limit, searchInfo, id]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: Soulmate.leilei
     * @Date: 2020-1-15 14:59
     */
    @RequestMapping("findAll.do")
    public Map<String,Object> findAll (Integer page, Integer limit, String searchInfo, Integer id){
        Integer productId = id;

        Map<String, Object> all = propertyValueService.findByProductId(page, limit, searchInfo, productId);
        return all;
    }


    @RequestMapping("/add.do")
    public JsonResult addV(Integer productId, Integer propertyId,String propertyValue) {
        JsonResult jsonResult = null;
        PropertyValue value = new PropertyValue();
        value.setProductId(productId);
        value.setPropertyId(propertyId);
        value.setValue(propertyValue);

        int flag = propertyValueService.insert(value);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }

        return jsonResult;
    }

    @RequestMapping("/deleteById.do")
    public JsonResult deleteById(Integer id){
        propertyValueService.deleteByPrimaryKey(id);
        return new JsonResult(1, null);
    }

    @RequestMapping("/updateById.do")
    public JsonResult updateById(PropertyValue propertyValue) {
        propertyValueService.updateByPrimaryKey(propertyValue);
        return new JsonResult(1, null);

    }



}
