package com.env.task.context.dao.mapper;

import com.env.common.constraint.mvc.MapperConstraint;
import com.env.task.context.entity.TaskTest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskTestMapper extends MapperConstraint<TaskTest> {

}
