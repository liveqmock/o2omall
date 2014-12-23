package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.RoleDao;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.ResourceRoleQuery;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.domain.query.UserRoleQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Repository
public class RoleDaoImpl extends BaseDao implements RoleDao {

    public List<Role> queryRoleList(RoleQuery queryBean) {
        return (List<Role>) queryForList("Role.queryRoleList", queryBean);
    }

    public List<Role> queryRoles(RoleQuery queryBean) {
        return (List<Role>) queryForList("Role.queryRoles", queryBean);
    }

    public boolean insert(Role bean) {
        return insert("Role.insert", bean);
    }

    public boolean update(Role bean) {
        return update("Role.update", bean);
    }

    public int queryRoleCount(RoleQuery queryBean) {
        return (Integer) queryForObject("Role.queryRoleCount", queryBean);
    }

    public List<Role> queryRoleListWithPage(RoleQuery queryBean) {
        return (List<Role>) queryForList("Role.queryRoleListWithPage", queryBean);
    }

    public boolean deleteRoleById(Long id) {
        return delete("Role.deleteRoleById", id);
    }

    public Role getRoleById(Long id) {
        return (Role) queryForObject("Role.getRoleById", id);
    }

    public List<Role> queryConfigedRoleList(UserRoleQuery queryBean) {
        return (List<Role>) queryForList("Role.queryConfigedRoleList", queryBean);
    }

    public List<Role> queryAvailableRoleList(UserRoleQuery queryBean) {
        return (List<Role>) queryForList("Role.queryAvailableRoleList", queryBean);
    }

    public List<Role> queryResourceConfigedRoleList(ResourceRoleQuery query) {
        return (List<Role>) queryForList("Role.queryResourceConfigedRoleList", query);
    }

    public List<Role> queryResourceAvailableRoleList(ResourceRoleQuery query) {
        return (List<Role>) queryForList("Role.queryResourceAvailableRoleList", query);
    }
}
