package com.crm.user.controller;

import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.user.domain.Employee;
import com.crm.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/2/28 15:23
 */
@RestController
@RequestMapping("user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "password")
    public String password(HttpSession session,String password,String newPassword) {
        Employee employee = (Employee)session.getAttribute("employee");
        Employee employee1=new Employee();
        employee1.setPassword(newPassword);
        employee1.setId(employee.getId());
        if(employee.getPassword().equals(password)){
            employeeService.update(employee1);
            return "1";
        }else{
            return "0";
        }
    }

    /**
     * 用户列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Employee> employeeList = employeeService.queryList(query);
        int total = employeeService.queryTotal(query);
        Result data = Result.ok().put("data", employeeList).put("count",total);
        return data;
    }

    @RequestMapping("/saleList")
    public Result saleList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        query.put("jobinfoid",8);
        List<Employee> employeeList = employeeService.queryList(query);
        int total = employeeService.queryTotal(query);
        Result data = Result.ok().put("data", employeeList).put("count",total);
        return data;
    }

    @RequestMapping("/consultList")
    public Result consultList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        query.put("jobinfoid",3);
        List<Employee> employeeList = employeeService.queryList(query);
        int total = employeeService.queryTotal(query);
        Result data = Result.ok().put("data", employeeList).put("count",total);
        return data;
    }

    @RequestMapping("/count")
    public Result count() {
        int count = employeeService.queryTotal(new HashMap<String, Object>());
        Result data = Result.ok().put("count",count);
        return data;
    }

    /**
     * 删除
     */
    @RequestMapping("/del")
    public Result delete(Employee employee){
        employee.setWorkstatu("0");
        employeeService.update(employee);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(Employee employee){
        employeeService.update(employee);
        return Result.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public Result save(Employee employee){
        employeeService.save(employee);
        return Result.ok();
    }
}
