package com.soft.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mengyuan Guo
 * @Description: 购物车VO
 * @Date: 2021/12/20 14:52
 */
@Data
public class ShopCatVO implements Serializable {

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品图片")
    private String itemImgUrl;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("规格id")
    private String specId;

    @ApiModelProperty("规格名称")
    private String specName;

    @ApiModelProperty("优惠价")
    private Integer priceDiscount;

    @ApiModelProperty("原价")
    private Integer priceNormal;

}
