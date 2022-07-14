package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.VO.CollectVO;
import com.mashang.xiaomi.pojo.VO.OrderVO;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.service.orderservice.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(tags = "订单")
@RequestMapping("/xiaomi")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    @ApiOperation(value = "查询订单")
    public AjaxResult<List<OrderVO>> getOrders(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        List<OrderVO> myOrder = orderService.findMyOrder(token);
        return new AjaxResult<>(200,"查询成功",myOrder);
    }
    @PostMapping("/orders/{shoppingCartIds}")
    @ApiOperation(value = "新增订单")
    public AjaxResult putOrders(@PathVariable("shoppingCartIds") List<Long> shoppingCartIds,HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Integer i  = orderService.putMyOrder(shoppingCartIds,token);
        return new AjaxResult<>(200,"增加成功");
    }
}
