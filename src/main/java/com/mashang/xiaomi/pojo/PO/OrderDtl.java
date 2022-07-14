package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "orders_dtl")
@ApiModel("订单详情")
public class OrderDtl {
    @ApiModelProperty(value = "订单详情id")
    private Long orderDtlId;
    @ApiModelProperty(value = "订单id")
    private Long orderId;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品名")
    private String productName;
    @ApiModelProperty(value = "商品标题")
    private String productTitle;
    @ApiModelProperty(value = "商品介绍")
    private String productIntro;
    @ApiModelProperty(value = "商品图片")
    private String productPicture;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal productPrice;
    @ApiModelProperty(value = "商品售价")
    private BigDecimal productSellingPrice;
    @ApiModelProperty(value = "数量")
     private Long num;
}
