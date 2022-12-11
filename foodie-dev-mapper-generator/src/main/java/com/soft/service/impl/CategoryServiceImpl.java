package com.soft.service.impl;

import com.soft.pojo.Category;
import com.soft.mapper.CategoryMapper;
import com.soft.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
