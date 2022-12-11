package com.soft.constants;

/**
 * @Author: Mengyuan Guo
 * @Description: 请求枚举参数
 * @Date: 2021/11/29 17:27
 */
public interface Constants{

    /**
     * 请求常量
     */
    final class RequestConstants {
        /**
         * 分类类型
         */
        public static final Integer CATEGORY_TYPE = 1;

        /**
         * 商品主图
         */
        public static final Integer ITEM_IS_MAIN = 1;

        /**
         * 默认地址
         */
        public static final Integer IS_DEFAULT = 1;

        /**
         * 非默认地址
         */
        public static final Integer NOT_IS_DEFAULT = 0;
    }

    /**
     * 支付中心
     */
    final class PayCenter {
        // TODO 后面换成自己的支付中心
        public static final String PAYMENT_URL = "http://localhost:9091/payment/createMerchantOrder";
        // 支付中心回调地址  支付中心订单支付成功，更改本地的订单状态
        public static final String RETURN_URL = "http://localhost:9090/orders/notifyMerchantOrderPaid";
    }

    /**
     * 订单常量
     */
    final class OrderConstants {
        /**
         * 已经评价
         */
        public static final Integer IS_COMMENT = 1;

        /**
         * 未评价
         */
        public static final Integer NOT_COMMENT = 0;

        /**
         * 逻辑删除状态 已删除
         */
        public static final Integer IS_DELETE = 1;

        /**
         * 逻辑删除状态 未删除
         */
        public static final Integer NOT_DELETE = 0;

        /**
         * 订单状态 未支付
         */
        public static final Integer NOT_PAY = 10;

        /**
         * 订单状态 已支付
         */
        public static final Integer IS_PAY = 20;

        /**
         * 订单状态 已发货
         */
        public static final Integer IS_SEND = 30;

        /**
         * 订单状态 交易成功
         */
        public static final Integer TRADE_SUCCESS = 40;

        /**
         * 订单状态 交易关闭
         */
        public static final Integer TRADE_CLOSE = 50;
    }

    /**
     * 订单&支付
     */
    final class Pay {
        /**
         * 支付方式：支付宝
         */
        public static final String ZFB_STYLE = "ZFB";
        /**
         * 支付方式：微信
         */
        public static final String WX_STYLE = "WX";
        /**
         * 支付状态：待支付
         */
        public static final int NOT_PAID = 0;
        /**
         * 支付状态：已支付
         */
        public static final int ALREADY_PAY = 1;
        /**
         * 支付状态：已取消
         */
        public static final int PAY_CANCEL = 2;
        /**
         * 支付状态：已退款
         */
        public static final int REFUND = 3;
        /**
         * 支付宝回调状态：支付成功
         */
        public static final String TRADE_SUCCESS = "TRADE_SUCCESS";
    }
}
