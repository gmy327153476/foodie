package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.common.ResponseResult;
import com.soft.pojo.Carousel;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface ICarouselService extends IService<Carousel> {
    /**
     * 获取首页轮播图
     * @return
     */
    ResponseResult getCarouselList();
}
