package com.hbird.portal.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.UserDao;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.query.UserQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    public List<User> queryUserList(UserQuery queryBean) {
        return (List<User>) queryForList("User.queryUserList", queryBean);
    }

    public boolean insert(User bean) {
        return insert("User.insert", bean);
    }

    public boolean update(User bean) {
        return update("User.update", bean);
    }

    public boolean updateByName(User bean) {
        return update("User.updateByName", bean);
    }

    public int queryUserCount(UserQuery queryBean) {
        return (Integer) queryForObject("User.queryUserCount", queryBean);
    }

    public List<User> queryUserListWithPage(UserQuery queryBean) {
        return (List<User>) queryForList("User.queryUserDepListWhere", queryBean);
    }

    public boolean deleteUserById(Long id) {
        return delete("User.deleteUserById", id);
    }

    public User getUserById(Long id) {
        return (User) queryForObject("User.getUserById", id);
    }

    public User getUserByName(String name) {
        return (User) queryForObject("User.getUserByName", name);
    }
}
