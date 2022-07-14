package com.mashang.xiaomi.pojo.DTO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mashang.xiaomi.pojo.normal.Basepojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户")
public class UserDTO{
    /*账号*/
    @ApiModelProperty(value = "账号",required = true)
    @NotNull
    private String username;

    /*密码*/
    @NotNull
    @ApiModelProperty(value = "密码",required = true)
    private String password;



}
