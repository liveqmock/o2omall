package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
/**
 * ProductDao接口<br/>
 * 对'商品信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:28
 * 
 */
public interface ProductDao {
    
    /**
     * 新增对象
     * 
     * @param product 
     * @return
     */
    public boolean insert(Product product);

    /**
     * 更新对象
     * 
     * @param product
     * @return
     */
    public boolean update(Product product);
    
    /**
     * 获取当前商品编码最大值，若没有则选择默认的
     * @return
     */
    public Product queryMaxProductNo(int mode);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Product> queryProductList(ProductQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductCount(ProductQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Product> queryProductListWithPage(ProductQuery queryBean);

    /**
     * 删除记录
     * 
     * @param product
     * @return
     */
    public boolean delete(Product product);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Product getProductById(Long id);

    /**
     * 判断是否存在
     * 
     * @param product
     * @return
     */
    public boolean exist(Product product);

}
