package com.soft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.pojo.Category;
import com.soft.pojo.VO.CategoryVO;
import com.soft.pojo.VO.ItemVO;
import com.soft.pojo.VO.NewItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 获取二级分类和三级分类
     * @param id
     * @return
     */
    List<CategoryVO> getChildCategoryList(Integer id);

    /**
     * 获取大分类信息及其下面的六个最新商品
     * @param itemVO
     * @return
     */
    NewItemVO getCategoryInfoAndSixNewItem(@Param("itemVO") ItemVO itemVO);
}
