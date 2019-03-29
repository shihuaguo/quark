package com.github.quark.common.core.exception;

import com.github.quark.common.core.model.ICode;
import com.github.quark.common.core.model.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 *
 * @author ioun
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String code = R.ERR;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public BusinessException(ICode code) {
        super(code.getMsg());
        this.code = code.getCode();
    }
}
