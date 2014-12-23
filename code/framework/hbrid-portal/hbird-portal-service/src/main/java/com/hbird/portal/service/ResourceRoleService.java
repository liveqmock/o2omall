package com.hbird.portal.service;

import com.hbird.portal.domain.ResourceRole;

import java.util.List;

/**
 * 资源和角色关系Service接口
 * 
 * @author ljz
 * @version 2014-12-10 下午8:25:06
 */
public interface ResourceRoleService {

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

}
