package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.pojo.Category;
import com.soft.pojo.VO.CategoryVO;
import com.soft.pojo.VO.ItemVO;
import com.soft.pojo.VO.NewItemVO;

import java.util.List;

/**
 * <p>
 * 商品分类  服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 获取大分类
     * @return
     */
    List<Category> getCategoryList();

    /**
     * 获取二级分类和三级分类
     * @return
     */
    List<CategoryVO> getChildCategoryList(Integer id);

    /**
     * 获取大分类信息及其下面的六个最新商品
     * @param itemVO
     * @return
     */
    NewItemVO getCategoryInfoAndSixNewItem(ItemVO itemVO);


}
