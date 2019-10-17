package com.env.common.constraint;

import com.env.common.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/05/09 10:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("统计的多结果返回实体")
public class StatisticManyResult<T> extends StatisticResult implements QueryResultConstraint {

    private List<T> data;

    private Date startTime;
    private Date endTime;

    public StatisticManyResult() {
    }

    public StatisticManyResult(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public StatisticManyResult(List<T> data, Date startTime, Date endTime) {
        this.data = data;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public StatisticManyResult(DateUtil.StartToEndTimeBean time) {
        Objects.requireNonNull(time, "time");

        this.startTime = time.getStartTime();
        this.endTime = time.getEndTime();
    }
}
