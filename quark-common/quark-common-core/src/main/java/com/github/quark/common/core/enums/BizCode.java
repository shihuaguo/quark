package com.github.quark.common.core.enums;

import lombok.Getter;

/**
 * 业务返回码
 */
@Getter
public enum BizCode {

    SUCCESS("0000", "成功"),
    TOKEN_WILL_EXPIRE("0001", "token将过期"),
    REQUEST_PARAM_ILLEGAL("1001", "参数错误"),
    UNKNOWN_EXCEPTION("9999", "系统未知错误");

    private String code;
    private String msg;

    BizCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static BizCode get(String code) {
        for (BizCode bizCode : values()) {
            if (bizCode.getCode().equals(code)) {
                return bizCode;
            }
        }
        return null;
    }
}
