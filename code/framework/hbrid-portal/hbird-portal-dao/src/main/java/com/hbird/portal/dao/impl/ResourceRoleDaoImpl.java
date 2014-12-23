package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.ResourceRoleDao;
import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.domain.query.ResourceRoleQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA. User: ljz Date: 14-4-21 Time: 下午5:53 To change this template use File | Settings | File
 * Templates.
 */
@Repository
public class ResourceRoleDaoImpl extends BaseDao implements ResourceRoleDao {

    public boolean insert(ResourceRole bean) {
        return insert("ResourceRole.insert", bean);
    }

    public boolean deleteResourceRole(ResourceRole resourceRole) {
        return delete("ResourceRole.deleteResourceRole", resourceRole);
    }

    public List<ResourceRole> queryResourceRoleList(Long roleId) {
        return queryForList("ResourceRole.queryResourceRoleList", roleId);
    }

    public List<ResourceRole> queryResourceListByRoleIds(ResourceRoleQuery resourceRoleQuery) {
        return queryForList("ResourceRole.queryResourceListByRoleIds", resourceRoleQuery);
    }
}
