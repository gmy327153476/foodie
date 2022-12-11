package com.soft.pojo.VO;

import com.soft.common.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-18:30
 * @Description:
 */
@Data
public class CenterOrderVO extends PageInfo<CenterOrderVO> implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("订单金额")
    private String totalAmount;

    @ApiModelProperty("订单标题")
    private String orderName;

}
