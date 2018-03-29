package com.crm.custom.controller;

import com.crm.base.utils.Query;
import com.crm.base.utils.Result;
import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.Custom;
import com.crm.custom.mapper.ConsultrecordMapper;
import com.crm.custom.service.ConsultrecordService;
import com.crm.custom.service.CustomService;
import com.crm.user.domain.Employee;
import com.crm.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:41
 */
@RestController
@RequestMapping("consultrecord")
public class ConsultrecordController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomService customService;
    @Autowired
    private ConsultrecordService consultrecordService;


    /**
     * 客户咨询列表
     * @param params
     * @param session
     * @return
     */
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        query.put("consultmanid",employee.getId());
        List<Consultrecord> consultrecordList = consultrecordService.queryList(query);
        int total = consultrecordService.queryTotal(query);
        Result data = Result.ok().put("data", consultrecordList).put("count",total);
        return data;
    }


    /**
     * 查询今日数据信息
     * @param params
     * @param session
     * @return
     */
    @RequestMapping("/todayList")
    public Result todayList(@RequestParam Map<String, Object> params,HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String consultdate = sdf.format(new Date());
        query.put("consultdate",consultdate);
        if(employee.getJobinfoid()==3){
            query.put("consultmanid",employee.getId());
        }else{
            query.put("departmentid",employee.getDepartmentid());
        }
        List<Consultrecord> consultrecordList = consultrecordService.queryList(query);
        int total = consultrecordService.queryTotal(query);
        Result data = Result.ok().put("data", consultrecordList).put("count",total);
        return data;
    }

    /**
     * 查询历史数据信息
     * @param params
     * @param session
     * @return
     */
    @RequestMapping("/historyList")
    public Result historyList(@RequestParam Map<String, Object> params,HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String consultdate = sdf.format(new Date());
        query.put("consultdate",consultdate);
        query.put("consultstatu","3");
        if(employee.getJobinfoid()==3){
            query.put("consultmanid",employee.getId());
        }else{
            query.put("departmentid",employee.getDepartmentid());
        }
        List<Consultrecord> consultrecordList = consultrecordService.queryHistory(query);
        int total = consultrecordService.queryHistoryTotal(query);
        Result data = Result.ok().put("data", consultrecordList).put("count",total);
        return data;
    }


    /**
     * 查询本月的数据信息
     * @param params
     * @param session
     * @return
     */
    @RequestMapping("/monthList")
    public Result monthList(@RequestParam Map<String, Object> params,HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        Query query = new Query(params);
        if(employee.getJobinfoid()==3){
            query.put("consultmanid",employee.getId());
        }else{
            query.put("departmentid",employee.getDepartmentid());
        }
        List<Consultrecord> consultrecordList = consultrecordService.queryMonth(query);
        int total = consultrecordService.queryMonthTotal(query);
        Result data = Result.ok().put("data", consultrecordList).put("count",total);
        return data;
    }

    /**
     * 修改客户开发信息
     * @return
     */
    @RequestMapping("/update")
    public Result update(Consultrecord consultrecord){
        consultrecordService.update(consultrecord);
        return Result.ok();
    }

    /**
     * 分配客户
     */
    @RequestMapping("/distributeConsult")
    public Result distributeConsult(Integer[] idList){
        String msg=null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customstatu",1);//0 状态为已上门
        List<Custom> customList = customService.queryList(map);
        if(!customList.isEmpty()){
            List<Consultrecord> consultrecordList=new ArrayList<Consultrecord>();
            List<Custom> newCustomList=new ArrayList<Custom>();
            for(Custom custom1:customList){
                custom1.setCustomstatu("3");
                newCustomList.add(custom1);
            }
            for(int i=0;i<customList.size();i++){
                for(int j=0;j<idList.length;j++){
                    Consultrecord consultrecord = new Consultrecord();
                    consultrecord.setConsultdate(new Date());
                    consultrecord.setConsultstatu("0");
                    if(customList.size()!=0){//判断数组是否为0,否则会出现数组下标越界异常
                        consultrecord.setCustomid(customList.get(i).getId());
                        consultrecord.setConsultmanid(idList[j]);
                        consultrecordList.add(consultrecord);
                        customList.remove(customList.get(i));
                    }
                }
                i--;
            }
            consultrecordService.saveOrUpdate(newCustomList,consultrecordList);
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
        int newMonthData = 0;
        Map<String, Object> map1 = new HashMap<String, Object>();
        if(employee.getJobinfoid()==3){
            map1.put("id",employee.getId());
        }else{
            map1.put("departmentid",employee.getDepartmentid());
        }
        List<Employee> employeeList = employeeService.queryList(map1);
        for (Employee e:employeeList){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("consultmanid",e.getId());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String consultdate = sdf.format(new Date());
            params.put("consultdate",consultdate);
            //本月统计
            int monthData = consultrecordService.queryMonthTotal(params);
            newMonthData=newMonthData+monthData;
            //今日统计
            int todayData = consultrecordService.queryTotal(params);
            newTodayDate=newTodayDate+todayData;
            //历史遗留
            params.put("consultstatu","3");
            int historyData = consultrecordService.queryHistoryTotal(params);
            newHistoryData=newHistoryData+historyData;
        }
        return Result.ok().put("todayData",newTodayDate).put("historyData",newHistoryData).put("monthData",newMonthData);
    }

    /**
     * 获得统计数据到饼状图
     */
    @RequestMapping("/getPieData")
    public Object getPieData(HttpSession session){
        Result result = getTotal(session);
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
        map.put("value", result.get("todayData"));
        seriesData.add(map);
        // 第2组数据
        map = new HashMap<String, Object>();
        map.put("name", "历史遗留");
        map.put("value", result.get("historyData"));
        seriesData.add(map);
        // 第3组数据
        map = new HashMap<String, Object>();
        map.put("name", "本月统计");
        map.put("value", result.get("monthData"));
        seriesData.add(map);

        // 将seriesData数据放入map
        returnMap.put("seriesData", seriesData);
        return returnMap;
    }
}
