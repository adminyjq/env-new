package com.env.common.constraint.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 14:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ImageModel extends BaseModel {

    protected String images;

}
