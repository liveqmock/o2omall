package com.hbird.portal.manager;

import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.domain.query.ResourceRoleQuery;

import java.util.List;

/**
 * 资源和角色的绑定关系 Manager接口
 * 
 * @author ljz
 * @version 2014-12-10 下午8:11:12
 */
public interface ResourceRoleManager {
    /**
     * 修改资源和角色的绑定关系： 1.删除原来的关系；2.新增新的关系
     * 
     * @param oldResourceRole
     *            原来的关系
     * @param newResourceRoles
     *            新的关系
     * @return
     */
    boolean update(ResourceRole oldResourceRole, List<ResourceRole> newResourceRoles);

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
     */
    public List<ResourceRole> queryResourceListByRoleIds(ResourceRoleQuery resourceRoleQuery);
}
