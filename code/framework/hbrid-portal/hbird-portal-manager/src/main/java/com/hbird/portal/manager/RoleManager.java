package com.hbird.portal.manager;

import java.util.List;

import com.hbird.portal.domain.query.ResourceRoleQuery;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface RoleManager {

    /**
     * 批量增加对象信息
     * 
     * @param beanList
     * @return
     */
    boolean insert(List<Role> beanList);

    /**
     * 单个增加对象信息
     * 
     * @param bean
     * @return
     */
    boolean insert(Role bean);

    /**
     * 更新 对象信息
     * 
     * @param bean
     *            对象信息对象
     * @return false：失败 true：成功
     */
    boolean update(Role bean);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    List<Role> queryRoleList(RoleQuery queryBean);

    // 精确查询
    List<Role> queryRoles(RoleQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    PaginatedArrayList<Role> queryRoleListWithPage(RoleQuery queryBean, int pageIndex, int pageSize);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    int queryRoleCount(RoleQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param id
     *            主键字段
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    Role getRoleById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param ids
     *            主键集合
     * @return
     */
    boolean delete(String[] ids);

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
