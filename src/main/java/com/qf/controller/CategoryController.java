package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.Category;
import com.qf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description: 分类控制器
 * @Author: leilei
 * @Date: 2020/01/14/9:22
 */
@Controller
@ResponseBody
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("finAll.do")
    public Map<String,Object> videoAll(HttpSession session, Integer page, Integer limit, String searchInfo) {
        Map<String, Object> all = categoryService.findAll(page, limit,searchInfo);
        return all;
    }


    //category/addGoodsType.do
    @RequestMapping("addGoodsType.do")
    public JsonResult addGoodsType(Category category) {
        JsonResult jsonResult = null;
        int flag = categoryService.addCategory(category);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }


    @RequestMapping("changeTypeState.do")
    public JsonResult changeTypeState(Category category){
        JsonResult jsonResult = null;
        int flag = categoryService.updateCategory(category);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }

    @RequestMapping("deleteGoodsType.do")
    public JsonResult deleteGoodsType(Category category){
        JsonResult jsonResult = null;
        int flag = categoryService.deleteCategory(category.getId());
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }

    //批量删除
    @RequestMapping("/batchDelete.do")
    public JsonResult batchDelete(String string){
        JsonResult jsonResult = null;
        String[] array = string.split(",");
        int flag = categoryService.deleteByPrimaryKeys(array);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }
}
