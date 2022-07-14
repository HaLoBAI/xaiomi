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

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ms_user")
@ToString(callSuper = true)
@ApiModel(value = "用户信息")
public class User extends Basepojo {
    /*用户id*/
    @TableId(type = IdType.AUTO,value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /*账号*/
    @ApiModelProperty(value = "账号")
    private String username;

    /*密码*/
    @ApiModelProperty(value = "密码")
    private String password;



}
