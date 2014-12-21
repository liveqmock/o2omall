package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
import com.awe.uc.dao.UserBasicDao;
import com.awe.uc.manager.UserBasicManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserBasicManager接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Component
public class UserBasicManagerImpl extends BaseManager implements UserBasicManager {
	
    @Autowired
    private UserBasicDao userBasicDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserBasic> userBasicList) {
        boolean resultFlag = false;
        if (null != userBasicList && userBasicList.size() > 0) {
            for (UserBasic userBasic : userBasicList) {
                resultFlag = userBasicDao.insert(userBasic);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(UserBasic userBasic) {
        return userBasicDao.insert(userBasic);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserBasic userBasic) {
        return userBasicDao.update(userBasic);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserBasic> queryUserBasicList(UserBasicQuery queryBean) {
        return userBasicDao.queryUserBasicList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserBasic> queryUserBasicListWithPage(UserBasicQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserBasicQuery();
        }

        // 查询总数
        int totalItem = queryUserBasicCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userBasicDao.queryUserBasicListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserBasicCount(UserBasicQuery queryBean) {
        return userBasicDao.queryUserBasicCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserBasic userBasic) {
        return userBasicDao.delete(userBasic);
    }

    /**
     * {@inheritDoc}
     */
    public UserBasic getUserBasicById(Long id) {
        return userBasicDao.getUserBasicById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserBasic[] userBasics) {
        boolean resultFlag = false;
        if (null != userBasics && userBasics.length > 0) {
            for (int i = 0; i < userBasics.length; i++) {
                resultFlag = delete(userBasics[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(UserBasic userBasic) {
        return userBasicDao.exist(userBasic);
    }
}
