package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductCategoryDao;
import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductCategoryDAO实现类<br/>
 * 对'商品类别'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
@Repository
public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {
    /** namespace */
    private final String namespace = ProductCategoryDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean) {
        return (List<ProductCategory>) queryForList(namespace +".queryProductCategoryList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductCategory productCategory) {
        return insert(namespace +".insert", productCategory);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductCategory productCategory) {
        return update(namespace +".update", productCategory);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductCategoryCount(ProductCategoryQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductCategoryCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean) {
        return (List<ProductCategory>) queryForList(namespace +".queryProductCategoryListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductCategory configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductCategory getProductCategoryById(Long id) {
        return (ProductCategory) queryForObject(namespace +".getProductCategoryById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductCategory productCategory) {
        int count = (Integer) queryForObject(namespace +".exist", productCategory);
        return count > 0;
    }
}
