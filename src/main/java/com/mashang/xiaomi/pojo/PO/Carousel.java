package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mashang.xiaomi.pojo.normal.Basepojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = false)
@TableName(value = "carousel")
public class Carousel extends Basepojo {
    @ApiModelProperty("轮播图ID")
    @TableId(type = IdType.AUTO,value = "carousel_id")
    private Long carouselId;
    @ApiModelProperty("轮播图描述")
    private String describes;
    @ApiModelProperty("轮播图路径")
    private String url;
}
