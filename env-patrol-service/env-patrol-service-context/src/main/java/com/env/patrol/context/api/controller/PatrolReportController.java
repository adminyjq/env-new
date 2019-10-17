package com.env.patrol.context.api.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.env.common.beans.core.ResponseBean;
import com.env.common.constraint.mvc.ControllerConstraint;
import com.env.common.constraint.mvc.ControllerConstraintImpl;
import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.patrol.context.entity.PatrolReport;
import com.env.patrol.context.service.PatrolReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.method.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Linshu 745698872@qq.com
 * @date 2019/10/10 14:49
 */
@RestController
@RequestMapping("/report")
public class PatrolReportController
        extends ControllerConstraintImpl<PatrolReport>
        implements ControllerConstraint<PatrolReport> {

    @Autowired
    private PatrolReportService service;

    @Override
    protected ServiceConstraint<PatrolReport> getService() {
        return service;
    }

    @GetMapping("/test01/{id}/{num}")
    @ApiOperation(value = "被调用方")
    @TxTransaction
    @Transactional
    public ResponseBean test01(@PathVariable("id") String id, @PathVariable("num") Integer num){
        PatrolReport patrolReport = service.getById(id);
        patrolReport.setCount(patrolReport.getCount()+num);
        boolean b = service.updateById(patrolReport);
        return new ResponseBean().setData(b);
    }

}
