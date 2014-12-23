package com.awe.pms.manager;

import java.util.List;

import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ProductCategoryManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
public interface ProductCategoryManager {

    /**
     * 批量增加对象信息
     * 
     * @param productCategoryList
     * @return
     */
    public boolean insert(List<ProductCategory> productCategoryList);

    /**
     * 单个增加对象信息
     * 
     * @param productCategory
     * @return
     */
    public boolean insert(ProductCategory productCategory);

    /**
     * 更新 对象信息
     * 
     * @param productCategory
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductCategory productCategory);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryProductCategoryCount(ProductCategoryQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productCategory
     *            　
     * @return
     */
    public boolean delete(ProductCategory productCategory);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductCategory getProductCategoryById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productCategorys
     *            ProductCategory集合
     * @return
     */
    public boolean delete(ProductCategory[] productCategorys);

    /**
     * 判断是否存在
     * 
     * @param productCategory
     * @return
     */
    public boolean exist(ProductCategory productCategory);
}
