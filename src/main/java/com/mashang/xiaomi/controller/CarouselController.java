package com.mashang.xiaomi.controller;

import com.mashang.xiaomi.pojo.PO.Carousel;
import com.mashang.xiaomi.pojo.VO.CarouselVO;
import com.mashang.xiaomi.pojo.VO.Category;
import com.mashang.xiaomi.pojo.normal.AjaxResult;
import com.mashang.xiaomi.service.carouselservice.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "轮播图")
@RequestMapping("/xiaomi")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;
    @GetMapping("/carousel")
    @ApiOperation(value = "查询轮播图列表")
    public AjaxResult<List<CarouselVO>> getCategory() {
        List<Carousel> carousel = carouselService.findCarousel();
        ArrayList<CarouselVO> carouselVOS = new ArrayList<>();
        for (Carousel carousel1 : carousel) {
            CarouselVO carouselVO = new CarouselVO();
            BeanUtils.copyProperties(carousel1,carouselVO);
            carouselVOS.add(carouselVO);
        }
        return new AjaxResult<>(200,"查询成功",carouselVOS);
    }
}
