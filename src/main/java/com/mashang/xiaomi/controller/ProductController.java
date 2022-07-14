package com.mashang.xiaomi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mashang.xiaomi.pojo.DTO.ProductDTO;
import com.mashang.xiaomi.pojo.DTO.UserDTO;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.VO.ProductDetil;
import com.mashang.xiaomi.pojo.VO.ProductHotInfo;
import com.mashang.xiaomi.pojo.VO.ProductInfo;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.pojo.normal.AjaxResultRow;
import com.mashang.xiaomi.service.productservice.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "商品")
@RequestMapping("/xiaomi")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器异常")

    })

    @ApiOperation(value = "查询商品列表")
    public AjaxResultRow<ProductInfo> getProduct(@RequestParam @ApiParam(value = "每页多少条", name = "pageSize", required = true) Long pageSize, @ApiParam(value = "当前第几页", name = "pageNum", required = true) @RequestParam Long pageNum, @RequestParam(required = false) @ApiParam(value = "分类ID", name = "categoryId", required = false) Long categoryId, @RequestParam(required = false) @ApiParam(value = "商品ID", name = "productId", required = false) Long productId, @RequestParam(required = false) @ApiParam(value = "商品名称", name = "productName", required = false) String productName) {

        Page<Product> productByDto = productService.findProductByDto(pageSize, pageNum, categoryId, productId, productName);
        List<ProductInfo> pd = new ArrayList<>();
        for (Product record : productByDto.getRecords()) {
            ProductInfo productInfo = new ProductInfo();
            BeanUtils.copyProperties(record, productInfo);
            pd.add(productInfo);
        }
        return new AjaxResultRow(0, "", pd, productByDto.getTotal());
    }

    @GetMapping("/productHot")
    @ApiOperation(value = "首页热门商品列表")
    public AjaxResultRow<List<ProductHotInfo>> getProductHot() {
        Page<ProductHotInfo> hotProduct = productService.findHotProduct();
        return new AjaxResultRow<List<ProductHotInfo>>(0, "", hotProduct.getRecords(), hotProduct.getTotal());
    }

    @GetMapping("/product/{productId}")
    @ApiOperation(value = "查询商品详情")
    public AjaxResult<ProductDetil> getProductDetil(@PathVariable("productId") @ApiParam(value = "productId",name = "productId",required = true) Long productId, HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        ProductDetil productDetilByPid = productService.findProductDetilByPid(productId, token);
        return new AjaxResult<ProductDetil>(0, "", productDetilByPid);
    }
}
