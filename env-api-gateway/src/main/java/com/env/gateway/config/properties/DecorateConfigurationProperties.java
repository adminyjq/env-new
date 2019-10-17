package com.env.gateway.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 17:23
 */
@Data
@RefreshScope
@ConfigurationProperties("decorate")
public class DecorateConfigurationProperties {

    private List<String> ignoredUris;

    private List<String> shouldFilterContentType;

    private String responseDataPlaceholder;

}
