package com.soft.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.ResponseResult;
import com.soft.constants.Constants;
import com.soft.enums.OrderStatusEnum;
import com.soft.mapper.*;
import com.soft.pojo.DTO.MerchantOrdersVO;
import com.soft.pojo.*;
import com.soft.pojo.VO.ItemVO;
import com.soft.pojo.VO.OrderVO;
import com.soft.service.IOrdersService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单表; 服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private UserAddressMapper userAddressMapper;

    @Resource
    private ItemsSpecMapper itemsSpecMapper;

    @Resource
    private OrderItemsMapper orderItemsMapper;

    @Resource
    private OrderStatusMapper orderStatusMapper;

    @Resource
    private RestTemplate restTemplate;

    @Value("")
    private String payReturn;

    @Transactional
    @Override
    public ResponseResult createOrder(OrderVO orderVO) {
        List<UserAddress> userAddresses = userAddressMapper.selectList(Wrappers.lambdaQuery(UserAddress.class)
                .eq(UserAddress::getId, orderVO.getAddressId()));
        //订单地址
        UserAddress userAddress = userAddresses.get(0);
        //商品规格
        List<String> strings = Arrays.asList(orderVO.getItemSpecIds().split(","));
        List<ItemsSpec> itemsSpecList = itemsSpecMapper.selectBatchIds(strings);
        //组成订单
        Orders orders = new Orders();
        orders.setId(Sid.nextShort());
        orders.setUserId(orderVO.getUserId());
        orders.setReceiverName(userAddress.getReceiver());
        orders.setReceiverMobile(userAddress.getMobile());
        orders.setReceiverAddress(userAddress.getProvince() + userAddress.getCity() + userAddress.getDistrict() + userAddress.getDetail());
        //订单总价格
        //TODO 后面会从redis中取每个商品对应规格的数量，然后求每个购买商品的价格，再相加，这里使用固定值buyCount
        Integer buyCount = 1;
        Integer totalAmount = itemsSpecList.stream().mapToInt(ItemsSpec::getPriceNormal).sum();
        Integer realPayAmount = itemsSpecList.stream().mapToInt(ItemsSpec::getPriceDiscount).sum();
        orders.setTotalAmount(totalAmount);
        //订单实际支付金额
        orders.setRealPayAmount(buyCount);
        //邮费，默认为0
        Integer postAmount = 0;
        orders.setPostAmount(postAmount);
        orders.setPayMethod(orderVO.getPayMethod());
        orders.setLeftMsg(orderVO.getLefMsg());
        orders.setIsComment(Constants.OrderConstants.NOT_COMMENT);
        orders.setIsDelete(Constants.OrderConstants.NOT_DELETE);
        orders.setCreatedTime(new Date());
        orders.setUpdatedTime(new Date());
        ordersMapper.insert(orders);

        //创建子订单
        for (ItemsSpec itemsSpec : itemsSpecList) {
            // 获取商品id,名称，图片
            ItemVO itemVO = itemsSpecMapper.getItemInfoBySpecId(itemsSpec.getId());

            OrderItems orderItems = new OrderItems();
            orderItems.setId(Sid.nextShort());
            orderItems.setOrderId(orders.getId());
            orderItems.setItemId(itemVO.getId());
            orderItems.setItemImg(itemVO.getItemImgUrl());
            orderItems.setItemName(itemVO.getItemName());
            orderItems.setItemSpecId(itemsSpec.getId());
            orderItems.setItemSpecName(itemsSpec.getName());
            orderItems.setPrice(realPayAmount);
            orderItems.setBuyCounts(buyCount);
            orderItemsMapper.insert(orderItems);
        }

        //创建订单状态
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orders.getId());
        orderStatus.setOrderStatus(Constants.OrderConstants.NOT_PAY);
        orderStatus.setCreatedTime(new Date());
        orderStatusMapper.insert(orderStatus);

        //更新订单库存
        for (ItemsSpec itemsSpec : itemsSpecList) {
            //TODO 使用redis后可以从中获取每个商品的购买数量，然后去更新每个商品的库存，这里使用固定的库存 buyCount
            itemsSpec.setStock(itemsSpec.getStock() - buyCount);
            itemsSpecMapper.updateById(itemsSpec);
        }

        //更新购物车cookie中的商品
        //TODO 后面redis集成之后写

        // 将订单信息发送给支付中心（支付中心接收订单信息后，存入支付中心的数据库，用户扫码支付成功后，会返回信息告诉我，并将用户）
        MerchantOrdersVO merchantOrdersVO = new MerchantOrdersVO();
        merchantOrdersVO.setOrderId(orders.getId());
        merchantOrdersVO.setUserId(orders.getUserId());
        merchantOrdersVO.setAmount(realPayAmount);
        merchantOrdersVO.setPayMethod(orders.getPayMethod());
        merchantOrdersVO.setReturnUrl(Constants.PayCenter.RETURN_URL);


        //为了测试购买，所有的支付金额设置为1分钱
        /*merchantOrdersVO.setAmount(1);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("imoocUserId", "imooc");
        headers.add("password", "imooc");
        HttpEntity<MerchantOrdersVO> httpEntity = new HttpEntity<>(merchantOrdersVO, headers);
        ResponseEntity<ResponseResult> responseEntity = restTemplate.postForEntity(Constants.PayCenter.PAYMENT_URL, httpEntity, ResponseResult.class);

        if(!responseEntity.getBody().getMsg().equals("OK")) {
            return ResponseResult.errorResult("支付中心创建订单失败，请联系管理员");
        }*/

        //获取支付页面（网页支付）
        // 这里默认设置订单金额为0.01
        /*Double amount = 0.01;
        String payH5 = null;
        if (PayMethod.ALIPAY.type.equals(orderVO.getPayMethod())) {
            JSONObject bizContent = new JSONObject();
            bizContent.put("out_trade_no", orders.getId());
            bizContent.put("total_amount", amount);
            bizContent.put("subject", orders.getId());
            bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
            bizContent.put("qr_pay_mode", "2");
            AlipayTradePagePayResponse pagePayResponse = AliPayUtils.pagePay(bizContent.toJSONString(), payReturn);
            if (Objects.nonNull(pagePayResponse) && pagePayResponse.isSuccess()) {
                payH5 = pagePayResponse.getBody();
            }
        }*/
        return ResponseResult.successResult(orders);

    }
    @Override
    public ResponseResult notifyMerchantOrderPaid (String merchantOrderId){
        OrderStatus orderStatus = orderStatusMapper.selectById(merchantOrderId);
        orderStatus.setOrderStatus(OrderStatusEnum.WAIT_DELIVER.getType());
        orderStatusMapper.insert(orderStatus);
        return ResponseResult.successResult();
    }
}
