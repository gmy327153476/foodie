package com.soft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft.pojo.ItemsComments;
import com.soft.pojo.VO.ItemCommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品评价表  Mapper 接口
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Mapper
public interface ItemsCommentsMapper extends BaseMapper<ItemsComments> {

    /**
     * 获取商品评价
     *
     * @param page
     * @param itemsComments
     * @return
     */
    Page<ItemCommentVO> getItemComment(Page page, @Param("param") ItemsComments itemsComments);
}
