package com.soft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft.pojo.Items;
import com.soft.pojo.VO.ItemCommentVO;
import com.soft.pojo.VO.ItemInfoVO;
import com.soft.pojo.VO.KeywordVO;
import com.soft.pojo.VO.ShopCatVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface ItemsMapper extends BaseMapper<Items> {

    /**
     * 查询商品详情
     * @param items
     * @return
     */
    ItemInfoVO getItemInfo(String id);

    /**
     * 商品评价数量
     * @param id
     * @return
     */
    ItemCommentVO getCommentLevelNum(String id);

    /**
     * 首页搜索
     * @param keywordVO
     * @return
     */
    IPage search(Page page, @Param("keywordVO") KeywordVO keywordVO);

    /**
     * 类型搜索
     * @param keywordVO
     * @return
     */
    IPage searchCategory(Page page, @Param("keywordVO") KeywordVO keywordVO);

    /**
     * 获取购物车列表
     * @param asList
     * @return
     */
    List<ShopCatVO> getShopCatList(@Param("asList") List<String> asList);
}
