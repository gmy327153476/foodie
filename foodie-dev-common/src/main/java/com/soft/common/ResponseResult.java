package com.soft.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Mengyuan Guo
 * @Description: 服务端响应参数
 * @Date: 2021/10/27 18:39
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class ResponseResult {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    public ResponseResult(BaseCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ResponseResult(BaseCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static ResponseResult successResult() {
        return new ResponseResult()
                .setCode(BaseCode.SUCCESS.code)
                .setMsg(BaseCode.SUCCESS.msg);
    }

    public static ResponseResult successResult(Object data) {
        return new ResponseResult()
                .setCode(BaseCode.SUCCESS.code)
                .setMsg(BaseCode.SUCCESS.msg)
                .setData(data);
    }

    public static ResponseResult errorResult() {
        return new ResponseResult(BaseCode.ERROR);
    }

    public static ResponseResult errorResult(BaseCode resultCode) {
        return new ResponseResult(resultCode);
    }

    public static ResponseResult errorResult(String msg) {
        return new ResponseResult()
                .setCode(500)
                .setMsg(msg);
    }

    public static ResponseResult errorResult(BaseCode resultCode, Object data) {
        return new ResponseResult(resultCode, data);
    }

    public ResponseResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResponseResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }
}
