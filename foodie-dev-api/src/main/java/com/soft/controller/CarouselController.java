package com.soft.controller;


import com.soft.common.ResponseResult;
import com.soft.service.ICarouselService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private ICarouselService carouselService;

    @ApiOperation("获取首页轮播图")
    @RequestMapping(value = "/getCarouselList", method = RequestMethod.GET)
    public ResponseResult getCarouselList() {
        return carouselService.getCarouselList();
    }

}

