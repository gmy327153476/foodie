package com.soft.pojo.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mengyuan Guo
 * @Description: 商户传递给支付中心的DTO
 * @Date: 2021/12/28 18:13
 */
@Data
@ApiModel
public class MerchantOrdersVO implements Serializable {

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("支付金额")
    private Integer amount;

    @ApiModelProperty("支付方式")
    private Integer payMethod;

    @ApiModelProperty("支付成功后的回调地址（学生自定义）")
    private String returnUrl;
}
