package com.awe.pms.manager;

import java.util.List;

import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ProductBrandManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
public interface ProductBrandManager {

    /**
     * 批量增加对象信息
     * 
     * @param productBrandList
     * @return
     */
    public boolean insert(List<ProductBrand> productBrandList);

    /**
     * 单个增加对象信息
     * 
     * @param productBrand
     * @return
     */
    public boolean insert(ProductBrand productBrand);

    /**
     * 更新 对象信息
     * 
     * @param productBrand
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductBrand productBrand);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductBrand> queryProductBrandList(ProductBrandQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductBrand> queryProductBrandListWithPage(ProductBrandQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryProductBrandCount(ProductBrandQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productBrand
     *            　
     * @return
     */
    public boolean delete(ProductBrand productBrand);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductBrand getProductBrandById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productBrands
     *            ProductBrand集合
     * @return
     */
    public boolean delete(ProductBrand[] productBrands);

    /**
     * 判断是否存在
     * 
     * @param productBrand
     * @return
     */
    public boolean exist(ProductBrand productBrand);
}
