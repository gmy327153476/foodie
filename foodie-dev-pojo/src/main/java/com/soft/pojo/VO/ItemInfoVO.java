package com.soft.pojo.VO;

import com.soft.pojo.ItemsImg;
import com.soft.pojo.ItemsParam;
import com.soft.pojo.ItemsSpec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Mengyuan Guo
 * @Description: 商品信息VO
 * @Date: 2021/12/3 10:51
 */
@Data
public class ItemInfoVO implements Serializable {
    @ApiModelProperty("商品主键id")
    private String id;

    @ApiModelProperty("商品名称 商品名称")
    private String itemName;

    @ApiModelProperty("累计销售 累计销售")
    private Integer sellCounts;

    @ApiModelProperty("商品内容 商品内容")
    private String content;

    @ApiModelProperty("商品图片")
    private List<ItemsImg> itemsImgList;

    @ApiModelProperty("商品规格")
    private List<ItemsSpec> itemsSpecList;

    @ApiModelProperty("商品参数")
    private ItemsParam itemsParam;
}
