package com.mashang.xiaomi.sercurity.impl;

import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.sercurity.LoginServcie;
import com.mashang.xiaomi.utills.JwtUtil;
import com.mashang.xiaomi.utills.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {
    //自己写的实现authenticationManager接管springsecurity的过滤链
    //在security包中的AuthenticationManagerImpl
    @Autowired
    private AuthenticationManagerImpl authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AjaxResult login(UserDTO user) {
        //需要使用authenticationManager调用authenticate来进行处理
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        System.out.println(authenticationToken);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        System.out.println(authenticate);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new AjaxResult(200,"登陆成功",map);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);



    }
}