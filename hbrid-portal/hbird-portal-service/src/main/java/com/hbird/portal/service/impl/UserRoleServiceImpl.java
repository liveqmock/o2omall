package com.hbird.portal.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.manager.UserRoleManager;
import com.hbird.portal.service.UserRoleService;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午11:23:26
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final static Logger log = LogManager.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleManager userRoleManager;

    @Profiled(tag = "UserRoleService.batchInsert")
    public boolean insert(List<UserRole> beanList) {
        boolean resultFlag = false;
        try {
            resultFlag = this.userRoleManager.insert(beanList);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl -> insert() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserRoleService.insert")
    public boolean insert(UserRole bean) {
        boolean resultFlag = false;
        try {
            if (null != bean) {
                resultFlag = this.userRoleManager.insert(bean);
            } else {
                log.error("param is null!");
            }
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!insert(UserRole bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserRoleService.queryUserRoleList")
    public List<UserRole> queryUserRoleList(UserRoleQuery queryBean) {
        List<UserRole> userRoleList = null;
        try {
            userRoleList = this.userRoleManager.queryUserRoleList(queryBean);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl -> queryUserRoleList() error!!", e);
        }
        return userRoleList;
    }

    @Profiled(tag = "UserRoleService.queryUserRoleListWithPage")
    public PaginatedArrayList<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean, int pageIndex, int pageSize) {
        PaginatedArrayList<UserRole> userRoleList = null;
        try {
            userRoleList = this.userRoleManager.queryUserRoleListWithPage(queryBean, pageIndex, pageSize);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl -> queryUserRolePages() error!!", e);
        }
        return userRoleList;
    }

    @Profiled(tag = "UserRoleService.update")
    public boolean update(UserRole bean) {
        boolean resultFlag = false;
        try {
            resultFlag = this.userRoleManager.update(bean);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!update(UserRole bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserRoleService.delete")
    public boolean delete(Long id) {
        boolean resultFlag = false;
        try {
            if (null != id && id.intValue() > 0) {
                resultFlag = this.userRoleManager.delete(id);
            } else {
                log.error("UserRoleServiceImpl!delete(Long id) param: " + id + " Illegal!");
            }
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserRoleService.batchDelete")
    public boolean delete(String[] ids) {
        boolean resultFlag = false;
        try {
            resultFlag = this.userRoleManager.delete(ids);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl -> delete() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserRoleService.getUserRoleById")
    public UserRole getUserRoleById(Long id) {
        UserRole userRole = null;
        try {
            userRole = this.userRoleManager.getUserRoleById(id);
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!getUserRoleById(Integer id) error!", e);
        }
        return userRole;
    }

    public boolean batchSave(Long userId, String[] roleIds, String createUser) {
        boolean resultFlag = false;
        try {
            if (null != userId) {
                resultFlag = this.userRoleManager.batchSave(userId, roleIds, createUser);
            } else {
                log.error("UserRoleServiceImpl!batchSave param: " + userId + " , roleIds:" + Arrays.toString(roleIds)
                        + " Illegal!");
            }
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    public boolean batchSaves(String[] userIds, String[] roleIds, String createUser) {

        boolean resultFlag = false;
        try {
            if (null != userIds && roleIds != null) {
                resultFlag = this.userRoleManager.batchSaves(userIds, roleIds, createUser);
            } else {
                log.error("UserRoleServiceImpl!batchSaves param: " + userIds + " , roleIds:" + Arrays.toString(roleIds)
                        + " Illegal!");
            }
        } catch (Exception e) {
            log.error("UserRoleServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }
}
