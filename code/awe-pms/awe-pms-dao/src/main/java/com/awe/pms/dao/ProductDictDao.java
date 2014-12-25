package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
/**
 * ProductDictDao接口<br/>
 * 对'配置表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
public interface ProductDictDao {
    
    /**
     * 新增对象
     * 
     * @param productDict 
     * @return
     */
    public boolean insert(ProductDict productDict);

    /**
     * 更新对象
     * 
     * @param productDict
     * @return
     */
    public boolean update(ProductDict productDict);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductDict> queryProductDictList(ProductDictQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductDictCount(ProductDictQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductDict> queryProductDictListWithPage(ProductDictQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productDict
     * @return
     */
    public boolean delete(ProductDict productDict);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductDict getProductDictById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productDict
     * @return
     */
    public boolean exist(ProductDict productDict);

}
