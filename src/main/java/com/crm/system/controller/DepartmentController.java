package com.crm.system.controller;

import com.crm.system.domain.Department;
import com.crm.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/3/6 17:36
 */

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public List<Department> list(){
        List<Department> departmentList = departmentService.queryList(null);
        return departmentList;
    }

}
