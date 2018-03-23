package com.crm.system.controller;

import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.system.domain.Jobinfo;
import com.crm.system.service.JobRightService;
import com.crm.system.service.JobinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/8 14:50
 */
@RestController
@RequestMapping("jobinfo")
public class JobinfoController {

    @Autowired
    private JobinfoService jobinfoService;
    @Autowired
    private JobRightService jobRightService;

    @RequestMapping("/list")
    public List<Jobinfo> list(@RequestParam Map<String, Object> params){
        List<Jobinfo> jobinfoList = jobinfoService.queryList(params);
        return jobinfoList;
    }

    @RequestMapping("/job")
    public Result job(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Jobinfo> JobinfoList = jobinfoService.queryList(query);
        int total = jobinfoService.queryTotal(query);
        return Result.ok().put("data", JobinfoList).put("count",total);
    }

    /**
     * 保存职位
     */
    @RequestMapping("/save")
    public Result save(String job,Integer departmentid,Integer[] rightIdList){
        List<Integer> rightIdList1 = new ArrayList<Integer>();
        Collections.addAll(rightIdList1,rightIdList);
        Jobinfo jobinfo = new Jobinfo();
        jobinfo.setJob(job);
        jobinfo.setDepartmentid(departmentid);
        jobinfo.setRightIdList(rightIdList1);
        jobinfoService.save(jobinfo);

        return Result.ok();
    }

    /**
     * 修改职位
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Jobinfo jobinfo){
        jobinfoService.update(jobinfo);

        return Result.ok();
    }

    /**
     * 删除职位
     */
    @RequestMapping("/delete")
    public Result delete(Integer id){
        jobinfoService.delete(id);
        return Result.ok();
    }
}
