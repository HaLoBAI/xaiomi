package com.mashang.xiaomi.sercurity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerImpl implements AuthenticationManager {

    //要自己定义规则必须再有实现AuthenticationProvider接口的类来具体定义账号密码校验规则
    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return myAuthenticationProvider.authenticate(authentication);
    }
}
