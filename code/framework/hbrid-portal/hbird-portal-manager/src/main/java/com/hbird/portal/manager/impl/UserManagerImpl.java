package com.hbird.portal.manager.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.dao.UserDao;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.query.UserQuery;
import com.hbird.portal.manager.UserManager;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Component
public class UserManagerImpl extends BaseManager implements UserManager {
    private final static Logger log = LogManager.getLogger(UserManagerImpl.class);
    @Autowired
    private UserDao userDao;

    public boolean insert(final List<User> beanList) {
        boolean resultFlag = true;
        if (null != beanList && beanList.size() > 0) {
            for (User bean : beanList) {
                resultFlag = userDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    public boolean insert(User bean) {
        return userDao.insert(bean);
    }

    public boolean update(final User bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = userDao.update(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,ID:[" + bean.getId() + "]!");
            }
        } else {
            log.debug("UserManagerImpl!update(User bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public boolean updateByName(User bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = this.userDao.updateByName(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,NAME:[" + bean.getName() + "]!");
            }
        } else {
            log.debug("UserManagerImpl!update(User bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public List<User> queryUserList(UserQuery queryBean) {
        return userDao.queryUserList(queryBean);
    }

    public PaginatedArrayList<User> queryUserListWithPage(UserQuery queryBean, int pageIndex, int pageSize) {
        if (null == queryBean) {
            queryBean = new UserQuery();
        }
        queryBean.setPageIndex(pageIndex);
        queryBean.setPageSize(pageSize);
        // 查询总数
        int totalItem = queryUserCount(queryBean);
        // 创建翻页集合,根据第几页和每页大小
        PaginatedArrayList<User> users = new PaginatedArrayList<User>(pageIndex, pageSize);
        // 设置总数,同时将会计算出开始行和结束行
        users.setTotalItem(totalItem);

        // 设置开始行
        // queryBean.setStartRow(users.getStartRow());
        // 设置最后行
        queryBean.setEndRow(users.getPageSize());
        // 调用Dao翻页方法
        List<User> userList = userDao.queryUserListWithPage(queryBean);
        users.addAll(userList);

        return users;
    }

    public int queryUserCount(UserQuery queryBean) {
        return userDao.queryUserCount(queryBean);
    }

    public boolean delete(Long id) {
        return userDao.deleteUserById(id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
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

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public int syncUserDatas(List<User> users) {
        int addCount = 0;
        int updateCount = 0;
        if (users != null && users.size() > 0) {
            for (User user : users) {
                User tempUser = this.getUserByName(user.getName());
                if (tempUser == null) {
                    this.insert(user);
                    addCount++;
                } else if (tempUser.getLastModifyTime().getTime() < user.getLastModifyTime().getTime()) {
                    this.updateByName(user);
                    updateCount++;
                } else {
                    log.info("syncUserDatas 最后更新时间不大于当前最后更新时间判断为不更新数据！");
                }
            }
            log.info("总共记录：【" + users.size() + "】条，新增：【" + addCount + "】条，更新：【" + updateCount + "】条。");
        }

        // 返回操作数据库条数
        return addCount + updateCount;
    }
}
