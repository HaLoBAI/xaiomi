package com.mashang.xiaomi.exp;

import com.alibaba.fastjson.JSON;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.utills.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        AjaxResult result = new AjaxResult(HttpStatus.UNAUTHORIZED.value(), authException.getLocalizedMessage());
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }

}