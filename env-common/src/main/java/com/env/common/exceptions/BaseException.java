package com.env.common.exceptions;

import lombok.Getter;

import static com.env.common.constants.Constants.ResponseStatus.ERROR;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 13:49
 */
@Getter
public class BaseException extends RuntimeException {
    private final int statusCode;

    public BaseException(String message) {
        super(message);
        this.statusCode = ERROR.getStatusCode();
    }

    public BaseException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
