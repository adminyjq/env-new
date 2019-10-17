package com.env.task.context.entity;

import com.env.common.constraint.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskTest extends BaseModel {

    private Integer count;

}

