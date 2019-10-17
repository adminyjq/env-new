package com.env.gateway.filters;

import com.alibaba.fastjson.JSON;
import com.env.common.beans.core.ResponseBean;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 9:37
 */
@Slf4j
public class DecorateExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER + 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        Throwable throwable = ctx.getThrowable();

        log.error("Exception Decorate: {}", throwable.getCause().getMessage());

        ResponseBean<Object> responseBean = new ResponseBean<>();
        responseBean.error();

        byte[] result = JSON.toJSONString(responseBean).getBytes(StandardCharsets.UTF_8);

        try {
            HttpServletResponse response = ctx.getResponse();

            response.getOutputStream().write(result);
            response.getOutputStream().flush();

        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);

            return null;
        }

        return null;
    }
}
