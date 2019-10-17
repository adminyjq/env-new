package com.env.task.client;

import com.env.common.beans.core.ResponseBean;
import com.env.common.config.BaseFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.env.common.constants.cloud.ServiceNameConstants.API_PATROL_SERVICE_NAME;
import static com.env.common.constants.cloud.ServiceNameConstants.API_TASK_SERVICE_NAME;


@FeignClient(name = API_PATROL_SERVICE_NAME, path = "/report",configuration = BaseFeignConfiguration.class)
@Component
public interface ITaskTestClient {

    @GetMapping("/test01/{id}/{num}")
    ResponseBean test01(@PathVariable("id")String id,@PathVariable("num")Integer num);

}
