package com.mashang.xiaomi.pojo.PO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "shopping_cart")
@ApiModel("订单详情")
public class ShoppingCart {
    @TableId(type = IdType.AUTO,value = "shopping_cart_id")
    private Long shoppingCartId;
    private Long userId;
    private Long productId;
    private Long num;
}
