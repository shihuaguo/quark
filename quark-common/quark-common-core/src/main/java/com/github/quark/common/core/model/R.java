package com.github.quark.common.core.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    // 处理成功
    public static final String OK = ICode.SUCCESS.getCode();
    // 成功描述
    public static final String OK_MSG = ICode.SUCCESS.getMsg();
    // 其他错误
    public static final String ERR = ICode.UNKNOWN_EXCEPTION.getCode();
    // 其他错误
    public static final String ERR_MSG = ICode.UNKNOWN_EXCEPTION.getMsg();

    public static final R SUCCESS = new R(OK, OK_MSG);
    private String code = ERR;
    private String msg = "";
    private T data;

    public static <T> R<T> fail() {
        return new R<>(ERR, ERR_MSG);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(ERR, message);
    }

    public static <T> R<T> fail(String code, String message) {
        return new R<>(code, message);
    }

    public static <T> R<T> success(String message) {
        return new R<>(OK, message);
    }

    public static <T> R<T> successWith(T data) {
        return new R<>(OK, OK_MSG, data);
    }

    public static <T> R<T> success(T data, String message) {
        return new R<>(OK, message, data);
    }

    public R() {
    }

    private R(String code, String message) {
        this(code, message, null);
    }

    private R(String code, String message, T result) {
        this.code = code;
        this.msg = message;
        this.data = result;
    }

    public boolean isSuccess() {
        return OK.equals(code);
    }

    public boolean isFailed() {
        return !OK.equals(code);
    }

}
