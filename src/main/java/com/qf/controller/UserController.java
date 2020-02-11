package com.qf.controller;

import com.qf.common.JsonResult;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Description: 用户管理控制器
 * @Author: leilei
 * @Date: 2020/01/13/20:28
 */
@Controller
@ResponseBody
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    //查询全部
    @RequestMapping("userList.do")
    public Map<String, Object> userList(Integer page, Integer limit) {
        Map<String, Object> list = userService.userFindList(page, limit);
        return list;
    }


    //单个删除
    @RequestMapping("deleteUser.do")
    public JsonResult deleteUser(User user) {
        userService.deleteUser(user);
        return new JsonResult(1, null);
    }

    //修改状态
    @RequestMapping("changeUserState.do")
    public JsonResult changeUserState(User user){
        JsonResult jsonResult = null;

        int i = userService.updateUser(user);
        if (i > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }

    /**
     * 功能描述: <添加用户>
     *
     * @Param: [user]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-14 15:20
     */
    @RequestMapping("addUser.do")
    public JsonResult addUser(User user) {
        JsonResult jsonResult = null;
        int flag = userService.insertUser(user);
        if (flag > 0) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }

    /**
     * 功能描述: <查询用户>
     *
     * @Param: [user]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-14 15:42
     */
    @RequestMapping("findByUser.do")
    public JsonResult findByUser(User user){
        JsonResult jsonResult = null;
        User flag = userService.findByName(user);

        if (flag != null) {
            jsonResult = new JsonResult(1, null);
        } else {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;

    }




    //前台系统

    /**
     * 功能描述: <前台登录>
     *
     * @Param: [user, session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-2-2 14:25
     */
    @RequestMapping("loginUser.do")
    public JsonResult loginUser(User user, HttpSession session) {
        JsonResult jsonResult = null;
        try {
            User loginUser = userService.loginUser(user);
            session.setAttribute(StrUtils.LOGIN_USER, loginUser);
            //进行json转换
            jsonResult = new JsonResult(1, null);

        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }

    /**
     * 功能描述: <退出登录>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-7 20:08
     */
    @RequestMapping("exitUser.do")
    public JsonResult exitUser(HttpSession session) {

        session.removeAttribute(StrUtils.LOGIN_USER);
         JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;

    }

    /**
     * 功能描述: <当前用户>
     *
     * @Param: [session]
     * @Return: com.qf.common.JsonResult
     * @Author: Soulmate.leilei
     * @Date: 2020-1-11 15:33
     */
    @RequestMapping("activeUser.do")
    public JsonResult activeUser(HttpSession session) {
        JsonResult jsonResult = null;
        try{
            User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
            jsonResult = new JsonResult(1, user.getName());
        } catch (Exception e) {
            jsonResult = new JsonResult(0, null);
        }
        return jsonResult;
    }


    @RequestMapping("modifyPW.do")
    public String modifyPW(String oldPassword, String password, String repassword,HttpSession session) {
        User user = (User)session.getAttribute(StrUtils.LOGIN_USER);
        String presentPassword = user.getPassword();

        if (presentPassword.equals(oldPassword) || password.equals(repassword)) {

            user.setPassword(password);
            userService.updateUser(user);
            session.removeAttribute(StrUtils.LOGIN_USER);

            return "success";
        } else {
            return "fail";
        }
    }



}
