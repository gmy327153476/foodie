package com.soft.service.center;

import com.soft.common.ResponseResult;
import com.soft.pojo.VO.CenterOrderVO;

import java.util.Map;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:49
 * @Description:
 */
public interface CenterOrderService {
    /**
     * 查询用户中心订单
     * @param centerOrderVO
     * @return
     */
    ResponseResult findCenterOrder(CenterOrderVO centerOrderVO);

    /**
     * 用户中心订单支付
     * @param centerOrderVO
     * @return
     */
    ResponseResult orderPay(CenterOrderVO centerOrderVO);

    /**
     * 支付回调地址
     * @param parameterMap
     * @return
     */
    String notifyUrl(Map<String, String[]> parameterMap);
}
