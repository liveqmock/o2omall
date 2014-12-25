package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
/**
 * ProductBrandDao接口<br/>
 * 对'商品类别品牌'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
public interface ProductBrandDao {
    
    /**
     * 新增对象
     * 
     * @param productBrand 
     * @return
     */
    public boolean insert(ProductBrand productBrand);

    /**
     * 更新对象
     * 
     * @param productBrand
     * @return
     */
    public boolean update(ProductBrand productBrand);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductBrand> queryProductBrandList(ProductBrandQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductBrandCount(ProductBrandQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductBrand> queryProductBrandListWithPage(ProductBrandQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productBrand
     * @return
     */
    public boolean delete(ProductBrand productBrand);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductBrand getProductBrandById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productBrand
     * @return
     */
    public boolean exist(ProductBrand productBrand);

}
