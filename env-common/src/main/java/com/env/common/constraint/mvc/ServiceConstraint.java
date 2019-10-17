package com.env.common.constraint.mvc;

import com.baomidou.mybatisplus.extension.service.IService;
import com.env.common.constraint.domain.BaseModel;

import java.util.List;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 14:34
 */
public interface ServiceConstraint<T extends BaseModel> extends IService<T> {

    List<T> list();

    int count();

    boolean exists(String id);
}
