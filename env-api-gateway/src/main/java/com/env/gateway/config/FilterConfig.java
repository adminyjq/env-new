package com.env.gateway.config;

import com.env.gateway.filters.DecorateExceptionFilter;
import com.env.gateway.filters.DecorateResponseFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/28 18:34
 */
@Configuration
public class FilterConfig {

    @Bean
    public DecorateResponseFilter decorateResponseFilter(){
        return new DecorateResponseFilter();
    }

    @Bean
    public DecorateExceptionFilter decorateExceptionFilter(){
        return new DecorateExceptionFilter();
    }

}
