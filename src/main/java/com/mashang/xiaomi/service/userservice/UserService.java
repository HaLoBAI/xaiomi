package com.mashang.xiaomi.service.userservice;

import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.VO.UserInfo;

public interface UserService {
    Integer register(UserDTO user);

    UserInfo getInfo(String token) throws Exception;
}
