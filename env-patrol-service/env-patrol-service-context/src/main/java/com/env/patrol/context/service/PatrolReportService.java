package com.env.patrol.context.service;

import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.common.constraint.mvc.ServiceConstraintImpl;
import com.env.patrol.context.dao.mapper.PatrolReportMapper;
import com.env.patrol.context.entity.PatrolReport;
import org.springframework.stereotype.Service;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 15:04
 */
@Service
public class PatrolReportService
        extends ServiceConstraintImpl<PatrolReportMapper, PatrolReport>
        implements ServiceConstraint<PatrolReport> {

}
