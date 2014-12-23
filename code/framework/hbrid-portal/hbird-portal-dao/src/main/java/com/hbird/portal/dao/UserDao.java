package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.User;
import com.hbird.portal.domain.query.UserQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface UserDao {

    /**
     * 新增对象
     * 
     * @param bean
     * @return
     */
    boolean insert(User bean);

    /**
     * 更新对象
     * 
     * @param bean
     * @return
     */
    boolean update(User bean);

    /**
     * 根据登录账号更新对象
     * 
     * @param bean
     * @return
     */
    boolean updateByName(User bean);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    List<User> queryUserList(UserQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    int queryUserCount(UserQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    List<User> queryUserListWithPage(UserQuery queryBean);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean deleteUserById(Long id);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据登录账号获取用户信息
     * 
     * @param name
     * @return
     */
    User getUserByName(String name);
}
