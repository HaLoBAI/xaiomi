package com.mashang.xiaomi.pojo.VO;

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
@ToString(callSuper = true)
@ApiModel(value = "收藏查询")
public class CollectVO {
    @ApiModelProperty(value = "收藏ID")
    private Long collectId;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品名字")
    private String productName;
    @ApiModelProperty(value = "商品介绍")
    private String productIntro;
    @ApiModelProperty(value = "商品封面")
    private String productPicture;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal productPrice;
    @ApiModelProperty(value = "商品售价")
    private BigDecimal productSellingPrice;
    @ApiModelProperty(value = "商品标题")
    private String productTitle;
}
