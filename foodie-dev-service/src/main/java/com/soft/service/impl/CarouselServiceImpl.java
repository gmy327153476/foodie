package com.soft.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.ResponseResult;
import com.soft.mapper.CarouselMapper;
import com.soft.pojo.Carousel;
import com.soft.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements ICarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public ResponseResult getCarouselList() {
        List<Carousel> carousels = carouselMapper.selectList(Wrappers.lambdaQuery(Carousel.class));
        return ResponseResult.successResult(carousels);
    }
}
