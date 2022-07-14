package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "collect")
public class Collect {
    @TableId(type = IdType.AUTO,value = "collect_id")
    private Long collectId;
    private Long userId;
    private Long productId;
}
