package com.awe.rems.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
import com.awe.rems.manager.ReturnExchangeImageManager;
import com.awe.rems.service.ReturnExchangeImageService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ReturnExchangeImageService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:06:16
 * 
 */
@Service
public class ReturnExchangeImageServiceImpl implements ReturnExchangeImageService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ReturnExchangeImageServiceImpl.class);

    @Autowired
    private ReturnExchangeImageManager returnExchangeImageManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.batchInsert")
    public boolean insert(List<ReturnExchangeImage> returnExchangeImageList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(returnExchangeImageList)) {
                resultFlag = returnExchangeImageManager.insert(returnExchangeImageList);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.insert")
    public boolean insert(ReturnExchangeImage returnExchangeImage) {
        boolean resultFlag = false;
        try {
            if (null != returnExchangeImage) {
                if (returnExchangeImageManager.exist(returnExchangeImage)) {
                    throw new ExistedException();
                }
                resultFlag = returnExchangeImageManager.insert(returnExchangeImage);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ReturnExchangeImageServiceImpl#insert failed, returnExchangeImage has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.update")
    public boolean update(ReturnExchangeImage returnExchangeImage) {
        boolean resultFlag = false;
        try {
            if (null != returnExchangeImage && null != returnExchangeImage.getId()) {
                resultFlag = returnExchangeImageManager.update(returnExchangeImage);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.queryReturnExchangeImageList")
    public List<ReturnExchangeImage> queryReturnExchangeImageList(ReturnExchangeImageQuery queryBean) {
        List<ReturnExchangeImage> returnExchangeImageList = null;
        try {
            returnExchangeImageList = returnExchangeImageManager.queryReturnExchangeImageList(queryBean);
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#queryReturnExchangeImageList has error.", e);
        }
        return returnExchangeImageList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.queryReturnExchangeImageListWithPage")
    public List<ReturnExchangeImage> queryReturnExchangeImageListWithPage(ReturnExchangeImageQuery queryBean, PageUtil pageUtil) {
        List<ReturnExchangeImage> returnExchangeImageList = null;
        try {
            returnExchangeImageList = returnExchangeImageManager.queryReturnExchangeImageListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#queryReturnExchangeImageListWithPage has error.", e);
        }
        return returnExchangeImageList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.delete")
    public boolean delete(ReturnExchangeImage returnExchangeImage) {
        boolean resultFlag = false;
        try {
            if (null != returnExchangeImage && null != returnExchangeImage.getId()) {
                resultFlag = returnExchangeImageManager.delete(returnExchangeImage);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.batchDelete")
    public boolean delete(ReturnExchangeImage[] returnExchangeImages) {
        boolean resultFlag = false;
        try {
            if (null != returnExchangeImages && returnExchangeImages.length > 0) {
                resultFlag = returnExchangeImageManager.delete(returnExchangeImages);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeImageService.getReturnExchangeImageById")
    public ReturnExchangeImage getReturnExchangeImageById(Long id) {
        ReturnExchangeImage returnExchangeImage = null;
        try {
            if (null != id) {
                returnExchangeImage = returnExchangeImageManager.getReturnExchangeImageById(id);
            } else {
                LOG.warn("ReturnExchangeImageServiceImpl#getReturnExchangeImageById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeImageServiceImpl#getReturnExchangeImageById has error.", e);
        }
        return returnExchangeImage;
    }
}

