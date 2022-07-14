package com.mashang.xiaomi.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    /*账号*/
    @ApiModelProperty(value = "账号")
    private String username;
}
