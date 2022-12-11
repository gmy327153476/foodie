package com.soft.controller;


import com.soft.common.ResponseResult;
import com.soft.pojo.ItemsComments;
import com.soft.pojo.VO.KeywordVO;
import com.soft.service.IItemsService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/items")
public class ItemsController {

    @Resource
    private IItemsService itemsService;

    @ApiModelProperty("获取商品详情")
    @RequestMapping(value = "/getItemInfo", method = RequestMethod.GET)
    public ResponseResult getItemInfo(String id) {

        return itemsService.getItemInfo(id);
    }

    @ApiModelProperty("获取商品评价")
    @RequestMapping(value = "/getItemComment", method = RequestMethod.POST)
    public ResponseResult getItemComment(@RequestBody ItemsComments itemsComments) {
        ResponseResult itemComment = itemsService.getItemComment(itemsComments);
        return itemComment;
    }

    @ApiModelProperty("获取商品评价熟练")
    @RequestMapping(value = "/getCommentLevelNum", method = RequestMethod.GET)
    public ResponseResult getCommentLevelNum(String itemId) {
        ResponseResult commentLevelNum = itemsService.getCommentLevelNum(itemId);
        return commentLevelNum;
    }

    @ApiModelProperty("主页搜索商品")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseResult search(@RequestBody KeywordVO keywordVO) {
        return itemsService.search(keywordVO);
    }

    @ApiModelProperty("主页类型搜索商品")
    @RequestMapping(value = "/searchCategory", method = RequestMethod.POST)
    public ResponseResult searchCategory(@RequestBody KeywordVO keywordVO) {
        return itemsService.searchCategory(keywordVO);
    }
}

