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
@ApiModel(value = "购物车查询")
public class ShopingCartVO {
    @ApiModelProperty(value = "数量")
    private Long num;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品名字")
    private String productName;
    @ApiModelProperty(value = "商品封面")
    private String productPicture;
    @ApiModelProperty(value = "商品售价")
    private BigDecimal productSellingPrice;
    @ApiModelProperty(value = "购物车id")
    private Long shoppingCartId;
}
