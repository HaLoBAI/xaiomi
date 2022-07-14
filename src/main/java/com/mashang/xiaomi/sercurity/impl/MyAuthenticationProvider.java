package com.mashang.xiaomi.sercurity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
     //自己写实现userDetailsService的类然后从数据库里面查找
    @Autowired
    private UserDetailsService userDetailsService;
    //加密的组件
    @Autowired
    private PasswordEncoder passwordEncorder;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String presentedPassword = (String)authentication.getCredentials();
        // 根据用户名获取用户信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (StringUtils.isEmpty(userDetails.getUsername())) {
            throw new BadCredentialsException("用户名不存在");
        } else {
            boolean matches = passwordEncorder.matches(presentedPassword, userDetails.getPassword());
            if (matches == false) {
                throw new BadCredentialsException("密码错误");
            } else {
                UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());
                result.setDetails(authentication.getDetails());
                return result;
            }
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}