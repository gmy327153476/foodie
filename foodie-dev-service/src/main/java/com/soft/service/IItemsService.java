package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.common.ResponseResult;
import com.soft.pojo.Items;
import com.soft.pojo.ItemsComments;
import com.soft.pojo.VO.KeywordVO;
import com.soft.pojo.VO.ShopCatVO;

import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface IItemsService extends IService<Items> {

    /**
     * 查询商品详情
     * @param items
     * @return
     */
    ResponseResult getItemInfo(String id);

    /**
     * 获取商品评价
     */
    ResponseResult getItemComment(ItemsComments iItemsComments);

    /**
     * 获取评价等级数量
     * @param id
     * @return
     */
    ResponseResult getCommentLevelNum(String id);

    /**
     * 首页商品搜索
     * @param keywordVO
     * @return
     */
    ResponseResult search(KeywordVO keywordVO);

    /**
     * 类型商品搜索
     */
    ResponseResult searchCategory(KeywordVO keywordVO);

    /**
     * 获取购物车列表
     * @param asList
     * @return
     */
    List<ShopCatVO> getShopCatList(List<String> asList);


}
