package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
/**
 * ProductCategoryDao接口<br/>
 * 对'商品类别'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
public interface ProductCategoryDao {
    
    /**
     * 新增对象
     * 
     * @param productCategory 
     * @return
     */
    public boolean insert(ProductCategory productCategory);

    /**
     * 更新对象
     * 
     * @param productCategory
     * @return
     */
    public boolean update(ProductCategory productCategory);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductCategory> queryProductCategoryList(ProductCategoryQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductCategoryCount(ProductCategoryQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductCategory> queryProductCategoryListWithPage(ProductCategoryQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productCategory
     * @return
     */
    public boolean delete(ProductCategory productCategory);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductCategory getProductCategoryById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productCategory
     * @return
     */
    public boolean exist(ProductCategory productCategory);

}
