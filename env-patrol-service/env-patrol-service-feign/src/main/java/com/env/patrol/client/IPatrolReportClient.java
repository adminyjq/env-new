package com.env.patrol.client;

import com.env.common.config.BaseFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.env.common.constants.cloud.ServiceNameConstants.API_PATROL_SERVICE_NAME;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 16:44
 */
@FeignClient(name = API_PATROL_SERVICE_NAME, configuration = BaseFeignConfiguration.class)
public interface IPatrolReportClient {

    @GetMapping("/report/generate/{max}/{min}")
    List<Integer> generateList(@PathVariable("max") Integer max, @PathVariable(value = "min", required = false) Integer min);


}
