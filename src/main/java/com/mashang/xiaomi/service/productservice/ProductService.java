package com.mashang.xiaomi.service.productservice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mashang.xiaomi.pojo.DTO.ProductDTO;
import com.mashang.xiaomi.pojo.PO.Product;
import com.mashang.xiaomi.pojo.VO.ProductDetil;
import com.mashang.xiaomi.pojo.VO.ProductHotInfo;
import com.mashang.xiaomi.pojo.normal.AjaxResultRow;

import java.util.List;

public interface ProductService {

    Page<Product> findProductByDto(Long pageSize, Long pageNum, Long categoryId, Long productId, String productNam);

    Page<ProductHotInfo> findHotProduct();

    ProductDetil findProductDetilByPid(Long productId,String token) throws Exception;
}
