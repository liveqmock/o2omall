package com.awe.rems.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.rems.dao.ReturnExchangeImageDao;
import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ReturnExchangeImageDAO实现类<br/>
 * 对'退换货图片表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
@Repository
public class ReturnExchangeImageDaoImpl extends BaseDao implements ReturnExchangeImageDao {
    /** namespace */
    private final String namespace = ReturnExchangeImageDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageList(ReturnExchangeImageQuery queryBean) {
        return (List<ReturnExchangeImage>) queryForList(namespace +".queryReturnExchangeImageList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ReturnExchangeImage returnExchangeImage) {
        return insert(namespace +".insert", returnExchangeImage);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ReturnExchangeImage returnExchangeImage) {
        return update(namespace +".update", returnExchangeImage);
    }

    /**
     * {@inheritDoc}
     */
    public int queryReturnExchangeImageCount(ReturnExchangeImageQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryReturnExchangeImageCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageListWithPage(ReturnExchangeImageQuery queryBean) {
        return (List<ReturnExchangeImage>) queryForList(namespace +".queryReturnExchangeImageListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ReturnExchangeImage configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ReturnExchangeImage getReturnExchangeImageById(Long id) {
        return (ReturnExchangeImage) queryForObject(namespace +".getReturnExchangeImageById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ReturnExchangeImage returnExchangeImage) {
        int count = (Integer) queryForObject(namespace +".exist", returnExchangeImage);
        return count > 0;
    }
}
