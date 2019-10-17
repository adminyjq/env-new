package com.env.common.beans.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.env.common.constants.Constants.ResponseStatus.ERROR;
import static com.env.common.constants.Constants.ResponseStatus.SUCCESS;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 10:05
 */
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseBean<T> implements IResponseBean<T> {
    private int code;

    private String message;

    private T data;

    @Override
    public IResponseBean<T> success() {
        this.code = SUCCESS.getStatusCode();
        this.message = SUCCESS.getMessage();

        return this;
    }

    @Override
    public IResponseBean<T> success(T data) {
        this.code = SUCCESS.getStatusCode();
        this.message = SUCCESS.getMessage();
        setData(data);

        return this;
    }

    @Override
    public IResponseBean<T> error() {
        this.code = ERROR.getStatusCode();
        this.message = ERROR.getMessage();

        return this;
    }

    @Override
    public IResponseBean<T> error(int statusCode) {
        this.code = statusCode;
        this.message = ERROR.getMessage();

        return this;
    }

    @Override
    public IResponseBean<T> error(String message) {
        this.code = ERROR.getStatusCode();
        this.message = message;

        return this;
    }

    @Override
    public IResponseBean<T> error(int statusCode, String message) {
        this.code = statusCode;
        this.message = message;

        return this;
    }
}
