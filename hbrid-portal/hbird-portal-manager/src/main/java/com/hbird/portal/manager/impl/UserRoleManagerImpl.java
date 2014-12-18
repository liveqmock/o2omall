package com.hbird.portal.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.dao.UserRoleDao;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.manager.UserRoleManager;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午11:07:23
 */
@Component
public class UserRoleManagerImpl extends BaseManager implements UserRoleManager {

    private final static Logger log = LogManager.getLogger(UserRoleManagerImpl.class);

    @Autowired
    private UserRoleDao userRoleDao;

    public boolean insert(List<UserRole> beanList) {
        boolean resultFlag = true;
        if (null != beanList && beanList.size() > 0) {
            for (UserRole bean : beanList) {
                resultFlag = this.userRoleDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }
        return resultFlag;
    }

    public boolean insert(UserRole bean) {
        return this.userRoleDao.insert(bean);
    }

    public int queryUserRoleCount(UserRoleQuery queryBean) {
        return this.userRoleDao.queryUserRoleCount(queryBean);
    }

    public List<UserRole> queryUserRoleList(UserRoleQuery queryBean) {
        return this.userRoleDao.queryUserRoleList(queryBean);
    }

    public boolean update(UserRole bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = this.userRoleDao.update(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,ID:[" + bean.getId() + "]!");
            }
        } else {
            log.debug("UserRoleManagerImpl!update(UserRole bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public boolean delete(Long id) {
        return this.userRoleDao.deleteUserRoleById(id);
    }

    public UserRole getUserRoleById(Long id) {
        return this.userRoleDao.getUserRoleById(id);
    }

    public boolean delete(String[] ids) {
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

    public PaginatedArrayList<UserRole> queryUserRoleListWithPage(UserRoleQuery queryBean, int pageIndex, int pageSize) {
        if (null == queryBean) {
            queryBean = new UserRoleQuery();
        }
        queryBean.setPageIndex(pageIndex);
        queryBean.setPageSize(pageSize);
        // 查询总数
        int totalItem = queryUserRoleCount(queryBean);
        // 创建翻页集合,根据第几页和每页大小
        PaginatedArrayList<UserRole> userRoles = new PaginatedArrayList<UserRole>(pageIndex, pageSize);
        // 设置总数,同时将会计算出开始行和结束行
        userRoles.setTotalItem(totalItem);

        // 设置开始行
        // queryBean.setStartRow(users.getStartRow());
        // 设置最后行
        queryBean.setEndRow(userRoles.getPageSize());
        // 调用Dao翻页方法
        List<UserRole> userRoleList = this.userRoleDao.queryUserRoleListWithPage(queryBean);
        userRoles.addAll(userRoleList);

        return userRoles;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean batchSave(Long userId, String[] roleIds, String createUser) {
        this.userRoleDao.deleteUserRoleByUserId(userId);
        if (roleIds != null && roleIds.length > 0) {
            List<UserRole> beanList = new ArrayList<UserRole>(roleIds.length);
            for (String roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(Long.parseLong(roleId));
                userRole.setCreateUser(createUser);
                userRole.setUpdateUser(createUser);
                userRole.setRemark("");
                userRole.setYn(CommonConstants.N);
                beanList.add(userRole);
            }
            return insert(beanList);
        }
        return true;
    }

    public boolean batchSaves(String[] userIds, String[] roleIds, String createUser) {
        boolean resultFlag = true;
        for (String userId : userIds) {
            List<UserRole> beanList = new ArrayList<UserRole>(roleIds.length);
            for (String roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(Long.valueOf(userId));
                userRole.setRoleId(Long.parseLong(roleId));
                userRole.setCreateUser(createUser);
                userRole.setUpdateUser(createUser);
                userRole.setRemark("");
                userRole.setYn(CommonConstants.N);
                beanList.add(userRole);
            }
            resultFlag = insert(beanList);
            if (!resultFlag) {
                return resultFlag;
            }
        }
        return resultFlag;
    }
}
