package com.soft.pojo.VO;

import com.soft.common.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Mengyuan Guo
 * @Description: 搜索VO
 * @Date: 2021/12/13 17:36
 */
@Data
public class KeywordVO extends PageInfo<KeywordVO> implements Serializable {

    @ApiModelProperty("首页搜索词")
    private String searchKeyword;

    @ApiModelProperty("排序参数")
    private String sort;

    @ApiModelProperty("类型搜索id")
    private Integer catId;
}
