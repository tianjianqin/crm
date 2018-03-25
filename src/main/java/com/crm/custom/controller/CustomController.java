package com.crm.custom.controller;

import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;
import com.crm.custom.service.CustomService;
import com.crm.user.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author tianjianqin
 * @date 2018/3/19 10:35
 */
@RestController
@RequestMapping("custom")
public class CustomController {

    @Autowired
    private CustomService customService;

    /**
     * 客户列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        if(employee.getJobinfoid()==5){
            query.put("invitename",employee.getRealname());
        }
        List<Custom> customList = customService.queryList(query);
        int total = customService.queryTotal(query);
        Result data = Result.ok().put("data", customList).put("count",total);
        return data;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Result delete(Integer id){
        customService.delete(id);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(Custom custom){
        customService.update(custom);
        return Result.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(Custom custom){
        customService.save(custom);
        return Result.ok();
    }


}
