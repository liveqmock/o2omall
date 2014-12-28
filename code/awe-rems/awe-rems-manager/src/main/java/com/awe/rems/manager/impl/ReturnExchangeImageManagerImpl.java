package com.awe.rems.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
import com.awe.rems.dao.ReturnExchangeImageDao;
import com.awe.rems.manager.ReturnExchangeImageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ReturnExchangeImageManager接口的实现类
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Component
public class ReturnExchangeImageManagerImpl extends BaseManager implements ReturnExchangeImageManager {
	
    @Autowired
    private ReturnExchangeImageDao returnExchangeImageDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ReturnExchangeImage> returnExchangeImageList) {
        boolean resultFlag = false;
        if (null != returnExchangeImageList && returnExchangeImageList.size() > 0) {
            for (ReturnExchangeImage returnExchangeImage : returnExchangeImageList) {
                resultFlag = returnExchangeImageDao.insert(returnExchangeImage);
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
    public boolean insert(ReturnExchangeImage returnExchangeImage) {
        return returnExchangeImageDao.insert(returnExchangeImage);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ReturnExchangeImage returnExchangeImage) {
        return returnExchangeImageDao.update(returnExchangeImage);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageList(ReturnExchangeImageQuery queryBean) {
        return returnExchangeImageDao.queryReturnExchangeImageList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageListWithPage(ReturnExchangeImageQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ReturnExchangeImageQuery();
        }

        // 查询总数
        int totalItem = queryReturnExchangeImageCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return returnExchangeImageDao.queryReturnExchangeImageListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryReturnExchangeImageCount(ReturnExchangeImageQuery queryBean) {
        return returnExchangeImageDao.queryReturnExchangeImageCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ReturnExchangeImage returnExchangeImage) {
        return returnExchangeImageDao.delete(returnExchangeImage);
    }

    /**
     * {@inheritDoc}
     */
    public ReturnExchangeImage getReturnExchangeImageById(Long id) {
        return returnExchangeImageDao.getReturnExchangeImageById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final ReturnExchangeImage[] returnExchangeImages) {
        boolean resultFlag = false;
        if (null != returnExchangeImages && returnExchangeImages.length > 0) {
            for (int i = 0; i < returnExchangeImages.length; i++) {
                resultFlag = delete(returnExchangeImages[i]);
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
    public boolean exist(ReturnExchangeImage returnExchangeImage) {
        return returnExchangeImageDao.exist(returnExchangeImage);
    }
}
