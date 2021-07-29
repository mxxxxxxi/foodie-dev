package com.imooc.controller;

import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UsersService;
import com.imooc.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassportController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/userNameIsExist")
    public IMOOCJSONResult userNameIsExist(String username) {
        if(StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        boolean flag = usersService.queryUserNameIsExist(username);
        if(flag) {
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }
        return IMOOCJSONResult.ok();

    }


    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        //  1、判断用户名、密码不能为空
        boolean isExist = usersService.queryUserNameIsExist(username);
        if(isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("用户名、密码不能为空");
        }
        //  2、密码长度大于6
        if(password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能小于6");
        }
        //  3、校验密码及验证密码相同
        if(!StringUtils.equals(password,confirmPwd)) {
            return IMOOCJSONResult.errorMsg("两次密码不相同，请检查！！！");
        }
        usersService.createUser(userBO);
        return IMOOCJSONResult.ok();
    }
}
