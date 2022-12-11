package com.soft.pojo.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mengyuan Guo
 * @Description: 订单VO
 * @Date: 2021/12/22 18:45
 */
@Data
@ApiModel
public class OrderVO implements Serializable {
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("多个商品规格id")
    private String itemSpecIds;

    @ApiModelProperty("地址id")
    private String addressId;

    @ApiModelProperty("支付方式")
    private Integer payMethod;

    @ApiModelProperty("买家留言")
    private String lefMsg;

    @ApiModelProperty("邮费")
    private Integer postTage;
}
