package com.env.common.constraint;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 18:58
 */
@Data
@ApiModel("统计结果的抽象实体")
public abstract class StatisticResult implements QueryResultConstraint {
    protected Date startTime;
    protected Date endTime;
}
