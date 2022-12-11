package com.soft.pojo.VO;

import com.soft.pojo.OrderItems;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2022/3/14 10:07
 */
@Data
public class CenterOrderRespVO implements Serializable {
    @ApiModelProperty("订单id")
    private String id;

    @ApiModelProperty("订单真实支付金额")
    private Double realPayAmount;

    @ApiModelProperty("支付方式")
    private Integer payMethod;

    @ApiModelProperty("运费")
    private Double postAmount;

    @ApiModelProperty("商品")
    private List<OrderItems> orderItemsList;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("订单创建时间;对应[10:待付款]状态")
    private Date createdTime;

    @ApiModelProperty("支付成功时间;对应[20:已付款，待发货]状态")
    private Date payTime;

    @ApiModelProperty("发货时间;对应[30：已发货，待收货]状态")
    private Date deliverTime;

    @ApiModelProperty("交易成功时间;对应[40：交易成功]状态")
    private Date successTime;

    @ApiModelProperty("交易关闭时间;对应[50：交易关闭]状态")
    private Date closeTime;

    @ApiModelProperty("留言时间;用户在交易成功后的留言时间")
    private Date commentTime;

}
