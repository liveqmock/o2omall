package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
/**
 * ProductSkuDao接口<br/>
 * 对'商品SKU'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:28
 * 
 */
public interface ProductSkuDao {
    
    /**
     * 新增对象
     * 
     * @param productSku 
     * @return
     */
    public boolean insert(ProductSku productSku);

    /**
     * 更新对象
     * 
     * @param productSku
     * @return
     */
    public boolean update(ProductSku productSku);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSku> queryProductSkuList(ProductSkuQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductSkuCount(ProductSkuQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSku> queryProductSkuListWithPage(ProductSkuQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productSku
     * @return
     */
    public boolean delete(ProductSku productSku);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductSku getProductSkuById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productSku
     * @return
     */
    public boolean exist(ProductSku productSku);

}
