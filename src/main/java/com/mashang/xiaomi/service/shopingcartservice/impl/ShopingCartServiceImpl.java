package com.mashang.xiaomi.service.shopingcartservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashang.xiaomi.mapper.OrderDtlMapper;
import com.mashang.xiaomi.mapper.ProductMapper;
import com.mashang.xiaomi.mapper.ShopingCartMapper;
import com.mashang.xiaomi.pojo.PO.OrderDtl;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.PO.ShoppingCart;
import com.mashang.xiaomi.pojo.VO.ShopingCartVO;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.service.shopingcartservice.ShopingCartService;
import com.mashang.xiaomi.service.userservice.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopingCartServiceImpl implements ShopingCartService {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopingCartMapper shopingCartMapper;
    @Autowired
    private OrderDtlMapper orderDtlMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ShopingCartVO> findMyShopCartBytoken(String token) throws Exception {
        UserInfo info = userService.getInfo(token);
        return shopingCartMapper.findMyShopCartByUid(info.getUserId());
    }

    @Override
    public Integer putShopingCart(String token, Long productId) throws Exception {
        UserInfo info = userService.getInfo(token);
        ShoppingCart shoppingCart = new ShoppingCart();
        //先判断这个商品在购物车是否存在
        int insert = 0;
        ShoppingCart shoppingCart1 = shopingCartMapper.selectOne(new QueryWrapper<ShoppingCart>().eq("user_id", info.getUserId()).eq("product_id", productId));
        if (shoppingCart1!=null){
            Long num = shoppingCart1.getNum();
            shoppingCart.setShoppingCartId(shoppingCart1.getShoppingCartId());
            shoppingCart.setNum(num+1);
            insert = shopingCartMapper.updateById(shoppingCart);

        }else {
            shoppingCart.setUserId(info.getUserId());
            shoppingCart.setProductId(productId);
            shoppingCart.setNum(1L);
            insert = shopingCartMapper.insert(shoppingCart);
        }
        return insert;
    }

    @Override
    public Long getAllShopingCartCount(String token) throws Exception {
        UserInfo info = userService.getInfo(token);
        Long bigNum = 0L;
        List<Long> shopCartCount = shopingCartMapper.findShopCartCount(info.getUserId());
        for (Long aLong : shopCartCount) {
            bigNum+=aLong;
        }
        return bigNum;
    }

    @Override
    public Integer putShopingCartNum(Long shoppingCartId, Long num) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingCartId(shoppingCartId);
        shoppingCart.setNum(num);
        int i = shopingCartMapper.updateById(shoppingCart);
        return i;
    }

    @Override
    public Integer deletShopingCart(Long shoppingCartId) {
        int i = shopingCartMapper.deleteById(shoppingCartId);
        return i;
    }
}
