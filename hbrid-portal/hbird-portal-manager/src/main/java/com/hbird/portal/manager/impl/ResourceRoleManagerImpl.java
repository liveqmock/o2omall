package com.hbird.portal.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.manager.BaseManager;
import com.hbird.portal.dao.ResourceRoleDao;
import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.domain.query.ResourceRoleQuery;
import com.hbird.portal.manager.ResourceRoleManager;

/**
 * 资源和角色的绑定关系 Manager实现类
 * 
 * @author ljz
 * @version 2014-12-10 下午8:30:21
 */
@Component
public class ResourceRoleManagerImpl extends BaseManager implements ResourceRoleManager {

    @Autowired
    private ResourceRoleDao resourceRoleDao;

    /**
     * {@inheritDoc}
     */
    public boolean update(ResourceRole oldResourceRole, List<ResourceRole> newResourceRoles) {
        resourceRoleDao.deleteResourceRole(oldResourceRole);

        if (!CollectionUtils.isEmpty(newResourceRoles)) {
            boolean resultFlag = false;
            for (ResourceRole bean : newResourceRoles) {
                resultFlag = this.resourceRoleDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
            return resultFlag;
        }
        return true;
    }

    public List<ResourceRole> queryResourceRoleList(Long roleId) {
        return resourceRoleDao.queryResourceRoleList(roleId);
    }

    public List<ResourceRole> queryResourceListByRoleIds(ResourceRoleQuery resourceRoleQuery) {
        return resourceRoleDao.queryResourceListByRoleIds(resourceRoleQuery);
    }
}
