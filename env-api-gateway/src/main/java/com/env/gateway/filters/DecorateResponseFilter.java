package com.env.gateway.filters;

import com.alibaba.fastjson.JSONObject;
import com.env.common.beans.core.ResponseBean;
import com.env.gateway.config.properties.DecorateConfigurationProperties;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.PathMatcher;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import static com.env.gateway.utils.ResponseUtils.buildResponseDataStream;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 14:08
 */
@Slf4j
@ConditionalOnBean(DecorateConfigurationProperties.class)
public class DecorateResponseFilter extends ZuulFilter {

    @Autowired
    private DecorateConfigurationProperties properties;

    @Autowired
    private PathMatcher pathMatcher;

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 10;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();

        int statusCode = response.getStatus();

        if (shouldFilterStatusCode(statusCode) && shouldFilterContentType()) {
            String requestURI = (String) ctx.get("requestURI");

            for (String ignoredUris : properties.getIgnoredUris()) {
                if (pathMatcher.match(ignoredUris, requestURI)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        if (Objects.isNull(ctx.getResponseDataStream())) {
            return null;
        }

        String originalData = getOriginalUTF8Data(ctx);

        ResponseBean<Object> responseBean = new ResponseBean<>();

        if (StringUtils.isEmpty(originalData)) {
            responseBean.success();
            ctx.setResponseDataStream(buildResponseDataStream(responseBean));

            return null;
        }

        String originalContentType = getOriginalContentType();

        if (StringUtils.startsWith(originalContentType, MediaType.TEXT_PLAIN_VALUE)) {
            responseBean.success(originalData);

            ctx.setResponseDataStream(buildResponseDataStream(responseBean));

            return null;
        }

        if (StringUtils.startsWith(originalData, "[") && StringUtils.endsWith(originalData, "]")) {
            responseBean.success(JSONObject.parseArray(originalData));

            ctx.setResponseDataStream(buildResponseDataStream(responseBean));

            return null;
        }

        responseBean.success(JSONObject.parseObject(originalData));

        ctx.setResponseDataStream(buildResponseDataStream(responseBean));

        return null;
    }

    private String getOriginalUTF8Data(RequestContext ctx) {
        try {
            return StreamUtils.copyToString(ctx.getResponseDataStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);

            return null;
        }
    }

    private boolean shouldFilterStatusCode(int statusCode) {
        return HttpStatus.OK.value() == statusCode;
    }

    private boolean shouldFilterContentType() {
        String contentType = getOriginalContentType();

        return properties.getShouldFilterContentType().contains(contentType) || Objects.isNull(contentType);
    }

    private String getOriginalContentType() {
        return findOriginalHeaderValue(CONTENT_TYPE);
    }

    private String findOriginalHeaderValue(String headerName) {
        RequestContext ctx = RequestContext.getCurrentContext();
        List<Pair<String, String>> originResponseHeaders = ctx.getOriginResponseHeaders();

        return originResponseHeaders.stream()
                .filter(pair -> StringUtils.equals(pair.first(), headerName))
                .map(Pair::second)
                .findFirst()
                .orElse(null);
    }
}
