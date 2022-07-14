package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.PO.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}