package com.env.common.constraint;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 18:56
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础的查询的实体
 *
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 18:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("基础的查询的实体")
public class ConditionalSearch extends Conditional implements ConditionalConstraint {
    /**
     * 分页参数：页索引
     */
    @ApiModelProperty("分页参数：页索引")
    private Integer pageNum = 1;

    /**
     * 分页参数：页大小
     */
    @ApiModelProperty("分页参数：页大小")
    private Integer pageSize = 10;
}
