package com.soft.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 轮播图 
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@ApiModel(value = "Carousel对象", description = "轮播图 ")
public class Carousel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @Id
    private String id;

    @ApiModelProperty("图片 图片地址")
    private String imageUrl;

    @ApiModelProperty("背景色")
    private String backgroundColor;

    @ApiModelProperty("商品id 商品id")
    private String itemId;

    @ApiModelProperty("商品分类id 商品分类id")
    private String catId;

    @ApiModelProperty("轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类")
    private Integer type;

    @ApiModelProperty("轮播图展示顺序")
    private Integer sort;

    @ApiModelProperty("是否展示")
    private Integer isShow;

    @ApiModelProperty("创建时间 创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间 更新")
    private LocalDateTime updateTime;


}
