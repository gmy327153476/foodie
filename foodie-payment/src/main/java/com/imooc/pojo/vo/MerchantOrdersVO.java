package com.imooc.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class MerchantOrdersVO {

    @ApiModelProperty("支付成功后的回调地址（学生自定义）")
    private String returnUrl;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("实际支付总金额（包含商户所支付的订单费邮费总额）")
    private Integer amount;

    @ApiModelProperty("支付方式 1:微信   2:支付宝")
    private Integer payMethod;


}