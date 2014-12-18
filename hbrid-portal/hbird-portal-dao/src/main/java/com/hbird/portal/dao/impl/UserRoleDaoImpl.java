package com.hbird.portal.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.UserRoleDao;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午11:00:17
 */
@Repository
public class UserRoleDaoImpl extends BaseDao implements UserRoleDao {

    public boolean deleteUserRoleById(Long id) {
        return delete("UserRole.deleteUserById", id);
    }

    public UserRole getUserRoleById(Long id) {
        return (UserRole) queryForObject("UserRole.getUserById", id);
    }

    public boolean insert(UserRole bean) {
        return insert("UserRole.insert", bean);
    }

    public int queryUserRoleCount(UserRoleQuery queryBean) {
        return (Integer) queryForObject("UserRole.queryUserRoleCount", queryBean);
    }

    public List<UserRole> queryUserRoleList(UserRoleQuery queryBean) {
        return (List<UserRole>) queryForList("UserRole.queryUserRoleList", queryBean);
    }

    public List<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean) {
        return (List<UserRole>) queryForList("UserRole.queryUserRoleListWithPage", queryBean);
    }

    public boolean update(UserRole bean) {
        return update("UserRole.update", bean);
    }

    public boolean deleteUserRoleByUserId(Long userId) {
        return delete("UserRole.deleteUserRoleByUserId", userId);
    }

    /**
     * 批量删除角色用户关系
     */
    public boolean deleteUserRoleByUserIds(String[] userIds) {
        // TODO Auto-generated method stub
        return delete("UserRole.deleteUserRoleByUserIds", userIds);
    }

}
