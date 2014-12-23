package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.manager.ResourceRoleManager;
import com.hbird.portal.service.ResourceRoleService;

/**
 * 资源和角色关系Service实现类
 * 
 * @author ljz
 * @version 2014-12-10 下午8:28:48
 */
@Service
public class ResourceRoleServiceImpl implements ResourceRoleService {
    private final static Logger log = LogManager.getLogger(ResourceRoleServiceImpl.class);
    @Autowired
    private ResourceRoleManager resourceRoleManager;

    public List<ResourceRole> queryResourceRoleList(Long roleId) {
        List<ResourceRole> resourceRoleList = null;
        try {
            resourceRoleList = resourceRoleManager.queryResourceRoleList(roleId);
        } catch (Exception e) {
            log.error("ResourceRoleServiceImpl -> queryResourceRoleList() error!!", e);
        }
        return resourceRoleList;
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ResourceRole oldResourceRole, List<ResourceRole> newResourceRoles) {
        boolean resultFlag = false;
        try {
            if (null != oldResourceRole && (null != oldResourceRole.getRoleId() || null != oldResourceRole.getResId())) {
                resultFlag = this.resourceRoleManager.update(oldResourceRole, newResourceRoles);
            } else {
                log.warn("ResourceRoleServiceImpl.update has Illegal params.");
            }
        } catch (Exception e) {
            log.error("ResourceRoleServiceImpl.update has error,", e);
        }
        return resultFlag;
    }
}
