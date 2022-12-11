package com.soft.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description: 一级分类下六条最新商品
 * @Date: 2021/11/29 18:15
 */
@Data
public class NewItemVO implements Serializable {
    @ApiModelProperty("一级分类id")
    private Integer rootCatId;
    @ApiModelProperty("分类名称")
    private String rootCatName;
    @ApiModelProperty("分类口号")
    private String slogan;
    @ApiModelProperty("分类图")
    private String catImage;
    @ApiModelProperty("背景颜色")
    private String bgColor;

    @ApiModelProperty("商品列表")
    private List<ItemVO> itemVOList;

}
