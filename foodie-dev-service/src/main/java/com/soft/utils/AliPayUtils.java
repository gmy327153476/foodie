package com.soft.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipayUtils;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 支付宝工具类
 * 沙盒账号: qlodsq1689@sandbox.com
 * 密码及支付密码: 111111
 * @author spw
 * @date 2021/12/6
 */
@Slf4j
@Component
public class AliPayUtils {
    /**
     * 阿里请求地址
     */
    private static String serverUrl;
    /**
     * 应用id
     */
    private static String appId;
    /**
     * 应用私钥
     */
    private static String privateKey;
    /**
     * 应用公钥证书
     */
    private static String appCertPath;
    /**
     * 支付宝公钥证书
     */
    private static String aliPayCertPath;
    /**
     * 支付宝根证书
     */
    private static String aliPayRootCertPath;

    @Value("${aliPay.serverUrl}")
    public void setServerUrl(String serverUrl) {
        AliPayUtils.serverUrl = serverUrl;
    }

    @Value("${aliPay.appId}")
    public void setAppId(String appId) {
        AliPayUtils.appId = appId;
    }

    @Value("${aliPay.privateKey}")
    public void setPrivateKey(String privateKey) {
        AliPayUtils.privateKey = privateKey;
    }

    @Value("${aliPay.appCertPath}")
    public void setAppCertPath(String appCertPath) {
        AliPayUtils.appCertPath = appCertPath;
    }

    @Value("${aliPay.aliPayCertPath}")
    public void setAliPayCertPath(String aliPayCertPath) {
        AliPayUtils.aliPayCertPath = aliPayCertPath;
    }

    @Value("${aliPay.aliPayRootCertPath}")
    public void setAliPayRootCertPath(String aliPayRootCertPath) {
        AliPayUtils.aliPayRootCertPath = aliPayRootCertPath;
    }

    /**
     * 获取支付宝证书配置
     *
     * @return
     */
    private static CertAlipayRequest getCertParams() {
        String path = AlipayUtils.class.getResource("/").getPath();
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl(serverUrl);
        certAlipayRequest.setAppId(appId);
        certAlipayRequest.setPrivateKey(privateKey);
        certAlipayRequest.setCertPath(path + appCertPath);
        certAlipayRequest.setAlipayPublicCertPath(path + aliPayCertPath);
        certAlipayRequest.setRootCertPath(path + aliPayRootCertPath);
        certAlipayRequest.setFormat("json");
        certAlipayRequest.setCharset("utf-8");
        certAlipayRequest.setSignType("RSA2");
        return certAlipayRequest;
    }

    /**
     * 网站支付
     *
     * @param bizContent 商品订单信息
     * @param notifyUrl 回调url连接
     * @return
     */
    public static AlipayTradePagePayResponse pagePay(String bizContent, String notifyUrl) {
        AlipayClient alipayClient = null;
        try {
            alipayClient = new DefaultAlipayClient(getCertParams());
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            //支付成功回调
            request.setNotifyUrl(notifyUrl);
            request.setBizContent(bizContent);
            AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
            log.info("zfb page pay response info: ", JSONObject.toJSONString(response));
            return response;
        } catch (AlipayApiException e) {
            log.error("zfb page pay error: ", e);
        }
        return null;
    }

    /**
     * 退款
     * @param bizContent 退款参数实体
     * @return
     */
    public static AlipayTradeRefundResponse refund(String bizContent) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(getCertParams());
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            request.setBizContent(bizContent);
            AlipayTradeRefundResponse response = alipayClient.certificateExecute(request);
            log.info("zfb refund response info: ", JSONObject.toJSONString(response));
            return response;
        } catch (AlipayApiException e) {
            log.error("zfb refund error: ", e);
        }
        return null;
    }

    /**
     * 撤销订单
     * @param bizContent 退款参数实体
     * @return
     */
    public static AlipayTradeCancelResponse cancel(String bizContent) {
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(getCertParams());
            AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
            request.setBizContent(bizContent);
            AlipayTradeCancelResponse response = alipayClient.certificateExecute(request);
            log.info("zfb refund response info: ", JSONObject.toJSONString(response));
            return response;
        } catch (AlipayApiException e) {
            log.error("zfb refund error: ", e);
        }
        return null;
    }

    public static void main(String[] args) throws AlipayApiException {
        String path = AlipayUtils.class.getResource("/").getPath();
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        certAlipayRequest.setAppId("2021000118611045");
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCVBp0YBR5Gwc0Exwam8ODlCgcKSUr3aiVH+/D8qz/isIvM0izcBwVoTAAYPyspL5YHoYAeAE4Fu4f228+u2lfkqcCtHjsK3pYfNfEO9QpTbv/75hwPogkvw0GqaYPca3X15IEsZ4mm1W3TCFrLyHUQPAn7jtzIbqkuGyLLAOpIMOUqpgvHHyE1z6ulbZJng95/32EdjQiQWYjBISz/7agOjtOhxgW+AR+Awqoztp4jns2wg1J/p16X2okh7J9/GBniHGeCuVbbVPm+28fIRulE863bFGU6XBQnvD8lkxPjz8s0+TonnvG0q6ZgyjTASOnLeGhu5/a/7R76oGhyNFWrAgMBAAECggEAUssb185wJath9beFEJZeu6C4jJRvm8lS8Q0ds6KIma6v3Jkf5xXXgTxICTB/ECCp349wGDrfHfwz64fveBtCHX3Z19QlxUIocSqMxFyK4hOXECGlkWHabLiz8LMyWPEy1eufgEX9ibyliUro9rJlpyFUAng6XPht8XmN+O6HOpdl3jGEwfYhh3NFnVRxPBv9v2S+F4TByLq48bfTXHw7qLrh1j12lH1tYUS/6+iglfKESuFr+gWe57CZJdhyqVVH0ZPVKaguqNSRecnB8+vJjVmfO4MbrTUqobGgyIKgPKEBUa/CB6+J3PZdzKLg0SFyYOG3IdSCt2WK1jDM8Fm/8QKBgQDTsZvKrX+PrdcU49bGhLoBWRzmvR48FStfie6cMuu74MHrxCP8Q6CrKUF+gqI1tNSMK2oqHVyWahejV+MURmGmoOEBMvXeU15OYD7zXOFN0b7+NEPQbg6whA62XT8jIJVp3azvirh4z1XWnWrM2CYglUqzpGKBI7pyeGu81On3fwKBgQC0N03fQoYMpcNQdKex7/+NyhZR2RRUCwu5rBN3gD7aPjUA1QSQbptVUOT9K3VDlgsqLl2MtOjceaTMhDxqtiksr3Bdw/LxMMxXJjqmc+81UsGgTUsRTSlDz5PshhmFeWhSRpIVYLe4Er1xlRqMOqLd5QaSRZvw2c1Tri4uCDMX1QKBgQCVa32dV0z8ayWvFwpX4QMxRGcD7mTS39ZXfxIuqjp9yCzYbv8/ZbSYW2xhEW/RHKwRq+spgsQBXy0EHFqpyuvOIyvuHrwwiwO7qm+EcwCMXwnCf72F9sjjirKfwb1429zadp9EDNQcYawi6cWihMaUpQuvNM5afI9zkM/q3xWtnQKBgBchsiEiDMq6zCMblhrEz2yHr+25i15uPIcMi0MfdvHUYkFFFlzjlZSR2ZKVbWvLaotzgBZ7chg6lOibYJXh488UhbvDVv+WX+QfyA9tehrCEJBe22/RE6bckgQeAlCbkMRewolz7KD35tEZblrpe9Y3e2xy+t0jV7OR++N0sfoxAoGAHG7dlTSV3J/t2eev18zjAf4ld9l1wsEBU4teym4pmRTXwmLbZL61BPLfDYV/N41ddOtYAdrLJNC7yJl+dmYxPC/+M60TgQn3ofyle8/AKe/UejqqzRey3QHtoU3+FkdVH7fbsrTpA5lnApILYoKoceqlp/NiXrC5yMEPxDVSXas=");
        certAlipayRequest.setCertPath(path + "alipay/appCertPublicKey_2021000118611045.crt");
        certAlipayRequest.setAlipayPublicCertPath(path + "alipay/alipayCertPublicKey_RSA2_sandbox.crt");
        certAlipayRequest.setRootCertPath(path + "alipay/alipayRootCert_sandbox.crt");
        certAlipayRequest.setFormat("json");
        certAlipayRequest.setCharset("utf-8");
        certAlipayRequest.setSignType("RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
        /*AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //支付成功回调
        request.setNotifyUrl("http://www.wlan001.com/cnsaep/pay/notify");
        JSONObject bizContent = new JSONObject();
        SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils(2, 3);
        bizContent.put("out_trade_no", snowFlakeUtils.nextId());
        bizContent.put("total_amount", 0.01);
        bizContent.put("subject", "测试商品");
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        request.setBizContent(bizContent.toJSONString());
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);*/
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "667781711609999360");
        bizContent.put("refund_amount", 0.01);
        request.setBizContent(bizContent.toJSONString());
        AlipayTradeRefundResponse response = alipayClient.certificateExecute(request);
        System.out.println(JSONObject.toJSONString(response));
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

}
