package com.env.task.context;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableFeignClients(basePackages = {"com.env.task.client"})
@ComponentScans(
        {
                @ComponentScan(basePackages = {"com.env.common.**.config"}),
                @ComponentScan(basePackages = {"com.env.task.context.api.client.fallback"})
        }
)
@SpringCloudApplication
public class TaskServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class);
    }
}
