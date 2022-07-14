package com.mashang.xiaomi.service.productservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mashang.xiaomi.mapper.ProductMapper;
import com.mashang.xiaomi.pojo.DTO.ProductDTO;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.VO.ProductDetil;
import com.mashang.xiaomi.pojo.VO.ProductHotInfo;
import com.mashang.xiaomi.pojo.VO.ProductHotInfoDetil;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.pojo.normal.AjaxResultRow;
import com.mashang.xiaomi.service.productservice.ProductService;
import com.mashang.xiaomi.service.userservice.UserService;
import com.mashang.xiaomi.utills.ExcludeEmptyQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    @Override
    public Page<Product> findProductByDto(Long pageSize,Long pageNum,Long categoryId,Long productId,String productNam) {
        //分页查询 的new Page（）
        Page<Product> productPage = new Page<>(pageNum,pageSize,true);
        ExcludeEmptyQueryWrapper<Product> QueryWrapper = new ExcludeEmptyQueryWrapper<>();
        QueryWrapper.eq("product_id",productId)
                    .eq("category_id",categoryId)
                    .like("product_name",productNam);
        Page<Product> productPage1 = productMapper.selectPage(productPage, QueryWrapper);
        return productPage1;
    }

    @Override
    public Page<ProductHotInfo> findHotProduct() {
        //找出热门商品
        List<ProductHotInfo> hotProduct = productMapper.findHotProduct();
        //分类总数
        Long hotProductCount = productMapper.getHotProductCount();
        Page<ProductHotInfo> productHotInfoPage = new Page<>();
        return productHotInfoPage.setRecords(hotProduct).setTotal(hotProductCount);

    }

    @Override
    public ProductDetil findProductDetilByPid(Long productId,String token) throws Exception {
        //根据token获取用户id
        UserInfo info = userService.getInfo(token);
        Long userId = info.getUserId();

        //查看商品的详情
        ProductDetil byPid = productMapper.findByPid(productId);
        //查看是否收藏
        Long conlltion = productMapper.isConlltion(userId, productId);
        //查询结果不为1 则标记为0
        if (conlltion!=1){
            byPid.setIsCollect(0L);
        }else{
            byPid.setIsCollect(1L);
        }

        return byPid;
    }
}
