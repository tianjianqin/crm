package com.crm.system.controller;

import com.crm.base.utils.Result;
import com.crm.system.domain.Rights;
import com.crm.system.service.JobRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author tianjianqin
 * @date 2018/3/13 16:50
 */
@RestController
@RequestMapping("jobright")
public class JobRightController {

    @Autowired
    private JobRightService jobRightService;

    @RequestMapping("/info/{jobinfoid}")
    public List<Integer> info(@PathVariable("jobinfoid") Integer jobinfoid){

        List<Integer> rightIdList = jobRightService.queryRightIdList(jobinfoid);

        return rightIdList;
    }

    @RequestMapping("/list")
    public Result list(){
        List<Rights> rightsList = jobRightService.queryList(new HashMap<String, Object>());
        return Result.ok().put("rightsList",rightsList);
    }
}
