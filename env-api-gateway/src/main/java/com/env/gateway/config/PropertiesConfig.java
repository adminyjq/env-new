package com.env.gateway.config;

import com.env.gateway.config.properties.DecorateConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 18:34
 */
@Configuration
@EnableConfigurationProperties({DecorateConfigurationProperties.class})
public class PropertiesConfig {
}
