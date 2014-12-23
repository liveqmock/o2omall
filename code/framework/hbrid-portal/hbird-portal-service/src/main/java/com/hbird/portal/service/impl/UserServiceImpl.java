package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.query.UserQuery;
import com.hbird.portal.manager.UserManager;
import com.hbird.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;

/**
 * User: ljz Date: 2014-04-15 Time: 10:22:04
 */
@Service
public class UserServiceImpl implements UserService {
    private final static Logger log = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserManager userManager;

    @Profiled(tag = "UserService.batchInsert")
    public boolean insert(List<User> beanList) {
        boolean resultFlag = false;
        try {
            resultFlag = userManager.insert(beanList);
        } catch (Exception e) {
            log.error("UserServiceImpl -> insert() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserService.insert")
    public boolean insert(User bean) {
        boolean resultFlag = false;
        try {
            if (null != bean) {
                resultFlag = userManager.insert(bean);
            } else {
                log.error("param is null!");
            }
        } catch (Exception e) {
            log.error("UserServiceImpl!insert(User bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserService.update")
    public boolean update(User bean) {
        boolean resultFlag = false;
        try {
            resultFlag = userManager.update(bean);
        } catch (Exception e) {
            log.error("UserServiceImpl!update(User bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserService.queryUserList")
    public List<User> queryUserList(UserQuery queryBean) {
        List<User> userList = null;
        try {
            userList = userManager.queryUserList(queryBean);
        } catch (Exception e) {
            log.error("UserServiceImpl -> queryUserList() error!!", e);
        }
        return userList;
    }

    @Profiled(tag = "UserService.queryUserListWithPage")
    public PaginatedArrayList<User> queryUserListWithPage(UserQuery queryBean, int pageIndex, int pageSize) {
        PaginatedArrayList<User> userList = null;
        try {
            userList = userManager.queryUserListWithPage(queryBean, pageIndex, pageSize);
        } catch (Exception e) {
            log.error("UserServiceImpl -> queryUserPages() error!!", e);
        }
        return userList;
    }

    @Profiled(tag = "UserService.delete")
    public boolean delete(Long id) {
        boolean resultFlag = false;
        try {
            if (null != id && id.intValue() > 0) {
                resultFlag = userManager.delete(id);
            } else {
                log.error("UserServiceImpl!delete(Long id) param: " + id + " Illegal!");
            }
        } catch (Exception e) {
            log.error("UserServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserService.batchDelete")
    public boolean delete(String[] ids) {
        boolean resultFlag = false;
        try {
            resultFlag = userManager.delete(ids);
        } catch (Exception e) {
            log.error("UserServiceImpl -> delete() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "UserService.getUserById")
    public User getUserById(Long id) {
        User user = null;
        try {
            user = userManager.getUserById(id);
        } catch (Exception e) {
            log.error("UserServiceImpl!getUserById(Integer id) error!", e);
        }
        return user;
    }

    @Profiled(tag = "UserService.getUserByName")
    public User getUserByName(String name) {
        User user = null;
        try {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("argument [name] must be net null");
            }
            String fullName = name + "@hbird.com";
            user = userManager.getUserByName(fullName);
            if (null == user) {
                user = userManager.getUserByName(name);
            }
        } catch (Exception e) {
            log.error("UserServiceImpl!getUserByName(String name) error!", e);
        }
        return user;
    }

    @Profiled(tag = "UserService.exist")
    public boolean exist(User user) {
        if (null == user) {
            return false;
        }
        return null != this.getUserByName(user.getName());
    }
}
