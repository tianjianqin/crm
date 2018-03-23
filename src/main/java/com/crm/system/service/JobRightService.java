package com.crm.system.service;

import com.crm.system.domain.Rights;

import java.util.List;
import java.util.Map;

/**
 * @author tianjianqin
 * @date 2018/3/13 16:38
 */
public interface JobRightService {

    void saveOrUpdate(Integer jobInfoId, List<Integer> rightIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Integer> queryRightIdList(Integer jobInfoId);

    /**
     * 权限菜单（一级权限和二级权限）
     */
    List<Rights> findRightName(Integer jobInfoId);

    List<Rights> queryList(Map<String, Object> map);

    void delete(Integer jobinfoid);
}
