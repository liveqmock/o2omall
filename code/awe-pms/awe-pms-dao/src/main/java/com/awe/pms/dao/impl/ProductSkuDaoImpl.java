package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductSkuDao;
import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductSkuDAO实现类<br/>
 * 对'商品SKU'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
@Repository
public class ProductSkuDaoImpl extends BaseDao implements ProductSkuDao {
    /** namespace */
    private final String namespace = ProductSkuDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductSku> queryProductSkuList(ProductSkuQuery queryBean) {
        return (List<ProductSku>) queryForList(namespace +".queryProductSkuList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductSku productSku) {
        return insert(namespace +".insert", productSku);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductSku productSku) {
        return update(namespace +".update", productSku);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductSkuCount(ProductSkuQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductSkuCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSku> queryProductSkuListWithPage(ProductSkuQuery queryBean) {
        return (List<ProductSku>) queryForList(namespace +".queryProductSkuListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductSku configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductSku getProductSkuById(Long id) {
        return (ProductSku) queryForObject(namespace +".getProductSkuById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductSku productSku) {
        int count = (Integer) queryForObject(namespace +".exist", productSku);
        return count > 0;
    }
}
