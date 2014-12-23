package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午10:58:13
 */
public interface UserRoleDao {

    /**
     * 新增对象
     * 
     * @param bean
     * @return
     */
    boolean insert(UserRole bean);

    /**
     * 更新对象
     * 
     * @param bean
     * @return
     */
    boolean update(UserRole bean);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    List<UserRole> queryUserRoleList(UserRoleQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    int queryUserRoleCount(UserRoleQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    List<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean deleteUserRoleById(Long id);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    UserRole getUserRoleById(Long id);

    /**
     * @param userId
     */
    boolean deleteUserRoleByUserId(Long userId);

    /**
     * @param userIds
     */
    boolean deleteUserRoleByUserIds(String[] userIds);
}
