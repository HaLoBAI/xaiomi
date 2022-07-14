package com.mashang.xiaomi.pojo.normal;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Basepojo implements Serializable {

    /*创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /*创建时间*/
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /*更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /*更新时间*/
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /*备注*/
    @ApiModelProperty(value = "备注")
    private String remark;

}
