package com.env.task.context.service;


import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.common.constraint.mvc.ServiceConstraintImpl;
import com.env.task.context.dao.mapper.TaskTestMapper;
import com.env.task.context.entity.TaskTest;

public interface TaskTestService

        extends ServiceConstraint<TaskTest>{


    public void test01(String id1, String id2, Integer num);
}
