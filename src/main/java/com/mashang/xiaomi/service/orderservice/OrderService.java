package com.mashang.xiaomi.service.orderservice;

import com.mashang.xiaomi.pojo.VO.OrderVO;

import java.util.List;

public interface OrderService {

     List<OrderVO> findMyOrder(String token) throws Exception;

    Integer putMyOrder(List<Long> shoppingCartIds,String token) throws Exception;
}
