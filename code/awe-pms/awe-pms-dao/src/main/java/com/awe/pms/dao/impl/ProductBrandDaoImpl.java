package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductBrandDao;
import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductBrandDAO实现类<br/>
 * 对'商品类别品牌'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
@Repository
public class ProductBrandDaoImpl extends BaseDao implements ProductBrandDao {
    /** namespace */
    private final String namespace = ProductBrandDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductBrand> queryProductBrandList(ProductBrandQuery queryBean) {
        return (List<ProductBrand>) queryForList(namespace +".queryProductBrandList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductBrand productBrand) {
        return insert(namespace +".insert", productBrand);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductBrand productBrand) {
        return update(namespace +".update", productBrand);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductBrandCount(ProductBrandQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductBrandCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductBrand> queryProductBrandListWithPage(ProductBrandQuery queryBean) {
        return (List<ProductBrand>) queryForList(namespace +".queryProductBrandListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductBrand configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductBrand getProductBrandById(Long id) {
        return (ProductBrand) queryForObject(namespace +".getProductBrandById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductBrand productBrand) {
        int count = (Integer) queryForObject(namespace +".exist", productBrand);
        return count > 0;
    }
}
