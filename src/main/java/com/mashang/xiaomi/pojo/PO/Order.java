package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mashang.xiaomi.pojo.normal.Basepojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "orders")
@ToString(callSuper = true)
public class Order extends Basepojo {
    @ApiModelProperty(value = "订单id")
    @TableId(type = IdType.AUTO,value = "order_id")
    private Long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "订单时间")
    private Date orderTime;
}
