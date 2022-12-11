package com.soft.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@ApiModel(value = "Items对象", description = "商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表")
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品主键id")
    private String id;

    @ApiModelProperty("商品名称 商品名称")
    private String itemName;

    @ApiModelProperty("分类外键id 分类id")
    private Integer catId;

    @ApiModelProperty("一级分类外键id")
    private Integer rootCatId;

    @ApiModelProperty("累计销售 累计销售")
    private Integer sellCounts;

    @ApiModelProperty("上下架状态 上下架状态,1:上架 2:下架")
    private Integer onOffStatus;

    @ApiModelProperty("商品内容 商品内容")
    private String content;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
