package com.soft.enums;

/**
 * @Author: Mengyuan Guo
 * @Description: 状态码
 * @Date: 2021/12/30 15:52
 */
public enum StatusCode {
    OK(200, "操作成功"),
    ERROR(500, "操作失败");

    public Integer code;
    public String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
