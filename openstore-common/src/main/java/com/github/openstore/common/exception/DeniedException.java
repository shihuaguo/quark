package com.github.openstore.common.exception;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-25
 **/
public class DeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeniedException() {
    }

    public DeniedException(String message) {
        super(message);
    }

    public DeniedException(Throwable cause) {
        super(cause);
    }

    public DeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}