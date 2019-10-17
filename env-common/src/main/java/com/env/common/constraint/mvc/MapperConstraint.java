package com.env.common.constraint.mvc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.env.common.constraint.domain.BaseModel;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 14:28
 */
public interface MapperConstraint<T extends BaseModel> extends BaseMapper<T> {
}
