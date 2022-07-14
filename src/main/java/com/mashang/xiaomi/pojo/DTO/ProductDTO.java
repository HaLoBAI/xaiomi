package com.mashang.xiaomi.pojo.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "查询商品的参数")
public class ProductDTO {
    /*账号*/
    @ApiModelProperty(value = "每页多少条",required = true)
    @NotNull
    private Long pageSize;
    @ApiModelProperty(value = "当前第几页",required = true)
    @NotNull
    private Long pageNum;
    @ApiModelProperty(value = "分类ID")
    @NotNull
    private Long categoryId;
    @ApiModelProperty(value = "商品ID")
    @NotNull
    private Long productId;
    @ApiModelProperty(value = "商品名称")
    @NotNull
    private String productName;
}
