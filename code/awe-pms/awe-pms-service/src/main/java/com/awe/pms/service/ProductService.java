package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductService接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductService {

    /**
     * 批量增加对象信息
     * 
     * @param productList
     * @return
     */
    public boolean insert(List<Product> productList);

    /**
     * 单个增加对象信息
     * 
     * @param product
     * @return
     */
    public boolean insert(Product product);

    /**
     * 更新 对象信息
     * 
     * @param product
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Product product);
    
    /**
     * 获取当前商品编码最大值，若没有则选择默认的
     * @param mode 
     * @return
     */
    public String queryMaxProductNo(int mode);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Product> queryProductList(ProductQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Product> queryProductListWithPage(ProductQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param product
     *            　
     * @return
     */
    public boolean delete(Product product);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Product getProductById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param products
     *            Product集合
     * @return
     */
    public boolean delete(Product[] products);
}
