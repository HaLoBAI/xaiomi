package com.mashang.xiaomi.service.carouselservice.impl;

import com.mashang.xiaomi.mapper.CarouselMapper;
import com.mashang.xiaomi.pojo.PO.Carousel;
import com.mashang.xiaomi.service.carouselservice.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> findCarousel() {
        List<Carousel> carousels = carouselMapper.selectList(null);
        return carousels;
    }
}
