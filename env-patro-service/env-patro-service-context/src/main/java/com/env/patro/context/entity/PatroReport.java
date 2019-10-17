package com.env.patro.context.entity;

import com.env.common.constraint.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 13:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PatroReport extends BaseModel {

    private String nickname;

    private String count;

}
