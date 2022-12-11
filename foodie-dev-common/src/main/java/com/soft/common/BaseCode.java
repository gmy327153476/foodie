package com.soft.common;

/**
 * @Author: Mengyuan Guo
 * @Description: 响应信息
 * @Date: 2021/10/28 9:29
 */
public enum BaseCode {
    SUCCESS(200, "操作成功"),
    ERROR(500, "操作失败"),
    USERNAME_EXIST(10000, "用户名已存在")
    ;

    public Integer code;

    public String msg;

    BaseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
