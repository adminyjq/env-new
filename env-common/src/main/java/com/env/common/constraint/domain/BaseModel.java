package com.env.common.constraint.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 10:21
 */
@Data
public abstract class BaseModel implements ModelConstraint {

    public static final String CREATE_TIME_DB_FIELD = "create_time";

    @TableId(value = "id", type = IdType.UUID)
    protected String id;

    protected Date createTime;

    protected Date updateTime;

    protected String remark;

}
