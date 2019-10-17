package com.env.patro.client;

import com.env.common.config.BaseFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.env.common.constants.cloud.ServiceNameConstants.API_PATRO_SERVICE_NAME;

@FeignClient(name = API_PATRO_SERVICE_NAME, configuration = BaseFeignConfiguration.class)
public interface IPatroReportClient {

    @GetMapping("/report/generate/{max}/{min}")
    List<Integer> generateList(@PathVariable("max") Integer max, @PathVariable(value = "min", required = false) Integer min);


}
