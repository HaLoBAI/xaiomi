package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.VO.OrderVO;
import com.mashang.xiaomi.pojo.VO.ShopingCartVO;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.service.shopingcartservice.ShopingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(tags = "购物车")
@RequestMapping("/xiaomi")
public class ShopingCartController {
    @Autowired
    private ShopingCartService shopingCartService;

    @GetMapping("/ShopingCart")
    @ApiOperation(value = "查询当前用户购物车")
    public AjaxResult<List<ShopingCartVO>> getShopingCart(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        List<ShopingCartVO> myShopCartBytoken = shopingCartService.findMyShopCartBytoken(token);
        return new AjaxResult<>(200,"查询成功",myShopCartBytoken);
    }
    @PostMapping("/ShopingCart")
    @ApiOperation(value = "添加购物车商品")
    public AjaxResult putShopingCart(HttpServletRequest request,@ApiParam(value = "productId",required = true) @RequestParam("productId") Long productId) throws Exception{
        String token = request.getHeader("token");
        Integer integer = shopingCartService.putShopingCart(token, productId);
        return new AjaxResult<>(200,"添加成功");
    }
    @PostMapping("/ShopingCart/product/count")
    @ApiOperation(value = "查询当前用户购物车商品数量")
    public AjaxResult getShopingCartCount(HttpServletRequest request) throws Exception{
        String token = request.getHeader("token");
        Long allShopingCartCount = shopingCartService.getAllShopingCartCount(token);
        return new AjaxResult<>(200,"查询成功",allShopingCartCount);
    }
    @PutMapping ("/ShopingCart/product/num")
    @ApiOperation(value = "修改购物车商品数量")
    public AjaxResult putShopingCartNum(HttpServletRequest request,@ApiParam(value = "shoppingCartId",name = "shoppingCartId")@RequestParam("shoppingCartId") Long shoppingCartId,@ApiParam(value = "num",name = "数量") @RequestParam("num") Long num) throws Exception{
        Integer integer = shopingCartService.putShopingCartNum(shoppingCartId, num);
        return new AjaxResult<>(200,"修改成功");
    }
    @DeleteMapping ("/ShopingCart/{shoppingCartId}")
    @ApiOperation(value = "删除购物车商品")
    public AjaxResult deleteShopingCart(@ApiParam(value = "shoppingCartId",name = "shoppingCartId") @PathVariable("shoppingCartId") Long shoppingCartId) throws Exception{
        Integer integer = shopingCartService.deletShopingCart(shoppingCartId);
        return new AjaxResult<>(200,"删除成功");
    }

}
