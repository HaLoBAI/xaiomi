package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.VO.ProductDetil;
import com.mashang.xiaomi.pojo.VO.ProductHotInfo;
import com.mashang.xiaomi.pojo.VO.ProductHotInfoDetil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    //查找热门商品
    List<ProductHotInfo> findHotProduct();

    //查找类别总数
    Long getHotProductCount();

    //查找商品详情
    ProductDetil findByPid(Long productId);

    //查找是否收藏
    Long isConlltion(@Param("userId") Long userId, @Param("productId") Long productId);
}
