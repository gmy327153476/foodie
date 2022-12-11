package com.soft.mapper.center;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft.pojo.Orders;
import com.soft.pojo.VO.CenterOrderRespVO;
import com.soft.pojo.VO.CenterOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:50
 * @Description:
 */
@Mapper
public interface CenterOrderMapper extends BaseMapper<Orders> {
    /**
     * 查询用户中心订单
     *
     * @param page
     * @param centerOrderVO
     * @return
     */
    Page<CenterOrderRespVO> findCenterOrder(Page page, @Param("centerOrderVO") CenterOrderVO centerOrderVO);
}
