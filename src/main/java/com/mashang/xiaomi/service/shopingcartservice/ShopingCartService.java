package com.mashang.xiaomi.service.shopingcartservice;

import com.mashang.xiaomi.pojo.VO.ShopingCartVO;

import java.util.List;

public interface ShopingCartService {

    List<ShopingCartVO> findMyShopCartBytoken(String token) throws Exception;

    Integer putShopingCart(String token, Long productId) throws Exception;

    Long getAllShopingCartCount(String token) throws Exception;

    Integer putShopingCartNum(Long shoppingCartId, Long num);

    Integer deletShopingCart(Long shoppingCartId);
}
