package com.crm.system.service.impl;

import com.crm.system.domain.Jobinfo;
import com.crm.system.mapper.JobinfoMapper;
import com.crm.system.service.JobRightService;
import com.crm.system.service.JobinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/8 14:48
 */
@Service
@Transactional
public class JobinfoServiceImpl implements JobinfoService {

    @Autowired
    private JobinfoMapper jobinfoMapper;
    @Autowired
    private JobRightService jobRightService;

    @Override
    public List<Jobinfo> queryList(Map<String, Object> map) {
        return jobinfoMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return jobinfoMapper.queryTotal(map);
    }

    @Override
    public void save(Jobinfo jobinfo) {
        jobinfoMapper.save(jobinfo);

        jobRightService.saveOrUpdate(jobinfo.getId(),jobinfo.getRightIdList());
    }

    @Override
    public void update(Jobinfo jobinfo) {

        jobinfoMapper.update(jobinfo);

        jobRightService.saveOrUpdate(jobinfo.getId(),jobinfo.getRightIdList());
    }

    @Override
    public void delete(Integer jobinfoid) {
        jobinfoMapper.delete(jobinfoid);
        jobRightService.delete(jobinfoid);
    }
}
