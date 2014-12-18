package com.hbird.portal.service;

import java.util.List;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午11:20:24
 */
public interface UserRoleService {

    /**
     * 批量增加对象信息
     * 
     * @param beanList
     * @return
     */
    boolean insert(List<UserRole> beanList);

    /**
     * 单个增加对象信息
     * 
     * @param bean
     * @return
     */
    boolean insert(UserRole bean);

    /**
     * 根据主键更新对象信息
     * 
     * @param bean
     *            对象信息对象
     * @return Result 对象
     */
    boolean update(UserRole bean);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    List<UserRole> queryUserRoleList(UserRoleQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    PaginatedArrayList<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean, int pageIndex, int pageSize);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据对象信息ID，主键获取对象信息
     * 
     * @param id
     * @return
     */
    UserRole getUserRoleById(Long id);

    /**
     * 根据主键集合删除对象信息，该处做的是逻辑删除
     * 
     * @param ids
     *            主键集合
     * @return
     */
    boolean delete(String[] ids);

    /**
     * 批量绑定用户、角色关系： 1.删除用户原有角色 2.添加新的用户角色关系
     * 
     * @param userId
     * @param roleIds
     * @param createUser
     * @return
     */
    boolean batchSave(Long userId, String[] roleIds, String createUser);

    /**
     * 批量分配用户、角色关系： 1.删除用户原有角色 2.添加新的用户角色关系
     * 
     * @param userId
     * @param roleIds
     * @param createUser
     * @return
     */
    boolean batchSaves(String[] userIds, String[] roleIds, String createUser);

}
