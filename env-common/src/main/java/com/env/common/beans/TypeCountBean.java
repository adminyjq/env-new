package com.env.common.beans;

import com.env.common.constraint.EnumConstraint;
import com.env.common.constraint.QueryResultConstraint;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/07/11 14:37
 */
@Data
@Accessors(chain = true)
public class TypeCountBean<T> implements QueryResultConstraint {

    protected String type;
    protected String typeName;
    protected Long count;

    public TypeCountBean() {
    }

    public TypeCountBean(Long count) {
        count = Objects.requireNonNullElse(count, 0L);

        this.count = count;
    }

    public TypeCountBean(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public TypeCountBean(EnumConstraint constraint) {
        if (Objects.isNull(constraint)) {
            throw new IllegalArgumentException("constraint");
        }

        this.type = constraint.enumItemName();
        this.typeName = constraint.enumItemLabel();
    }

    public TypeCountBean(EnumConstraint constraint, Long count) {
        if (Objects.isNull(constraint)) {
            throw new IllegalArgumentException("constraint");
        }

        count = Objects.requireNonNullElse(count, 0L);

        this.type = constraint.enumItemName();
        this.typeName = constraint.enumItemLabel();
        this.count = count;
    }

    public boolean greaterThanZero() {
        return this.count > 0;
    }

}
