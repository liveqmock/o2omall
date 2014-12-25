package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.awe.pms.dao.SkuImagesDao;
import com.awe.pms.manager.SkuImagesManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SkuImagesManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Component
public class SkuImagesManagerImpl extends BaseManager implements SkuImagesManager {
	
    @Autowired
    private SkuImagesDao skuImagesDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<SkuImages> skuImagesList) {
        boolean resultFlag = false;
        if (null != skuImagesList && skuImagesList.size() > 0) {
            for (SkuImages skuImages : skuImagesList) {
                resultFlag = skuImagesDao.insert(skuImages);
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
    public boolean insert(SkuImages skuImages) {
        return skuImagesDao.insert(skuImages);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final SkuImages skuImages) {
        return skuImagesDao.update(skuImages);
    }

    /**
     * {@inheritDoc}
     */
    public List<SkuImages> querySkuImagesList(SkuImagesQuery queryBean) {
        return skuImagesDao.querySkuImagesList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<SkuImages> querySkuImagesListWithPage(SkuImagesQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new SkuImagesQuery();
        }

        // 查询总数
        int totalItem = querySkuImagesCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return skuImagesDao.querySkuImagesListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int querySkuImagesCount(SkuImagesQuery queryBean) {
        return skuImagesDao.querySkuImagesCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(SkuImages skuImages) {
        return skuImagesDao.delete(skuImages);
    }

    /**
     * {@inheritDoc}
     */
    public SkuImages getSkuImagesById(Long id) {
        return skuImagesDao.getSkuImagesById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final SkuImages[] skuImagess) {
        boolean resultFlag = false;
        if (null != skuImagess && skuImagess.length > 0) {
            for (int i = 0; i < skuImagess.length; i++) {
                resultFlag = delete(skuImagess[i]);
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
    public boolean exist(SkuImages skuImages) {
        return skuImagesDao.exist(skuImages);
    }
}
