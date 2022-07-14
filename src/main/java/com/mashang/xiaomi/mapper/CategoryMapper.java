package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.VO.Category;

import java.util.List;


public interface CategoryMapper extends BaseMapper<Category> {
    List<Category> findCategory();
}
