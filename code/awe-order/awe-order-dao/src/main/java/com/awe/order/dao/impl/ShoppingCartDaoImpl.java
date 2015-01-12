package com.awe.order.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.order.dao.ShoppingCartDao;
import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ShoppingCartDAO实现类<br/>
 * 对'购物车'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:58:05
 * 
 */
@Repository
public class ShoppingCartDaoImpl extends BaseDao implements ShoppingCartDao {
    /** namespace */
    private final String namespace = ShoppingCartDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<ShoppingCart> queryShoppingCartList(ShoppingCartQuery queryBean) {
        return (List<ShoppingCart>) queryForList(namespace +".queryShoppingCartList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(ShoppingCart shoppingCart) {
        return insert(namespace +".insert", shoppingCart);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(ShoppingCart shoppingCart) {
        return update(namespace +".update", shoppingCart);
    }

    /**
     * {@inheritDoc}
     */
    public int queryShoppingCartCount(ShoppingCartQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryShoppingCartCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ShoppingCart> queryShoppingCartListWithPage(ShoppingCartQuery queryBean) {
        return (List<ShoppingCart>) queryForList(namespace +".queryShoppingCartListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ShoppingCart configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public ShoppingCart getShoppingCartById(Long id) {
        return (ShoppingCart) queryForObject(namespace +".getShoppingCartById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(ShoppingCart shoppingCart) {
        int count = (Integer) queryForObject(namespace +".exist", shoppingCart);
        return count > 0;
    }

	public ShoppingCart getShoppingCart(ShoppingCart shoppingCart) {
		
		return (ShoppingCart) queryForObject(namespace +".getShoppingCart", shoppingCart);
	}
}
