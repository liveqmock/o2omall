package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;
/**
 * ProductSelectDao接口<br/>
 * 对'商品查询综合表'表进行基本的操作
 * 
 * @author ljz
 * @version 2015-1-21 10:47:32
 * 
 */
public interface ProductSelectDao {
    
    /**
     * 新增对象
     * 
     * @param productSelect 
     * @return
     */
    public boolean insert(ProductSelect productSelect);

    /**
     * 更新对象
     * 
     * @param productSelect
     * @return
     */
    public boolean update(ProductSelect productSelect);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSelect> queryProductSelectList(ProductSelectQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryProductSelectCount(ProductSelectQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductSelect> queryProductSelectListWithPage(ProductSelectQuery queryBean);

    /**
     * 删除记录
     * 
     * @param productSelect
     * @return
     */
    public boolean delete(ProductSelect productSelect);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ProductSelect getProductSelectById(Long id);

    /**
     * 判断是否存在
     * 
     * @param productSelect
     * @return
     */
    public boolean exist(ProductSelect productSelect);

}
