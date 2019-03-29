package com.github.quark.common.core.model;

import com.github.quark.common.core.enums.CommonCode;

/**
 * 返回码和描述
 */
public interface ICode {
    String getCode();

    String getMsg();

    ICode SUCCESS = CommonCode.SUCCESS;
    ICode TOKEN_WILL_EXPIRE = CommonCode.TOKEN_WILL_EXPIRE;
    ICode TOKEN_EXPIRED = CommonCode.TOKEN_EXPIRED;
    ICode REQUEST_PARAM_ILLEGAL = CommonCode.REQUEST_PARAM_ILLEGAL;
    ICode UNKNOWN_EXCEPTION = CommonCode.UNKNOWN_EXCEPTION;
}
