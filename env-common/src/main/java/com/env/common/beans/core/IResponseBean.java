package com.env.common.beans.core;

import java.io.Serializable;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 10:15
 */
public interface IResponseBean<T> extends Serializable {

    IResponseBean success();

    IResponseBean success(T data);

    IResponseBean error();

    IResponseBean error(int statusCode);

    IResponseBean error(String message);

    IResponseBean error(int statusCode, String message);

    IResponseBean setData(T data);

    T getData();
}
