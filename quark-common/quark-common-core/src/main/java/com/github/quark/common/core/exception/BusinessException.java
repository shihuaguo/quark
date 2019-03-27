package com.github.quark.common.core.exception;

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

    /**
     * 异常类型，用于区分打印日志级别,默认为warn
     */
    ExceptionTypeEnum type = ExceptionTypeEnum.WARN;


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


    public BusinessException(String message, ExceptionTypeEnum type) {
        super(message);
        this.type = type;
    }

    public BusinessException(String code, String message, ExceptionTypeEnum type) {
        super(message);
        this.code = code;
        this.type = type;
    }

    public BusinessException(String code, String message, Throwable t, ExceptionTypeEnum type) {
        super(message, t);
        this.code = code;
        this.type = type;
    }

    public static enum ExceptionTypeEnum {
        ERROR,
        ExceptionTypeEnum, WARN
    }
}
