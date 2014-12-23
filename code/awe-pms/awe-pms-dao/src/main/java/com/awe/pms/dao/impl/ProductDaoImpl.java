package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductDao;
import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductDAO实现类<br/>
 * 对'商品信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao {
    /** namespace */
    private final String namespace = ProductDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Product> queryProductList(ProductQuery queryBean) {
        return (List<Product>) queryForList(namespace +".queryProductList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Product product) {
        return insert(namespace +".insert", product);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Product product) {
        return update(namespace +".update", product);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductCount(ProductQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Product> queryProductListWithPage(ProductQuery queryBean) {
        return (List<Product>) queryForList(namespace +".queryProductListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Product configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Product getProductById(Long id) {
        return (Product) queryForObject(namespace +".getProductById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Product product) {
        int count = (Integer) queryForObject(namespace +".exist", product);
        return count > 0;
    }
}
