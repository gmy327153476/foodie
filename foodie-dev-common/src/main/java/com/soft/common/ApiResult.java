package com.soft.common;

/**
 * @Author: Mengyuan Guo
 * @Description: 服务端响应工具类
 * @Date: 2021/10/27 17:55
 */
public class ApiResult {
    /**
     * 状态码
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应的数据
     */
    private Object data;


    public static ApiResult ok() {
        return new ApiResult(200, null);
    }

    public static ApiResult ok(Object data) {
        return new ApiResult(200, "操作成功", data);
    }

    public static ApiResult ok(String msg, Object data) {
        return new ApiResult(200, msg, data);
    }

    public static ApiResult build(Integer status, String msg, Object data) {
        return new ApiResult(status, msg, data);
    }

    public static ApiResult error() {
        return new ApiResult(500, "操作失败");
    }

    public static ApiResult error(Object data) {
        return new ApiResult(500, "操作失败", data);
    }

    public static ApiResult error(String msg, Object data) {
        return new ApiResult(500, msg, data);
    }

    public ApiResult() {
        super();
    }

    public ApiResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
