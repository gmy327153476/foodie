package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.mapper.OrdersMapper;
import com.imooc.pojo.Orders;
import com.imooc.pojo.vo.MerchantOrdersVO;
import com.imooc.service.PaymentOrderService;
import com.soft.enums.PaymentStatus;
import com.soft.enums.YesOrNo;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author web
 */
@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

	@Resource
	private OrdersMapper ordersMapper;


	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean createPaymentOrder(MerchantOrdersVO merchantOrdersVO) {

		String id = Sid.nextShort();

		Orders paymentOrder = new Orders();
		BeanUtils.copyProperties(merchantOrdersVO, paymentOrder);

		paymentOrder.setId(id);
		paymentOrder.setMerchantOrderId(merchantOrdersVO.getOrderId());
		paymentOrder.setMerchantUserId(merchantOrdersVO.getUserId());
		paymentOrder.setPayStatus(PaymentStatus.WAIT_PAY.type);
		paymentOrder.setComeFrom("天天吃货");
		paymentOrder.setReturnUrl(merchantOrdersVO.getReturnUrl());
		paymentOrder.setIsDelete(YesOrNo.NO.type);
		paymentOrder.setCreatedTime(new Date());

		int result = ordersMapper.insert(paymentOrder);
		return result == 1 ? true : false;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Orders queryOrderByStatus(String merchantUserId, String merchantOrderId, Integer orderStatus) {
		Orders waitPayOrder = ordersMapper.selectOne(Wrappers.lambdaQuery(Orders.class)
				.eq(Orders::getMerchantOrderId, merchantOrderId)
				.eq(Orders::getMerchantUserId, merchantUserId)
				.eq(Orders::getPayStatus, orderStatus));

		return waitPayOrder;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public String updateOrderPaid(String merchantOrderId, Integer paidAmount) {
		Orders paidOrder = new Orders();
		paidOrder.setPayStatus(PaymentStatus.PAID.type);
		paidOrder.setAmount(paidAmount);

		ordersMapper.update(paidOrder, Wrappers.lambdaUpdate(Orders.class)
				.eq(Orders::getMerchantOrderId, merchantOrderId));

		return queryMerchantReturnUrl(merchantOrderId);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	String queryMerchantReturnUrl(String merchantOrderId) {
		Orders order = ordersMapper.selectOne(Wrappers.lambdaQuery(Orders.class)
				.eq(Orders::getMerchantOrderId, merchantOrderId));

		return order.getReturnUrl();
	}

	@Override
	public Orders queryOrderInfo(String merchantUserId, String merchantOrderId) {

		return ordersMapper.selectOne(Wrappers.lambdaQuery(Orders.class)
				.eq(Orders::getMerchantOrderId, merchantOrderId)
				.eq(Orders::getMerchantUserId, merchantUserId));
	}
}
