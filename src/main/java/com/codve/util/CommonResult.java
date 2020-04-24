package com.codve.util;

import com.codve.exception.EX;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author admin
 * @date 2020/4/24 18:57
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult<T> {

    private int code;

    private String msg;

    private T data;

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult success() {
        return new CommonResult(EX.E_0.getCode(), EX.E_0.getMsg());
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(EX.E_0.getCode(), EX.E_0.getMsg(), data);
    }

    public static CommonResult error(EX ex) {
        return new CommonResult(ex.getCode(), ex.getMsg());
    }

    public static CommonResult error(int code, String msg) {
        return new CommonResult(code, msg);
    }

    public static <T> CommonResult<T> errorNull(EX ex) {
        return new CommonResult<>(ex.getCode(), ex.getMsg());
    }

    public static <T> CommonResult<T> errorNull(int code, String msg) {
        return new CommonResult<>(code, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
