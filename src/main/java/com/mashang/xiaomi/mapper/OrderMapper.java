package com.mashang.xiaomi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mashang.xiaomi.pojo.PO.Order;
import com.mashang.xiaomi.pojo.VO.OrderVO;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

    List<OrderVO> findMyOrder(Long userId);
}
