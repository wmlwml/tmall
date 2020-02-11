package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.Category;
import com.qf.pojo.Product;
import com.qf.service.ProductService;
import com.qf.vo.VProduct;
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
 * @Date: 2020/01/14/20:22
 */
@Controller
@ResponseBody
@RequestMapping("product/")
public class ProductController {
    @Autowired
    private ProductService productService;


    //查询所有商品
    @RequestMapping("findAll.do")
    public Map<String,Object> findAll(HttpSession session, Integer page, Integer limit, String searchInfo) {
        Map<String, Object> all = productService.findAll(page, limit, searchInfo);
        return all;
    }
    //删除商品
    @RequestMapping("deleteById.do")
    public JsonResult deleteById(Integer id){
        productService.deleteById(id);
        return new JsonResult(1, null);
    }

    //更新单个商品
    @RequestMapping("updateById.do")
    public JsonResult updateById(Product product) {
        JsonResult jsonResult = null;
        int flag = productService.updateById(product);
        if (flag >0) {
            jsonResult = new JsonResult(1, null);
        } else{
            jsonResult = new JsonResult(0, null);

        }
        return jsonResult;

    }

    //查询单个商品
    @RequestMapping("findById.do")
    public JsonResult findById(Integer id) {
        Product product = productService.findById(id);
        return new JsonResult(1, product);
    }

    /**
     * 功能描述: <加载商品归属分类>
     *
     * @Param: []
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-15 9:33
     */
    @RequestMapping("list.do")
    public JsonResult subjectAll(){
        List<Category> list = productService.findAllCategory();
        JsonResult jsonResult = new JsonResult(1, list);

        return jsonResult;
    }

    /**
     * 功能描述: <修改商品状态>
     *
     * @Param: [product]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-15 11:13
     */
    @RequestMapping("changeState.do")
    public JsonResult changeState(Product product) {
        JsonResult jsonResult = null;
        int flag = productService.updateById(product);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }





    /**
     * 功能描述: <前台商品数据>
     *
     * @Param: []
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-15 23:36
     */
    @RequestMapping("findAllFront.do")
    public JsonResult findAllFront(){

        List<VProduct> allFront = productService.findAllFront();
        JsonResult jsonResult = new JsonResult(1, allFront);
        return jsonResult;
    }

    /**
     * 功能描述: <插入数据>
     *
     * @Param: [product]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-16 9:13
     */
    @RequestMapping("addProduct.do")
    public JsonResult addProduct(Product product) {
        JsonResult jsonResult = null;
        int flag = productService.insertSelective(product);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }

    /**
     * 功能描述: <前台搜索查询商品>
     *
     * @Param: [keyword]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-4 0:35
     */
    @RequestMapping("findProductBySearch.do")
    public JsonResult findProductBySearch(String keyword){
        JsonResult jsonResult = null;
        List<VProduct> productBySearch = productService.findProductBySearch(keyword);
        if (productBySearch.size() > 0) {

            jsonResult = new JsonResult(1, productBySearch);
        } else {
            jsonResult = new JsonResult(0, null);
        }

        return jsonResult;

    }

}
