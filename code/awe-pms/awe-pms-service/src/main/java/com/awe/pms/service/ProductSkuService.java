package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductSkuService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
public interface ProductSkuService {

    /**
     * 批量增加对象信息
     * 
     * @param productSkuList
     * @return
     */
    public boolean insert(List<ProductSku> productSkuList);

    /**
     * 单个增加对象信息
     * 
     * @param productSku
     * @return
     */
    public boolean insert(ProductSku productSku);

    /**
     * 更新 对象信息
     * 
     * @param productSku
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductSku productSku);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSku> queryProductSkuList(ProductSkuQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductSku> queryProductSkuListWithPage(ProductSkuQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productSku
     *            　
     * @return
     */
    public boolean delete(ProductSku productSku);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductSku getProductSkuById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productSkus
     *            ProductSku集合
     * @return
     */
    public boolean delete(ProductSku[] productSkus);
}