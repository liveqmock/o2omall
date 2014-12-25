package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductTaxRateDao;
import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductTaxRateDAO实现类<br/>
 * 对'税率'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:29
 * 
 */
@Repository
public class ProductTaxRateDaoImpl extends BaseDao implements ProductTaxRateDao {
    /** namespace */
    private final String namespace = ProductTaxRateDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductTaxRate> queryProductTaxRateList(ProductTaxRateQuery queryBean) {
        return (List<ProductTaxRate>) queryForList(namespace +".queryProductTaxRateList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductTaxRate productTaxRate) {
        return insert(namespace +".insert", productTaxRate);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductTaxRate productTaxRate) {
        return update(namespace +".update", productTaxRate);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductTaxRateCount(ProductTaxRateQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductTaxRateCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductTaxRate> queryProductTaxRateListWithPage(ProductTaxRateQuery queryBean) {
        return (List<ProductTaxRate>) queryForList(namespace +".queryProductTaxRateListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductTaxRate configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductTaxRate getProductTaxRateById(Long id) {
        return (ProductTaxRate) queryForObject(namespace +".getProductTaxRateById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductTaxRate productTaxRate) {
        int count = (Integer) queryForObject(namespace +".exist", productTaxRate);
        return count > 0;
    }
}
