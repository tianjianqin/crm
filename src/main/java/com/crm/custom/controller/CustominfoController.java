package com.crm.custom.controller;

import com.alibaba.fastjson.JSON;
import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.custom.domain.Custom;
import com.crm.custom.domain.Custominfo;
import com.crm.custom.service.CustomService;
import com.crm.custom.service.CustominfoService;
import com.crm.user.domain.Employee;
import com.crm.user.service.EmployeeService;
import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:26
 */
@RestController
@RequestMapping("custominfo")
public class CustominfoController {

    @Autowired
    private EmployeeService employeeService;
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

    /**
     * 获得统计数据
     */
    @RequestMapping("/getTotal")
    public Result getTotal(HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        int newTodayDate = 0;
        int newHistoryData = 0;
        int newAppointData =0;
        int newMonthData = 0;
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("departmentid",employee.getDepartmentid());
        List<Employee> employeeList = employeeService.queryList(map1);
        for (Employee e:employeeList){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("followmanid",e.getId());
            //本月统计
            int monthData = custominfoService.queryMonthTotal(params);
            newMonthData=newMonthData+monthData;

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startdate = sdf.format(date);
            params.put("startdate",startdate);
            //今日统计
            int todayData = custominfoService.queryTotal(params);
            newTodayDate=newTodayDate+todayData;
            //历史遗留
            int historyData = custominfoService.queryHistoryTotal(params);
            newHistoryData=newHistoryData+historyData;
            //诺在今日
            Map<String, Object> query = new HashMap<String, Object>();
            query.put("followmanid",employee.getId());
            query.put("plandate",startdate);
            int appointData = custominfoService.queryHistoryTotal(query);
            newAppointData=newAppointData+appointData;
        }
        return Result.ok().put("todayData",newTodayDate).put("historyData",newHistoryData).put("appointData",newAppointData).put("monthData",newMonthData);
    }

    /**
     * 获得统计数据到饼状图
     */
    @RequestMapping("/getPieData")
    public Object getPieData(HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        int newTodayDate = 0;
        int newHistoryData = 0;
        int newAppointData =0;
        int newMonthData = 0;
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("departmentid",employee.getDepartmentid());
        List<Employee> employeeList = employeeService.queryList(map1);
        for (Employee e:employeeList){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("followmanid",e.getId());
            //本月统计
            int monthData = custominfoService.queryMonthTotal(params);
            newMonthData=newMonthData+monthData;

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startdate = sdf.format(date);
            params.put("startdate",startdate);
            //今日统计
            int todayData = custominfoService.queryTotal(params);
            newTodayDate=newTodayDate+todayData;
            //历史遗留
            int historyData = custominfoService.queryHistoryTotal(params);
            newHistoryData=newHistoryData+historyData;
            //诺在今日
            Map<String, Object> query = new HashMap<String, Object>();
            query.put("followmanid",employee.getId());
            query.put("plandate",startdate);
            int appointData = custominfoService.queryHistoryTotal(query);
            newAppointData=newAppointData+appointData;
        }
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<String> legendData = new ArrayList<String>();
        legendData.add("今日数据");
        legendData.add("历史遗留");
        legendData.add("诺在今日");
        legendData.add("本月统计");
        returnMap.put("legendData", legendData);
        // seriesData list 中存放的map数据
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> seriesData = new ArrayList<Map<String, Object>>();
        // 第一组数据
        map.put("name", "今日数据");
        map.put("value", newTodayDate);
        seriesData.add(map);
        // 第2组数据
        map = new HashMap<String, Object>();
        map.put("name", "历史遗留");
        map.put("value", newHistoryData);
        seriesData.add(map);
        // 第3组数据
        map = new HashMap<String, Object>();
        map.put("name", "诺在今日");
        map.put("value", newAppointData);
        seriesData.add(map);
        // 第4组数据
        map = new HashMap<String, Object>();
        map.put("name", "本月统计");
        map.put("value", newMonthData);
        seriesData.add(map);

        // 讲seriesData数据放入map
        returnMap.put("seriesData", seriesData);
        return returnMap;
    }
}
