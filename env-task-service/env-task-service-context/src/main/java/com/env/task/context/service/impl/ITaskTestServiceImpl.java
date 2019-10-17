package com.env.task.context.service.impl;

//import com.codingapi.tx.annotation.TxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.env.common.constraint.mvc.ServiceConstraintImpl;
import com.env.task.client.ITaskTestClient;
import com.env.task.context.dao.mapper.TaskTestMapper;
import com.env.task.context.entity.TaskTest;
import com.env.task.context.service.TaskTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ITaskTestServiceImpl  extends ServiceConstraintImpl<TaskTestMapper, TaskTest>
       implements TaskTestService {



    @Override
    public void test01(String id1, String id2, Integer num) {
        TaskTest taskTest = getById(id1);
        taskTest.setCount(taskTest.getCount()-num);
        updateById(taskTest);
        System.out.println("执行第一个模块完毕");
        //iTaskTestClient.test01(id2,num);
    }
}
