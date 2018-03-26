package com.crm.custom.controller;

import com.alibaba.fastjson.JSON;
import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;
import com.crm.custom.service.CustomService;
import com.crm.custom.service.CustominfoService;
import com.crm.user.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:26
 */
@RestController
@RequestMapping("custominfo")
public class CustominfoController {

    @Autowired
    private CustomService customService;
    @Autowired
    private CustominfoService custominfoService;


    /**
     * 客户开发列表
     * @param params
     * @param session
     * @return
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params,HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        query.put("followmanid",employee.getId());
        List<Custominfo> custominfoList = custominfoService.queryList(query);
        int total = custominfoService.queryTotal(query);
        Result data = Result.ok().put("data", custominfoList).put("count",total);
        return data;
    }

    @RequestMapping("/allList")
    public Result allList(@RequestParam Map<String, Object> params,HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        query.put("departmentid",employee.getDepartmentid());
        List<Custominfo> custominfoList = custominfoService.queryList(query);
        int total = custominfoService.queryTotal(query);
        Result data = Result.ok().put("data", custominfoList).put("count",total);
        return data;
    }

    /**
     * 修改客户开发信息
     * @return
     */
    @RequestMapping("/update")
    public Result update(Custominfo custominfo){
        custominfoService.update(custominfo);
        return Result.ok();
    }
    /**
     * 分配客户
     */
    @RequestMapping("/distributeSale")
    public Result distributeSale(Integer[] idList){
        String msg=null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customstatu",0);//0 状态为未上门
        List<Custom> customList = customService.queryList(map);
        if(!customList.isEmpty()){
            List<Custominfo> custominfoList=new ArrayList<Custominfo>();
            List<Custom> newCustomList=new ArrayList<Custom>();
            for(Custom custom1:customList){
                custom1.setCustomstatu("2");
                newCustomList.add(custom1);
            }
            for(int i=0;i<customList.size();i++){
                for(int j=0;j<idList.length;j++){
                    Custominfo custominfo=new Custominfo();
                    custominfo.setStartdate(new Date());
                    custominfo.setStatu("0");
                    if(customList.size()!=0) {//判断数组是否为0,否则会出现数组下标越界异常
                        custominfo.setCustomid(customList.get(i).getId());
                        custominfo.setFollowmanid(idList[j]);
                        custominfoList.add(custominfo);
                        customList.remove(customList.get(i));
                    }
                }
                i--;
            }
            custominfoService.saveOrUpdate(newCustomList,custominfoList);
            msg = "分配成功！";
        }else{
            msg = "没有可分配的客户";
        }
        return Result.ok().put("msg",msg);
    }
}
