package com.awe.pms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.awe.pms.manager.SkuImagesManager;
import com.awe.pms.service.SkuImagesService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * SkuImagesService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
@Service
public class SkuImagesServiceImpl implements SkuImagesService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(SkuImagesServiceImpl.class);

    @Autowired
    private SkuImagesManager skuImagesManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.batchInsert")
    public boolean insert(List<SkuImages> skuImagesList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(skuImagesList)) {
                resultFlag = skuImagesManager.insert(skuImagesList);
            } else {
                LOG.warn("SkuImagesServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.insert")
    public boolean insert(SkuImages skuImages) {
        boolean resultFlag = false;
        try {
            if (null != skuImages) {
                if (skuImagesManager.exist(skuImages)) {
                    throw new ExistedException();
                }
                resultFlag = skuImagesManager.insert(skuImages);
            } else {
                LOG.warn("SkuImagesServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("SkuImagesServiceImpl#insert failed, skuImages has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.update")
    public boolean update(SkuImages skuImages) {
        boolean resultFlag = false;
        try {
            if (null != skuImages && null != skuImages.getId()) {
                resultFlag = skuImagesManager.update(skuImages);
            } else {
                LOG.warn("SkuImagesServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.querySkuImagesList")
    public List<SkuImages> querySkuImagesList(SkuImagesQuery queryBean) {
        List<SkuImages> skuImagesList = null;
        try {
            skuImagesList = skuImagesManager.querySkuImagesList(queryBean);
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#querySkuImagesList has error.", e);
        }
        return skuImagesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.querySkuImagesListWithPage")
    public List<SkuImages> querySkuImagesListWithPage(SkuImagesQuery queryBean, PageUtil pageUtil) {
        List<SkuImages> skuImagesList = null;
        try {
            skuImagesList = skuImagesManager.querySkuImagesListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#querySkuImagesListWithPage has error.", e);
        }
        return skuImagesList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.delete")
    public boolean delete(SkuImages skuImages) {
        boolean resultFlag = false;
        try {
            if (null != skuImages && null != skuImages.getId()) {
                resultFlag = skuImagesManager.delete(skuImages);
            } else {
                LOG.warn("SkuImagesServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.batchDelete")
    public boolean delete(SkuImages[] skuImagess) {
        boolean resultFlag = false;
        try {
            if (null != skuImagess && skuImagess.length > 0) {
                resultFlag = skuImagesManager.delete(skuImagess);
            } else {
                LOG.warn("SkuImagesServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SkuImagesService.getSkuImagesById")
    public SkuImages getSkuImagesById(Long id) {
        SkuImages skuImages = null;
        try {
            if (null != id) {
                skuImages = skuImagesManager.getSkuImagesById(id);
            } else {
                LOG.warn("SkuImagesServiceImpl#getSkuImagesById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SkuImagesServiceImpl#getSkuImagesById has error.", e);
        }
        return skuImages;
    }
}

