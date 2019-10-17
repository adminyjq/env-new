package com.env.patrol.context;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 16:40
 */
@EnableFeignClients(basePackages = {"com.env.patrol.context.api.client"})
@ComponentScans(
        {
                @ComponentScan(basePackages = {"com.env.common.**.config"}),
                @ComponentScan(basePackages = {"com.env.patrol.context.api.client.fallback"})
        }
)
@SpringCloudApplication
public class PatrolServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatrolServiceApplication.class);
    }
}
