package com.env.patro.context.api.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.env.common.beans.core.ResponseBean;
import com.env.common.constraint.mvc.ControllerConstraint;
import com.env.common.constraint.mvc.ControllerConstraintImpl;
import com.env.common.constraint.mvc.ServiceConstraint;
import com.env.patro.context.entity.PatroReport;
import com.env.patro.context.service.PatroReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PatroReportController
        extends ControllerConstraintImpl<PatroReport>
        implements ControllerConstraint<PatroReport> {

    @Autowired
    private PatroReportService service;

    @Override
    protected ServiceConstraint<PatroReport> getService() {
        return service;
    }

    @GetMapping("/test01/{id}/{num}")
    @ApiOperation(value = "被调用方")
    @Transactional
    @TxTransaction
    public ResponseBean test01(@PathVariable("id") String id, @PathVariable("num") Integer num){
        System.out.println("patro服务被调用");
        PatroReport patroReport = service.getById(id);
        patroReport.setCount(patroReport.getCount()+num);
        boolean b = service.updateById(patroReport);
        return new ResponseBean().setData(b);
    }

}
