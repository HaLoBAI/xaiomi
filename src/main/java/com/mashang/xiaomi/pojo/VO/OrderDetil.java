package com.mashang.xiaomi.pojo.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "订单商品")
public class OrderDetil {
    @ApiModelProperty(value = "订单详情id")
    private Long orderDtlId;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品名")
    private String productName;
    @ApiModelProperty(value = "商品图片")
    private String productPicture;
    @ApiModelProperty(value = "商品售价")
    private BigDecimal productSellingPrice;
    @ApiModelProperty(value = "数量")
    private Long num;
}
