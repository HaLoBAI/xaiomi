package com.mashang.xiaomi.pojo.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "订单查询")
public class OrderVO {
     @ApiModelProperty(value = "订单id")
     private Long orderId;
     @ApiModelProperty(value = "订单号")
     private Long orderNum;
     @ApiModelProperty(value = "订单时间")
     private Date orderTime;
     @ApiModelProperty(value = "订单商品")
     private List<OrderDetil> orderDetils;
}
