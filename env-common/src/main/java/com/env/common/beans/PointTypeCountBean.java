package com.env.common.beans;

import com.env.common.constraint.QueryResultConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/7/19 10:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PointTypeCountBean<T> extends TypeCountBean<T> implements QueryResultConstraint {

    private Double longitude;

    private Double latitude;

}
