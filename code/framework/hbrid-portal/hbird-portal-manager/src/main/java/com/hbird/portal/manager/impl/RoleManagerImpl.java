package com.hbird.portal.manager.impl;

import java.util.List;

import com.hbird.portal.domain.query.ResourceRoleQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.core.util.codegenerate.BusinessCodeGenerator;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.dao.RoleDao;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.manager.RoleManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Component
public class RoleManagerImpl extends BaseManager implements RoleManager {
    private final static Logger log = LogManager.getLogger(RoleManagerImpl.class);
    @Autowired
    private RoleDao roleDao;

    public boolean insert(final List<Role> beanList) {
        boolean resultFlag = true;
        if (null != beanList && beanList.size() > 0) {
            for (Role bean : beanList) {
                resultFlag = roleDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    public boolean insert(Role bean) {
        boolean resultFlag = false;
        resultFlag = roleDao.insert(bean);
        if (resultFlag) {
            String code = BusinessCodeGenerator.getRoleCode(bean.getId());
            bean.setCode(code);
            resultFlag = roleDao.update(bean);
        } else {
            throw new RuntimeException("信息更新异常,ID:[" + bean.getId() + "]!");
        }
        return resultFlag;
    }

    public boolean update(final Role bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = roleDao.update(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,ID:[" + bean.getId() + "]!");
            }
        } else {
            log.debug("RoleManagerImpl!update(Role bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public List<Role> queryRoleList(RoleQuery queryBean) {
        return roleDao.queryRoleList(queryBean);
    }

    public List<Role> queryRoles(RoleQuery queryBean) {
        return roleDao.queryRoles(queryBean);
    }

    public PaginatedArrayList<Role> queryRoleListWithPage(RoleQuery queryBean, int pageIndex, int pageSize) {
        if (null == queryBean) {
            queryBean = new RoleQuery();
        }
        queryBean.setPageIndex(pageIndex);
        queryBean.setPageSize(pageSize);
        // 查询总数
        int totalItem = queryRoleCount(queryBean);
        // 创建翻页集合,根据第几页和每页大小
        PaginatedArrayList<Role> roles = new PaginatedArrayList<Role>(pageIndex, pageSize);
        // 设置总数,同时将会计算出开始行和结束行
        roles.setTotalItem(totalItem);

        // 设置开始行
        // queryBean.setStartRow(roles.getStartRow());
        // 设置最后行
        queryBean.setEndRow(roles.getPageSize());
        // 调用Dao翻页方法
        List<Role> roleList = roleDao.queryRoleListWithPage(queryBean);
        roles.addAll(roleList);

        return roles;
    }

    public int queryRoleCount(RoleQuery queryBean) {
        return roleDao.queryRoleCount(queryBean);
    }

    public boolean delete(Long id) {
        return roleDao.deleteRoleById(id);
    }

    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    public boolean delete(final String[] ids) {
        boolean resultFlag = true;
        if (null != ids && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                resultFlag = delete(Long.parseLong(ids[i]));
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        } else {
            log.error("ids param is null!");
        }

        return resultFlag;
    }

    public List<Role> queryConfigedRoleList(UserRoleQuery queryBean) {
        return roleDao.queryConfigedRoleList(queryBean);
    }

    public List<Role> queryAvailableRoleList(UserRoleQuery queryBean) {
        return roleDao.queryAvailableRoleList(queryBean);
    }

    public List<Role> queryResourceConfigedRoleList(ResourceRoleQuery query) {
        return roleDao.queryResourceConfigedRoleList(query);
    }

    public List<Role> queryResourceAvailableRoleList(ResourceRoleQuery query) {
        return roleDao.queryResourceAvailableRoleList(query);
    }
}
