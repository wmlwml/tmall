package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.Category;
import com.qf.pojo.Property;
import com.qf.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: leilei
 * @Date: 2020/01/15/1:20
 */
@Controller
@RequestMapping("property/")
@ResponseBody
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @RequestMapping("findByCategory.do")
    public Map<String,Object> findByCategory(HttpSession session, Integer page, Integer limit, String searchInfo, Integer id) {
        Integer categoryId = id;
        Map<String, Object> all = propertyService.findBycategory(page, limit,searchInfo, categoryId);

        return all;
    }


    @RequestMapping("/add.do")
    public JsonResult addV(Integer id,String name) {
        Property property = new Property();
        property.setName(name);
        property.setCategoryId(id);
        propertyService.insert(property);
        return new JsonResult(1, null);
    }

    @RequestMapping("/deleteById.do")
    public JsonResult deleteById(Integer id){
        propertyService.deleteByPrimaryKey(id);
        return new JsonResult(1, null);
    }

    @RequestMapping("/updateById.do")
    public JsonResult updateById(Property property) {
        propertyService.updateByPrimaryKey(property);
        return new JsonResult(1, null);

    }





}
