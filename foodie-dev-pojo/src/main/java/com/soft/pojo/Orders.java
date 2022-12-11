package com.soft.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单表;
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Getter
@Setter
@ApiModel(value = "Orders对象", description = "订单表;")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单主键;同时也是订单编号")
    private String id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("收货人快照")
    private String receiverName;

    @ApiModelProperty("收货人手机号快照")
    private String receiverMobile;

    @ApiModelProperty("收货地址快照")
    private String receiverAddress;

    @ApiModelProperty("订单总价格")
    private Integer totalAmount;

    @ApiModelProperty("实际支付总价格")
    private Integer realPayAmount;

    @ApiModelProperty("邮费;默认可以为零，代表包邮")
    private Integer postAmount;

    @ApiModelProperty("支付方式")
    private Integer payMethod;

    @ApiModelProperty("买家留言")
    private String leftMsg;

    @ApiModelProperty("扩展字段")
    private String extand;

    @ApiModelProperty("买家是否评价;1：已评价，0：未评价")
    private Integer isComment;

    @ApiModelProperty("逻辑删除状态;1: 删除 0:未删除")
    private Integer isDelete;

    @ApiModelProperty("创建时间（成交时间）")
    private Date createdTime;

    @ApiModelProperty("更新时间")
    private Date updatedTime;


}
