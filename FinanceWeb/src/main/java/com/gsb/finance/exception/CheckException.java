package com.gsb.finance.exception;

/**
 * Created by IntelliJ IDEA.
 * User: guoshubo
 * Date: 2017/10/18
 * Time: 11:40
 * Description£º
 */
public class CheckException extends RuntimeException {
    private static final long serialVersionUID = -4083687700337386905L;

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
