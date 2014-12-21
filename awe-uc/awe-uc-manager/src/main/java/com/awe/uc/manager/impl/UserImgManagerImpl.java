package com.awe.uc.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
import com.awe.uc.dao.UserImgDao;
import com.awe.uc.manager.UserImgManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserImgManager接口的实现类
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
@Component
public class UserImgManagerImpl extends BaseManager implements UserImgManager {
	
    @Autowired
    private UserImgDao userImgDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<UserImg> userImgList) {
        boolean resultFlag = false;
        if (null != userImgList && userImgList.size() > 0) {
            for (UserImg userImg : userImgList) {
                resultFlag = userImgDao.insert(userImg);
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
    public boolean insert(UserImg userImg) {
        return userImgDao.insert(userImg);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final UserImg userImg) {
        return userImgDao.update(userImg);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserImg> queryUserImgList(UserImgQuery queryBean) {
        return userImgDao.queryUserImgList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<UserImg> queryUserImgListWithPage(UserImgQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new UserImgQuery();
        }

        // 查询总数
        int totalItem = queryUserImgCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return userImgDao.queryUserImgListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryUserImgCount(UserImgQuery queryBean) {
        return userImgDao.queryUserImgCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(UserImg userImg) {
        return userImgDao.delete(userImg);
    }

    /**
     * {@inheritDoc}
     */
    public UserImg getUserImgById(Long id) {
        return userImgDao.getUserImgById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final UserImg[] userImgs) {
        boolean resultFlag = false;
        if (null != userImgs && userImgs.length > 0) {
            for (int i = 0; i < userImgs.length; i++) {
                resultFlag = delete(userImgs[i]);
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
    public boolean exist(UserImg userImg) {
        return userImgDao.exist(userImg);
    }
}
