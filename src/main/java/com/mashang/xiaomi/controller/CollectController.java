package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.VO.Category;
import com.mashang.xiaomi.pojo.VO.CollectVO;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.service.categoryservice.CategoryService;
import com.mashang.xiaomi.service.collectservice.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(tags = "收藏")
@RequestMapping("/xiaomi")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @GetMapping("/collect")
    @ApiOperation(value = "查询当前用户收藏商品信息")
    public AjaxResult<List<CollectVO>> getMyCollecty(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        List<CollectVO> myCollectByToken = collectService.findMyCollectByToken(token);
        return new AjaxResult<>(200,"查询成功",myCollectByToken);
    }
    @PostMapping("/collect/{productId}")
    @ApiOperation(value = "收藏-取消收藏")
    public AjaxResult inAndOutCollect(HttpServletRequest request, @ApiParam(value = "productId",name = "productId",required = true) @PathVariable("productId") Long productId) throws Exception {
        String token = request.getHeader("token");
        collectService.changeCollectState(token,productId);
        return new AjaxResult<>(200,"更改成功");
    }


}
