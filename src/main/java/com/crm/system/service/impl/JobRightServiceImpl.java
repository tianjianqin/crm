package com.crm.system.service.impl;

import com.crm.system.domain.Jobright;
import com.crm.system.domain.JobrightExample;
import com.crm.system.domain.Rights;
import com.crm.system.mapper.JobrightMapper;
import com.crm.system.mapper.RightsMapper;
import com.crm.system.service.JobRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/13 16:43
 */
@Service
@Transactional
public class JobRightServiceImpl implements JobRightService{

    @Autowired
    private JobrightMapper jobrightMapper;
    @Autowired
    private RightsMapper rightsMapper;


    /**
     * 权限菜单（一级权限和二级权限）
     */
    @Override
    public List<Rights> findRightName(Integer jobInfoId) {
        JobrightExample jobrightExample = new JobrightExample();
        JobrightExample.Criteria criteria = jobrightExample.createCriteria();
        criteria.andJobinfoidEqualTo(jobInfoId);
        List<Jobright> jobrights = jobrightMapper.selectByExample(jobrightExample);
        List<Rights> rights = rightsMapper.batchSelectRights(jobrights);

        return rights;
    }

    @Override
    public List<Rights> queryList(Map<String, Object> map) {
        return rightsMapper.queryList(map);
    }

    @Override
    public void delete(Integer jobinfoid) {

        jobrightMapper.delete(jobinfoid);
    }

    @Override
    public void saveOrUpdate(Integer jobInfoId, List<Integer> rightIdList) {
        if(rightIdList.size() == 0){
            return ;
        }
        //先删除角色与菜单关系
        jobrightMapper.delete(jobInfoId);

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jobInfoId", jobInfoId);
        map.put("rightIdList", rightIdList);
        jobrightMapper.save(map);
    }

    @Override
    public List<Integer> queryRightIdList(Integer jobInfoId) {
        return jobrightMapper.queryRightIdList(jobInfoId);
    }
}
