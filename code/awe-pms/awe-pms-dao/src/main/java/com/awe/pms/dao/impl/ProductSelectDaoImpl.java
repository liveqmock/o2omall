package com.awe.pms.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.pms.dao.ProductSelectDao;
import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ProductSelectDAO实现类<br/>
 * 对'商品查询综合表'表进行基本的操作
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
@Repository
public class ProductSelectDaoImpl extends BaseDao implements ProductSelectDao {
    /** namespace */
    private final String namespace = ProductSelectDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ProductSelect> queryProductSelectList(ProductSelectQuery queryBean) {
        return (List<ProductSelect>) queryForList(namespace +".queryProductSelectList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ProductSelect productSelect) {
        return insert(namespace +".insert", productSelect);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ProductSelect productSelect) {
        return update(namespace +".update", productSelect);
    }

    /**
     * {@inheritDoc}
     */
    public int queryProductSelectCount(ProductSelectQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryProductSelectCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ProductSelect> queryProductSelectListWithPage(ProductSelectQuery queryBean) {
        return (List<ProductSelect>) queryForList(namespace +".queryProductSelectListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ProductSelect configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ProductSelect getProductSelectById(Long id) {
        return (ProductSelect) queryForObject(namespace +".getProductSelectById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ProductSelect productSelect) {
        int count = (Integer) queryForObject(namespace +".exist", productSelect);
        return count > 0;
    }
}
