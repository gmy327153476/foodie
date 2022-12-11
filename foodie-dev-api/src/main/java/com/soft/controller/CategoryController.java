package com.soft.controller;


import com.soft.common.ResponseResult;
import com.soft.pojo.Category;
import com.soft.pojo.VO.ItemVO;
import com.soft.service.ICategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品分类  前端控制器
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("查询大分类")
    @RequestMapping(value = "/getColumnList", method = RequestMethod.GET)
    public ResponseResult getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        return ResponseResult.successResult(categoryList);
    }

    @ApiOperation("获取二级分类和三级分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "一级分类id", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getChildCategoryList", method = RequestMethod.GET)
    public ResponseResult getChildCategoryList(Integer id) {
        return ResponseResult.successResult(categoryService.getChildCategoryList(id));
    }

    @ApiOperation("获取大分类下的六个最新商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemVO", value = "商品实体")
    })
    @RequestMapping(value = "/getSixItemByCategory", method = RequestMethod.POST)
    public ResponseResult getSixItemByCategory(@RequestBody ItemVO itemVO) {
        return ResponseResult.successResult(categoryService.getCategoryInfoAndSixNewItem(itemVO));
    }
}

