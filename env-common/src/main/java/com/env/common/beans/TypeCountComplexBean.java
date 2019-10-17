package com.env.common.beans;

import com.env.common.constraint.QueryResultConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/19 8:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TypeCountComplexBean<T> extends TypeCountBean<T> implements QueryResultConstraint {
    private List<T> subDataList;

    public TypeCountComplexBean(List<T> subDataList) {
        this.subDataList = subDataList;
    }

    public TypeCountComplexBean(Long totalCount, List<T> subList) {
        super(totalCount);

        this.subDataList = subList;
    }
}
