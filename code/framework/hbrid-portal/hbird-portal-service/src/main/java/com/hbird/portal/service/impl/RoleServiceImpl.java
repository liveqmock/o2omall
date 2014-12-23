package com.hbird.portal.service.impl;

import java.util.List;

import com.hbird.portal.domain.query.ResourceRoleQuery;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.manager.RoleManager;
import com.hbird.portal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;

/**
 * User: ljz Date: 2014-04-15 Time: 10:22:04
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final static Logger log = LogManager.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleManager roleManager;

    @Profiled(tag = "RoleService.batchInsert")
    public boolean insert(List<Role> beanList) {
        boolean resultFlag = false;
        try {
            resultFlag = roleManager.insert(beanList);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> insert() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "RoleService.insert")
    public boolean insert(Role bean) {
        boolean resultFlag = false;
        try {
            if (null != bean) {
                resultFlag = roleManager.insert(bean);
            } else {
                log.error("param is null!");
            }
        } catch (Exception e) {
            log.error("RoleServiceImpl!insert(Role bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "RoleService.update")
    public boolean update(Role bean) {
        boolean resultFlag = false;
        try {
            resultFlag = roleManager.update(bean);
        } catch (Exception e) {
            log.error("RoleServiceImpl!update(Role bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "RoleService.queryRoleList")
    public List<Role> queryRoleList(RoleQuery queryBean) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryRoleList(queryBean);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryRoleList() error!!", e);
        }
        return roleList;
    }

    public List<Role> queryRoles(RoleQuery queryBean) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryRoleList(queryBean);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryRoles() error!!", e);
        }
        return roleList;
    }

    @Profiled(tag = "RoleService.queryRoleListWithPage")
    public PaginatedArrayList<Role> queryRoleListWithPage(RoleQuery queryBean, int pageIndex, int pageSize) {
        PaginatedArrayList<Role> roleList = null;
        try {
            roleList = roleManager.queryRoleListWithPage(queryBean, pageIndex, pageSize);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryRolePages() error!!", e);
        }
        return roleList;
    }

    @Profiled(tag = "RoleService.delete")
    public boolean delete(Long id) {
        boolean resultFlag = false;
        try {
            if (null != id && id.intValue() > 0) {
                resultFlag = roleManager.delete(id);
            } else {
                log.error("RoleServiceImpl!delete(Long id) param: " + id + " Illegal!");
            }
        } catch (Exception e) {
            log.error("RoleServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "RoleService.batchDelete")
    public boolean delete(String[] ids) {
        boolean resultFlag = false;
        try {
            resultFlag = roleManager.delete(ids);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> delete() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "RoleService.getRoleById")
    public Role getRoleById(Long id) {
        Role role = null;
        try {
            role = roleManager.getRoleById(id);
        } catch (Exception e) {
            log.error("RoleServiceImpl!getRoleById(Integer id) error!", e);
        }
        return role;
    }

    public List<Role> queryConfigedRoleList(UserRoleQuery queryBean) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryConfigedRoleList(queryBean);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryConfigedRoleList() error!!", e);
        }
        return roleList;
    }

    public List<Role> queryAvailableRoleList(UserRoleQuery queryBean) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryAvailableRoleList(queryBean);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryAvailableRoleList() error!!", e);
        }
        return roleList;
    }

    public List<Role> queryResourceConfigedRoleList(ResourceRoleQuery query) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryResourceConfigedRoleList(query);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryResourceConfigedRoleList() error!!", e);
        }
        return roleList;
    }

    public List<Role> queryResourceAvailableRoleList(ResourceRoleQuery query) {
        List<Role> roleList = null;
        try {
            roleList = roleManager.queryResourceAvailableRoleList(query);
        } catch (Exception e) {
            log.error("RoleServiceImpl -> queryResourceAvailableRoleList() error!!", e);
        }
        return roleList;
    }
}
