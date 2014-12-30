package com.awe.pms.manager;

import java.util.List;

import com.awe.pms.domain.ProductTaxRate;
import com.awe.pms.domain.query.ProductTaxRateQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ProductTaxRateManager接口
 * 
 * @author ljz
 * @version 2014-12-29 11:45:53
 * 
 */
public interface ProductTaxRateManager {

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
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryProductTaxRateCount(ProductTaxRateQuery queryBean);

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

    /**
     * 判断是否存在
     * 
     * @param productTaxRate
     * @return
     */
    public boolean exist(ProductTaxRate productTaxRate);
}
