package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
/**
 * ShoppingCartDao接口<br/>
 * 对'购物车'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
public interface ShoppingCartDao {
    
    /**
     * 新增对象
     * 
     * @param shoppingCart 
     * @return
     */
    public boolean insert(ShoppingCart shoppingCart);

    /**
     * 更新对象
     * 
     * @param shoppingCart
     * @return
     */
    public boolean update(ShoppingCart shoppingCart);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShoppingCart> queryShoppingCartList(ShoppingCartQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryShoppingCartCount(ShoppingCartQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShoppingCart> queryShoppingCartListWithPage(ShoppingCartQuery queryBean);

    /**
     * 删除记录
     * 
     * @param shoppingCart
     * @return
     */
    public boolean delete(ShoppingCart shoppingCart);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ShoppingCart getShoppingCartById(Long id);

    /**
     * 判断是否存在
     * 
     * @param shoppingCart
     * @return
     */
    public boolean exist(ShoppingCart shoppingCart);

}
