package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.ResourceRoleQuery;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface RoleDao {

    /**
     * 新增对象
     * 
     * @param bean
     * @return
     */
    boolean insert(Role bean);

    /**
     * 更新对象
     * 
     * @param bean
     * @return
     */
    boolean update(Role bean);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    List<Role> queryRoleList(RoleQuery queryBean);

    // 精确查询
    List<Role> queryRoles(RoleQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    int queryRoleCount(RoleQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    List<Role> queryRoleListWithPage(RoleQuery queryBean);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean deleteRoleById(Long id);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    Role getRoleById(Long id);

    /**
     * 查询用户已配置的角色信息
     * 
     * @param queryBean
     * @return
     */
    List<Role> queryConfigedRoleList(UserRoleQuery queryBean);

    /**
     * 查询可用的（用户未已配置的）角色信息
     * 
     * @param queryBean
     * @return
     */
    List<Role> queryAvailableRoleList(UserRoleQuery queryBean);

    /**
     * 查询资源对应的角色
     * 
     * @param query
     * @return
     */
    List<Role> queryResourceConfigedRoleList(ResourceRoleQuery query);

    /**
     * 查询没有分配资源的角色
     * 
     * @param query
     * @return
     */
    List<Role> queryResourceAvailableRoleList(ResourceRoleQuery query);
}
