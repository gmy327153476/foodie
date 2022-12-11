package com.soft.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description: 分类vo
 * @Date: 2021/11/29 17:40
 */
@Data
public class CategoryVO implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("父id")
    private Integer fatherId;

    @ApiModelProperty("口号")
    private String slogan;

    /**
     * 三级分类
     */
    private List<CategoryVO> categoryVOList;

}
