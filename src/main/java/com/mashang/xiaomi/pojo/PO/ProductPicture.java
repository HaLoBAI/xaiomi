package com.mashang.xiaomi.pojo.PO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPicture {
    @ApiModelProperty(value = "商品图片ID")
    private Long pictureId;
    @ApiModelProperty(value = "商品ID")
    private Long productId;
    @ApiModelProperty(value = "商品图片")
    private String productPicture;
    @ApiModelProperty(value = "图片介绍")
    private String intro;
}
