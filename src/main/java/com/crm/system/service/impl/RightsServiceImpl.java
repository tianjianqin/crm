package com.crm.system.service.impl;

import com.crm.system.domain.Jobright;
import com.crm.system.domain.JobrightExample;
import com.crm.system.domain.Rights;
import com.crm.system.mapper.JobrightMapper;
import com.crm.system.mapper.RightsMapper;
import com.crm.system.service.JobRightService;
import com.crm.system.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/2/27 16:07
 */
@Service
@Transactional
public class RightsServiceImpl implements RightsService {
    @Autowired
    private RightsMapper rightsMapper;


}
