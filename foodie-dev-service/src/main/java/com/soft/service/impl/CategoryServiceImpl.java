package com.soft.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.constants.Constants;
import com.soft.mapper.CategoryMapper;
import com.soft.mapper.ItemsMapper;
import com.soft.pojo.Category;
import com.soft.pojo.VO.CategoryVO;
import com.soft.pojo.VO.ItemVO;
import com.soft.pojo.VO.NewItemVO;
import com.soft.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品分类  服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = categoryMapper.selectList(Wrappers.lambdaQuery(Category.class)
                .eq(Category::getType, Constants.RequestConstants.CATEGORY_TYPE));
        return categoryList;
    }

    @Override
    public List<CategoryVO> getChildCategoryList(Integer id) {
        List<CategoryVO> categoryList = categoryMapper.getChildCategoryList(id);
        return categoryList;
    }

    @Override
    public NewItemVO getCategoryInfoAndSixNewItem(ItemVO itemVO) {
        itemVO.setIsMain(Constants.RequestConstants.ITEM_IS_MAIN);
        NewItemVO newItemVO = categoryMapper.getCategoryInfoAndSixNewItem(itemVO);
        return newItemVO;
    }
}
