package com.env.patrol.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/9/18 17:22
 */
@Data
public class PatrolReportVo implements Serializable {

    private String id;

    private String nickname;

    protected Date createTime;

    protected Date updateTime;

    private String remark;

}
