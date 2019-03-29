package com.github.quark.common.core.enums;

import com.github.quark.common.core.model.ICode;
import lombok.Getter;

/**
 * 业务返回码
 */
@Getter
public enum CommonCode implements ICode {

    SUCCESS("0000", "成功"),
    TOKEN_WILL_EXPIRE("0001", "token将过期"),
    TOKEN_EXPIRED("0002", "token已过期"),
    REQUEST_PARAM_ILLEGAL("1001", "参数错误"),
    UNKNOWN_EXCEPTION("9999", "系统未知错误");

    private String code;
    private String msg;

    CommonCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonCode get(String code) {
        for (CommonCode cc : values()) {
            if (cc.getCode().equals(code)) {
                return cc;
            }
        }
        return null;
    }
}
