package com.env.common.utils;

import com.env.common.constraint.EnumConstraint;
import com.env.common.utils.function.TernaryFunction;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/07/16 15:43
 */
public enum TimeUnit implements EnumConstraint {
    /**
     * 秒
     */
    SECOND("秒", DateUtil::getAllSecondStartToEndTime),
    /**
     * 分钟
     */
    MINUTE("分钟", DateUtil::getAllMinuteStartToEndTime),
    /**
     * 小时
     */
    HOUR("小时", DateUtil::getAllHourStartToEndTime),
    /**
     * 天
     */
    DAY("天", DateUtil::getAllDayStartToEndTime),
    /**
     * 月
     */
    MONTH("月", DateUtil::getAllMonthStartToEndTime),
    /**
     * 年
     */
    YEAR("年", DateUtil::getAllYearStartToEndTime);

    private final String enumItemLabel;

    private final TernaryFunction<Date, Date, Integer, List<DateUtil.StartToEndTimeBean>> method;

    TimeUnit(String enumItemLabel, TernaryFunction<Date, Date, Integer, List<DateUtil.StartToEndTimeBean>> method) {
        this.enumItemLabel = enumItemLabel;
        this.method = method;
    }

    public List<DateUtil.StartToEndTimeBean> allStartToEndTime(Date startTime, Date endTime) {
        return allStartToEndTime(startTime, endTime, null);
    }

    public List<DateUtil.StartToEndTimeBean> allStartToEndTime(Date startTime, Date endTime, Integer duration) {
        checkoutInParameters(startTime, endTime);

        return method.apply(startTime, endTime, duration);
    }

    private void checkoutInParameters(Date startTime, Date endTime) {
        Objects.requireNonNull(startTime, "startTime must be not null");
        Objects.requireNonNull(endTime, "endTime must be not null");
    }

    @Override
    public String enumTypeLabel() {
        return "时间统计单位";
    }

    @Override
    public String enumItemLabel() {
        return enumItemLabel;
    }
}
