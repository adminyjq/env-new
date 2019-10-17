package com.env.gateway.utils;

import com.alibaba.fastjson.JSON;
import com.env.common.beans.core.IResponseBean;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/29 16:25
 */
public class ResponseUtils {

    public static ByteArrayInputStream buildResponseDataStream(IResponseBean<Object> responseBean) {
        String resultJson = JSON.toJSONString(responseBean);
        byte[] result = resultJson.getBytes(StandardCharsets.UTF_8);

        return new ByteArrayInputStream(result);
    }

}
