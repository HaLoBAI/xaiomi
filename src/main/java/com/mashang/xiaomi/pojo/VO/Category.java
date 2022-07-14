package com.mashang.xiaomi.pojo.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品分类信息")
public class Category {
    @ApiModelProperty(value = "类别ID")
    private Long categoryId;
    @ApiModelProperty(value = "分类")
    private String categoryName;

}
