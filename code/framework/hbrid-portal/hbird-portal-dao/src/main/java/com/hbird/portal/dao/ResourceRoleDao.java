package com.hbird.portal.dao;

import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.domain.query.ResourceRoleQuery;

import java.util.List;

/**
 * 资源和角色关联关系 DAO接口
 * 
 * @author ljz
 * @version 2014-12-10 下午8:19:40
 */
public interface ResourceRoleDao {
    /**
     * 新增资源和角色关联关系
     * 
     * @param resourceRole
     * @return
     */
    boolean insert(ResourceRole resourceRole);

    /**
     * 删除资源和角色关联关系
     * 
     * @param resourceRole
     * @return
     */
    boolean deleteResourceRole(ResourceRole resourceRole);

    /**
     * 根据角色获取已经分配的资源列表
     * 
     * @param roleId
     * @return
     */
    List<ResourceRole> queryResourceRoleList(Long roleId);

    /**
     * 根据角色ID集合查询拥有资源列表
     * 
     * @param resourceRoleQuery
     *            #roleIds
     * @return
     */
    List<ResourceRole> queryResourceListByRoleIds(ResourceRoleQuery resourceRoleQuery);
}
