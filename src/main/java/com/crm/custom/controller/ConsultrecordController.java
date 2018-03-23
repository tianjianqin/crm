package com.crm.custom.controller;

import com.crm.base.utils.Result;
import com.crm.custom.domain.Consultrecord;
import com.crm.custom.domain.Custom;
import com.crm.custom.mapper.ConsultrecordMapper;
import com.crm.custom.service.ConsultrecordService;
import com.crm.custom.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author tianjianqin
 * @date 2018/3/22 15:41
 */
@RestController
@RequestMapping("consultrecord")
public class ConsultrecordController {

    @Autowired
    private CustomService customService;
    @Autowired
    private ConsultrecordService consultrecordService;

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
}
