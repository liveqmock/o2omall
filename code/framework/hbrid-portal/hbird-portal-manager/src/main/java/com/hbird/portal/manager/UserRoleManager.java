package com.hbird.portal.manager;

import java.util.List;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午11:06:10
 */
public interface UserRoleManager {

    /**
     * 批量增加对象信息
     * 
     * @param beanList
     * @return
     */
    boolean insert(List<UserRole> beanList);

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
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    PaginatedArrayList<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean, int pageIndex, int pageSize);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param ids
     *            主键集合
     * @return
     */
    boolean delete(String[] ids);

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
     * @param roleIds
     * @param createUser
     * @return
     */
    boolean batchSave(Long userId, String[] roleIds, String createUser);

    /**
     * 批量分配用户角色
     * 
     * @param userIds
     * @param roleIds
     * @param createUser
     * @return
     */
    boolean batchSaves(String[] userIds, String[] roleIds, String createUser);
}
