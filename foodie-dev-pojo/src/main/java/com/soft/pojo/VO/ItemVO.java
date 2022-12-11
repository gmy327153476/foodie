package com.soft.pojo.VO;

import com.soft.common.PageInfo;
import com.soft.pojo.ItemsSpec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description: 商品基本信息VO
 * @Date: 2021/11/29 18:21
 */
@Data
public class ItemVO extends PageInfo<ItemVO> implements Serializable {
    @ApiModelProperty("商品id")
    private String id;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("商品图片")
    private String itemImgUrl;

    @ApiModelProperty("分类id")
    private Integer categoryId;

    @ApiModelProperty("是否主图")
    private Integer isMain;

    @ApiModelProperty("商品价格")
    private Integer priceDiscount;

    @ApiModelProperty("销量")
    private Integer sellCounts;

    @ApiModelProperty("规格")
    private List<ItemsSpec> itemsSpecList;
}
