package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.SkuImagesDao;
import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * SkuImagesDAO实现类<br/>
 * 对'sku图片'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:29
 * 
 */
@Repository
public class SkuImagesDaoImpl extends BaseDao implements SkuImagesDao {
    /** namespace */
    private final String namespace = SkuImagesDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<SkuImages> querySkuImagesList(SkuImagesQuery queryBean) {
        return (List<SkuImages>) queryForList(namespace +".querySkuImagesList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(SkuImages skuImages) {
        return insert(namespace +".insert", skuImages);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(SkuImages skuImages) {
        return update(namespace +".update", skuImages);
    }

    /**
     * {@inheritDoc}
     */
    public int querySkuImagesCount(SkuImagesQuery queryBean) {
        return (Integer) queryForObject(namespace +".querySkuImagesCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<SkuImages> querySkuImagesListWithPage(SkuImagesQuery queryBean) {
        return (List<SkuImages>) queryForList(namespace +".querySkuImagesListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(SkuImages configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public SkuImages getSkuImagesById(Long id) {
        return (SkuImages) queryForObject(namespace +".getSkuImagesById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(SkuImages skuImages) {
        int count = (Integer) queryForObject(namespace +".exist", skuImages);
        return count > 0;
    }
}
