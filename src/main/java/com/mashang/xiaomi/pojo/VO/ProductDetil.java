package com.mashang.xiaomi.pojo.VO;

import com.mashang.xiaomi.pojo.PO.ProductPicture;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetil {
    @ApiModelProperty(value = "类别ID")
    private Long categoryId;
    @ApiModelProperty(value = "分类")
    private String categoryName;
    @ApiModelProperty(value = "是否已经收藏 1是0否")
    private Long isCollect;
    List<ProductPicture> pictures;
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
