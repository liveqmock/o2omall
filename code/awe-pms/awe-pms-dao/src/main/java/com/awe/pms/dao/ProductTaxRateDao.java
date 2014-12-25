package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
/**
 * ProductTaxRateDao接口<br/>
 * 对'税率'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 14:47:28
 * 
 */
public interface ProductTaxRateDao {
    
    /**
     * 新增对象
     * 
     * @param productTaxRate 
     * @return
     */
    public boolean insert(ProductTaxRate productTaxRate);

    /**
     * 更新对象
     * 
     * @param productTaxRate
     * @return
     */
    public boolean update(ProductTaxRate productTaxRate);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductTaxRate> queryProductTaxRateList(ProductTaxRateQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductTaxRateCount(ProductTaxRateQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductTaxRate> queryProductTaxRateListWithPage(ProductTaxRateQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productTaxRate
     * @return
     */
    public boolean delete(ProductTaxRate productTaxRate);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductTaxRate getProductTaxRateById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productTaxRate
     * @return
     */
    public boolean exist(ProductTaxRate productTaxRate);

}
