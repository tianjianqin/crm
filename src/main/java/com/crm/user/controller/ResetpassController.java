package com.crm.user.controller;

import com.crm.base.utils.Result;
import com.crm.user.domain.Employee;
import com.crm.user.service.ResetpassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianjianqin
 * @date 2018/3/19 16:18
 */
@RestController
@RequestMapping("resetpass")
public class ResetpassController {

    @Autowired
    private ResetpassService resetpassService;

    /**
     * 保存
     * @param employee
     * @return
     */
    @RequestMapping("save")
    public Result save(Employee employee){
        employee.setPassword("888888");
        resetpassService.save(employee);
        return Result.ok();
    }
}
