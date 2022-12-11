package com.soft.service.impl.center;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.ResponseResult;
import com.soft.constants.Constants;
import com.soft.mapper.OrderStatusMapper;
import com.soft.mapper.center.CenterOrderMapper;
import com.soft.pojo.OrderStatus;
import com.soft.pojo.Orders;
import com.soft.pojo.VO.CenterOrderRespVO;
import com.soft.pojo.VO.CenterOrderVO;
import com.soft.service.center.CenterOrderService;
import com.soft.utils.AliPayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author Mengyuan Guo
 * @create 2022-03-13-17:49
 * @Description:
 */
@Service
public class CenterOrderServiceImpl extends ServiceImpl<CenterOrderMapper, Orders> implements CenterOrderService {

    @Resource
    private CenterOrderMapper centerOrderMapper;
    @Resource
    private OrderStatusMapper orderStatusMapper;

    @Value("${aliPay.notifyUrl}")
    private String notifyUrl;

    @Override
    public ResponseResult findCenterOrder(CenterOrderVO centerOrderVO) {
        if(StringUtils.isBlank(centerOrderVO.getUserId())) {
            return ResponseResult.errorResult("参数错误");
        }
        Integer pageNum = centerOrderVO.getPageNum() == 0 ? 1 : centerOrderVO.getPageNum();
        Integer pageSize = centerOrderVO.getPageSize() == 0  ? 10 : centerOrderVO.getPageSize();
        Page page = new Page(pageNum, pageSize);
        Page<CenterOrderRespVO> centerOrder = centerOrderMapper.findCenterOrder(page, centerOrderVO);

        return ResponseResult.successResult(centerOrder);
    }

    @Override
    public ResponseResult orderPay(CenterOrderVO centerOrderVO) {
        //将支付金额设为 1
        centerOrderVO.setTotalAmount("1");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("out_trade_no", centerOrderVO.getOrderId());
        jsonObject.put("total_amount", centerOrderVO.getTotalAmount());
        jsonObject.put("subject", centerOrderVO.getOrderName());
        jsonObject.put("product_code", "FAST_INSTANT_TRADE_PAY");
        jsonObject.put("qr_pay_mode", "2");
        String payH5 = null;
        AlipayTradePagePayResponse pagePayResponse = AliPayUtils.pagePay(jsonObject.toJSONString(), notifyUrl);
        if(Objects.nonNull(pagePayResponse) && pagePayResponse.isSuccess()) {
            payH5 = pagePayResponse.getBody();
        } else {
            payH5 = "支付页面生成失败";
        }

        return ResponseResult.successResult(payH5);
    }

    @Override
    public String notifyUrl(Map<String, String[]> parameterMap) {
        String[] tradeStatuses = parameterMap.get("trade_status");
        String tradeStatus = null;
        if (Objects.nonNull(tradeStatuses) && tradeStatuses.length > 0) {
            tradeStatus = tradeStatuses[0];
        }

        //支付成功 订单编号和用户账号不可能为空
        if(Constants.Pay.TRADE_SUCCESS.equals(tradeStatus)) {
            //买家账号
            String buyerId = parameterMap.get("buyer_id")[0];
            //订单号
            String outTradeNo = parameterMap.get("out_trade_no")[0];
            //更新订单状态
            OrderStatus orderStatus = orderStatusMapper.selectById(buyerId);
            if(Objects.nonNull(orderStatus)) {
                orderStatus.setOrderStatus(20);
                orderStatus.setCreatedTime(new Date());
                orderStatusMapper.updateById(orderStatus);
            }
            return "success";
        }
        return "fail";
    }
}
