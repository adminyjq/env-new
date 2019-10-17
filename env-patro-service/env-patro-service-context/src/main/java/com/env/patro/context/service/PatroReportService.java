package com.env.patro.context.service;

import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.common.constraint.mvc.ServiceConstraintImpl;
import com.env.patro.context.entity.PatroReport;
import com.env.patro.context.mapper.PatroReportMapper;
import org.springframework.stereotype.Service;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 15:04
 */
@Service
public class PatroReportService
        extends ServiceConstraintImpl<PatroReportMapper, PatroReport>
        implements ServiceConstraint<PatroReport> {

}
