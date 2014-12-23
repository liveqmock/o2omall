package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductDictDao;
import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductDictDAO实现类<br/>
 * 对'配置表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
@Repository
public class ProductDictDaoImpl extends BaseDao implements ProductDictDao {
    /** namespace */
    private final String namespace = ProductDictDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductDict> queryProductDictList(ProductDictQuery queryBean) {
        return (List<ProductDict>) queryForList(namespace +".queryProductDictList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductDict productDict) {
        return insert(namespace +".insert", productDict);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductDict productDict) {
        return update(namespace +".update", productDict);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductDictCount(ProductDictQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductDictCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductDict> queryProductDictListWithPage(ProductDictQuery queryBean) {
        return (List<ProductDict>) queryForList(namespace +".queryProductDictListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductDict configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductDict getProductDictById(Long id) {
        return (ProductDict) queryForObject(namespace +".getProductDictById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductDict productDict) {
        int count = (Integer) queryForObject(namespace +".exist", productDict);
        return count > 0;
    }
}
