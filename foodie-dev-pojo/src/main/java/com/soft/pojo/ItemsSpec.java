package com.soft.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("items_spec")
@ApiModel(value = "ItemsSpec对象", description = "商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计")
public class ItemsSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品规格id")
    private String id;

    @ApiModelProperty("商品外键id")
    private String itemId;

    @ApiModelProperty("规格名称")
    private String name;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("折扣力度")
    private BigDecimal discounts;

    @ApiModelProperty("优惠价")
    private Integer priceDiscount;

    @ApiModelProperty("原价")
    private Integer priceNormal;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;


}
