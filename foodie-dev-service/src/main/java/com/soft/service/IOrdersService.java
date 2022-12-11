package com.soft.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.common.ResponseResult;
import com.soft.pojo.Orders;
import com.soft.pojo.VO.OrderVO;

/**
 * <p>
 * 订单表; 服务类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
public interface IOrdersService extends IService<Orders> {

    /**
     * 创建订单
     * @param orderVO
     * @return
     */
    ResponseResult createOrder(OrderVO orderVO);

    /**
     * 支付中心创建订单后，回调该接口，修改本地订单的状态
     * @param merchantOrderId
     * @return
     */
    ResponseResult notifyMerchantOrderPaid(String merchantOrderId);
}
