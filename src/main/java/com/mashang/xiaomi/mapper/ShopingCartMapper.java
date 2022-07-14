package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.PO.ShoppingCart;
import com.mashang.xiaomi.pojo.VO.ShopingCartVO;

import java.util.List;

public interface ShopingCartMapper extends BaseMapper<ShoppingCart> {

    List<ShopingCartVO> findMyShopCartByUid(Long userId);
    List<Long> findShopCartCount(Long userId);
}
