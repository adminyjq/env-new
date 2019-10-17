package com.env.task.context.api.controller;


import com.codingapi.tx.annotation.TxTransaction;
import com.env.common.beans.core.ResponseBean;
import com.env.common.constraint.mvc.ControllerConstraint;
import com.env.common.constraint.mvc.ControllerConstraintImpl;
import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.task.client.ITaskTestClient;
import com.env.task.context.entity.TaskTest;
import com.env.task.context.service.TaskTestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasktest")
public class TaskTestController
       extends ControllerConstraintImpl<TaskTest>
       implements ControllerConstraint<TaskTest> {

   @Autowired
   private ITaskTestClient iTaskTestClient;

   @Autowired
   private TaskTestService taskTestService;

    @Override
    protected ServiceConstraint<TaskTest> getService() {
        return taskTestService;
    }

    @GetMapping("/test02/{id1}/{id2}/{num}")
    @ApiOperation(value = "测试feign调用")
    @TxTransaction(isStart = true)
    @Transactional
    public ResponseBean test02(@PathVariable("id1")String id1,@PathVariable("id2")String id2,@PathVariable("num")Integer num){
        taskTestService.test01(id1,id2,num);
        return iTaskTestClient.test01(id2,num);
    }

}
