package com.crm.custom.service.impl;

import com.crm.custom.domain.Custom;
import com.crm.custom.mapper.CustomMapper;
import com.crm.custom.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/19 10:28
 */
@Service
@Transactional
public class CustomServiceImpl implements CustomService {

    @Autowired
    private CustomMapper customMapper;

    @Override
    public List<Custom> queryList(Map<String, Object> map) {
        return customMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return customMapper.queryTotal(map);
    }

    @Override
    public void update(Custom custom) {
        customMapper.update(custom);
    }

    @Override
    public void save(Custom custom) {
        custom.setCreatedate(new Date());
        customMapper.save(custom);
    }

    @Override
    public void delete(Integer id) {
        customMapper.delete(id);
    }

    @Override
    public Custom queryByNameAndPhone(Custom custom) {
        return customMapper.queryByNameAndPhone(custom);
    }
}
