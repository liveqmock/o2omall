package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductTaxRateService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
public interface ProductTaxRateService {

    /**
     * 批量增加对象信息
     * 
     * @param productTaxRateList
     * @return
     */
    public boolean insert(List<ProductTaxRate> productTaxRateList);

    /**
     * 单个增加对象信息
     * 
     * @param productTaxRate
     * @return
     */
    public boolean insert(ProductTaxRate productTaxRate);

    /**
     * 更新 对象信息
     * 
     * @param productTaxRate
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductTaxRate productTaxRate);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductTaxRate> queryProductTaxRateList(ProductTaxRateQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductTaxRate> queryProductTaxRateListWithPage(ProductTaxRateQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productTaxRate
     *            　
     * @return
     */
    public boolean delete(ProductTaxRate productTaxRate);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductTaxRate getProductTaxRateById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productTaxRates
     *            ProductTaxRate集合
     * @return
     */
    public boolean delete(ProductTaxRate[] productTaxRates);
}
