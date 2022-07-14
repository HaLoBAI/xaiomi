package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mashang.xiaomi.pojo.normal.Basepojo;
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
@TableName(value = "product")
@ApiModel(value = "用户信息")
public class Product extends Basepojo {

    /*用户id*/
    @TableId(type = IdType.AUTO,value = "product_id")
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品名")
    private String productName;
    @ApiModelProperty(value = "类别ID")
     private String categoryId;
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
    @ApiModelProperty(value = "商品库存")
    private Long productNum;
    @ApiModelProperty(value = "商品销售量")
    private Long productSales;
}
