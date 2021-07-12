package com.yccztt.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yccztt.domain.user.User;
import com.yccztt.entity.user.UserRes;
import com.yccztt.serivce.user.UserService;
import com.yccztt.utils.MD5Util;
import com.yccztt.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hyz
 * @create 2021-06-15 下午1:26
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户信息
     * @return
     */
    @GetMapping("/queryUser")
    public ResultUtil queryUser() {
        List<User> users = userService.queryUser();
        UserRes userRes = new UserRes();
        BeanUtils.copyProperties(users.get(0),userRes);
        return ResultUtil.success(userRes);
    }

    /**
     * 用户登陆,创建token
     * @param userInfo
     * @return
     */
    @PostMapping("/login")
    public ResultUtil login(@RequestBody String userInfo) {
        JSONObject jsonObject = JSON.parseObject(userInfo);
        String username = jsonObject.get("username").toString();
        String password = jsonObject.get("password").toString();
        User user = userService.login(username, MD5Util.encrypt(password));
        if (user!=null) {
            return ResultUtil.success("登陆成功",user);
        } else {
            return ResultUtil.error("登陆失败");
        }
    }

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @GetMapping("/query/{userId}")
    public ResultUtil queryUserById(@PathVariable("userId") String userId) {
        User user = userService.queryUserById(userId);
        UserRes userRes = new UserRes();
        BeanUtils.copyProperties(user,userRes);
        return ResultUtil.success(userRes);
    }

    /**
     * 未登陆
     * @param msg
     * @return
     */
    @GetMapping("/unLogin")
    public ResultUtil unLogin(String msg){
        return ResultUtil.error(msg);
    }

}
