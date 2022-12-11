package com.soft.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 订单商品关联表 
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@TableName("order_items")
@ApiModel(value = "OrderItems对象", description = "订单商品关联表 ")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("归属订单id")
    private String orderId;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品图片")
    private String itemImg;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("规格id")
    private String itemSpecId;

    @ApiModelProperty("规格名称")
    private String itemSpecName;

    @ApiModelProperty("成交价格")
    private Integer price;

    @ApiModelProperty("购买数量")
    private Integer buyCounts;


}
