package com.mashang.xiaomi.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductHotInfo {
    @ApiModelProperty(value = "分类ID")
     private Long categoryId;
    @ApiModelProperty(value = "分类")
     private String categoryName;
    @ApiModelProperty(value = "分类封面1")
     private String categoryPicture1;
    @ApiModelProperty(value = "分类封面2")
     private String categoryPicture2;
    private List<ProductHotInfoDetil> productHotInfoDetils;


}
