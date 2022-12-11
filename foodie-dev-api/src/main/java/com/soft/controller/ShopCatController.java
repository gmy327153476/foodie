package com.soft.controller;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.ShopCatVO;
import com.soft.service.IItemsService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description: 购物车表现层
 * @Date: 2021/12/20 14:43
 */
@RestController
@RequestMapping("/shopCat")
public class ShopCatController {
    @Resource
    private IItemsService itemsService;

    @ApiModelProperty(value = "获取购物车商品列表")
    @RequestMapping(value = "/getShopCatList", method = RequestMethod.GET)
    public ResponseResult getShopCatList(String itemSpecIds) {
        List<String> asList = Arrays.asList(itemSpecIds.split(","));
        List<ShopCatVO> shopCatVOLIst = itemsService.getShopCatList(asList);
        return ResponseResult.successResult(shopCatVOLIst);
    }


}
