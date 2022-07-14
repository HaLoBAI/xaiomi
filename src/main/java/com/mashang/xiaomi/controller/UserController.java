package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.sercurity.LoginServcie;
import com.mashang.xiaomi.service.userservice.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户")
@RequestMapping("/xiaomi")
public class UserController {

    @Autowired
    private LoginServcie loginServcie;
    @Autowired
    private UserService userService;

    //这是使用springsecurity实现的登陆
    @PostMapping("/user/login")
    @ApiResponses({
            @ApiResponse(code = 401, message = "用户名错误"),
            @ApiResponse(code = 401, message = "密码错误")
    })
    @ApiOperation(value = "登陆")
    public AjaxResult login(@RequestBody @ApiParam(value = "登陆", name = "登陆", required = true) UserDTO user) {
        return loginServcie.login(user);
    }

    @PostMapping("/user/register")
    @ApiResponses({
            @ApiResponse(code = 50020, message = "账号已经存在请重新输入"),
            @ApiResponse(code = 500, message = "服务器异常，请重试")
    })
    @ApiOperation(value = "注册", notes = "50020代表账号已经存在")
    public AjaxResult register(@RequestBody @ApiParam(value = "注册", name = "注册", required = true) UserDTO user) {
        Integer register = userService.register(user);
        if (register == 0) {
            return new AjaxResult(50020, "账号已经存在请重新输入");
        } else if (register != 1) {
            return new AjaxResult(500, "服务器异常，请重试");
        } else
            return new AjaxResult(200, "注册成功");
    }


    @GetMapping("/user/info")
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器异常，请重试")
    })
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public AjaxResult info(HttpServletRequest request) throws Exception {
        //获取token
        String token = request.getHeader("token");
        UserInfo userInfo =  userService.getInfo(token);
        return new AjaxResult(0, "",userInfo);
    }

}