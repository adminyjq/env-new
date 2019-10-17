package com.env.common.constraint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 查询的抽象实体
 *
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 18:47
 */
@Data
@ApiModel("查询的抽象实体")
public class Conditional implements ConditionalConstraint {

    /**
     * 统计的开始时间
     */
    @ApiModelProperty("查询开始时间")
    protected Date startTime;

    /**
     * 统计的结束时间
     */
    @ApiModelProperty("查询结束时间")
    protected Date endTime;
}
