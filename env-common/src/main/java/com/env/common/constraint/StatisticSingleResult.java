package com.env.common.constraint;

import com.env.common.utils.DateUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Objects;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/05/09 10:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("统计的单结果返回实体")
public class StatisticSingleResult<T> extends StatisticResult implements QueryResultConstraint {

    private T data;

    public StatisticSingleResult() {
    }

    public StatisticSingleResult(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public StatisticSingleResult(T data, Date startTime, Date endTime) {
        this.data = data;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public StatisticSingleResult(DateUtil.StartToEndTimeBean timeBean) {
        Objects.requireNonNull(timeBean, "timeBean");

        this.startTime = timeBean.getStartTime();
        this.endTime = timeBean.getEndTime();
    }
}
