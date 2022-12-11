package com.soft.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mengyuan Guo
 * @Description: 用户地址VO
 * @Date: 2021/12/22 11:51
 */
@Data
public class UserAddressVO implements Serializable {

    @ApiModelProperty("地址id")
    private String id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("收件人姓名")
    private String receiver;

    @ApiModelProperty("收件人手机号")
    private String mobile;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区县")
    private String district;

    @ApiModelProperty("详细地址")
    private String detail;

    @ApiModelProperty("是否默认地址")
    private Integer isDefault;
}
