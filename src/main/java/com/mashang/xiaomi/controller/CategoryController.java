package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.VO.Category;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.service.categoryservice.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "商品分类")
@RequestMapping("/xiaomi")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categoy")
    @ApiOperation(value = "查询商品分类列表")
    public AjaxResult<List<Category>> getCategory() {
        List<Category> category = categoryService.findCategory();
        return new AjaxResult<>(200,"查询成功",category);
    }
}
