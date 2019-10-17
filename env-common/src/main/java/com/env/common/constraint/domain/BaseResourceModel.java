package com.env.common.constraint.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图片与视频的抽象 Model
 *
 * @author Linshu 745698872@qq.com
 * @date 2019/10/9 14:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseResourceModel extends BaseModel {

    protected String images;

    protected String videos;

}
