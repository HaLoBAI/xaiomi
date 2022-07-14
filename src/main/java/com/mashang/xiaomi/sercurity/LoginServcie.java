package com.mashang.xiaomi.sercurity;

import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.normal.AjaxResult;

public interface LoginServcie {
    public AjaxResult login(UserDTO user);
}
