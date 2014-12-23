package com.awe.order.service;

import java.util.List;

import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ShoppingCartService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public interface ShoppingCartService {

    /**
     * 批量增加对象信息
     * 
     * @param shoppingCartList
     * @return
     */
    public boolean insert(List<ShoppingCart> shoppingCartList);

    /**
     * 单个增加对象信息
     * 
     * @param shoppingCart
     * @return
     */
    public boolean insert(ShoppingCart shoppingCart);

    /**
     * 更新 对象信息
     * 
     * @param shoppingCart
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ShoppingCart shoppingCart);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ShoppingCart> queryShoppingCartList(ShoppingCartQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ShoppingCart> queryShoppingCartListWithPage(ShoppingCartQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param shoppingCart
     *            　
     * @return
     */
    public boolean delete(ShoppingCart shoppingCart);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ShoppingCart getShoppingCartById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param shoppingCarts
     *            ShoppingCart集合
     * @return
     */
    public boolean delete(ShoppingCart[] shoppingCarts);
}
