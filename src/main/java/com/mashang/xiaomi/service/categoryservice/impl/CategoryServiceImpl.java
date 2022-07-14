package com.mashang.xiaomi.service.categoryservice.impl;

import com.mashang.xiaomi.mapper.CategoryMapper;
import com.mashang.xiaomi.pojo.VO.Category;
import com.mashang.xiaomi.service.categoryservice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findCategory() {
        return categoryMapper.findCategory();
    }
}
