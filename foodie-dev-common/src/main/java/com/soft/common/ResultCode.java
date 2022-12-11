package com.soft.common;

/**
 * @Author: Mengyuan Guo
 * @Description:
 * @Date: 2021/10/28 11:20
 */
public interface ResultCode {

    /**
     * 状态码
     * @return
     */
    Integer code();

    /**
     * 响应信息
     */
    String msg();

    /**
     * 响应数据
     */
    Object data();
}
