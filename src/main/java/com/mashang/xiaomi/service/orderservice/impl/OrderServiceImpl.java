package com.mashang.xiaomi.service.orderservice.impl;

import com.mashang.xiaomi.mapper.OrderDtlMapper;
import com.mashang.xiaomi.mapper.OrderMapper;
import com.mashang.xiaomi.mapper.ProductMapper;
import com.mashang.xiaomi.mapper.ShopingCartMapper;
import com.mashang.xiaomi.pojo.PO.Order;
import com.mashang.xiaomi.pojo.PO.OrderDtl;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.PO.ShoppingCart;
import com.mashang.xiaomi.pojo.VO.OrderVO;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.service.orderservice.OrderService;
import com.mashang.xiaomi.service.userservice.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopingCartMapper shopingCartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderDtlMapper orderDtlMapper;
    @Override
    public List<OrderVO> findMyOrder(String token) throws Exception {
        UserInfo info = userService.getInfo(token);
        Long userId = info.getUserId();
        return orderMapper.findMyOrder(userId);
    }

    @Override
    public Integer putMyOrder(List<Long> shoppingCartIds,String token) throws Exception {
        UserInfo info = userService.getInfo(token);
        String username = info.getUsername();
        int flag = 0;
        for (Long shoppingCartId : shoppingCartIds) {
            ShoppingCart shoppingCart = shopingCartMapper.selectById(shoppingCartId);
            Order order = new Order();
            order.setOrderNum(UUID.randomUUID().toString());
            order.setUserId(shoppingCart.getUserId());
            order.setOrderTime(new Date());
            order.setCreateBy(username);
            order.setCreateTime(new Date());
            int insert1 = orderMapper.insert(order);
            Product product = productMapper.selectById(shoppingCart.getProductId());
            OrderDtl orderDtl = new OrderDtl();
            BeanUtils.copyProperties(product,orderDtl);
            orderDtl.setOrderId(order.getOrderId());
            orderDtl.setNum(shoppingCart.getNum());
            System.out.println("asdsa"+order.getOrderId());
            int insert = orderDtlMapper.insert(orderDtl);
            if (insert==1 && insert1==1){
                flag=1;
            }
        }
        return flag;
    }
}
