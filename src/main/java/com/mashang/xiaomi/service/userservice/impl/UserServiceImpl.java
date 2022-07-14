package com.mashang.xiaomi.service.userservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mashang.xiaomi.mapper.UserMapper;
import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.PO.User;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.sercurity.impl.LoginUser;
import com.mashang.xiaomi.service.userservice.UserService;
import com.mashang.xiaomi.utills.JwtUtil;
import com.mashang.xiaomi.utills.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    //plus的插入方法
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;
    //引入security的加密工具
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @Override
    public Integer register(UserDTO userdto) {
        //用账号名查询是否有重复的账号
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userdto.getUsername());
        User user1 = userMapper.selectOne(wrapper);
        if (user1!=null){
            return 0;
        }
        User user = new User();
        user.setUsername(userdto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userdto.getPassword()));
        user.setCreateBy(userdto.getUsername());
        user.setCreateTime(new Date());
        user.setRemark("第一次注册");
        int insert = userMapper.insert(user);
        return insert;
    }
 //redis中根据token解析得到用户id和用户名
    @Override
    public UserInfo getInfo(String token) throws Exception {

        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
             userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadCredentialsException("token非法");
        }
        long l = Long.parseLong(userid);
        String redisKey = "login:" + userid;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        if(Objects.isNull(loginUser)){
            throw new BadCredentialsException("用户未登录");
        }
        return new UserInfo(l,loginUser.getUsername());
    }
}
