package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ProductDictService接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
public interface ProductDictService {

    /**
     * 批量增加对象信息
     * 
     * @param productDictList
     * @return
     */
    public boolean insert(List<ProductDict> productDictList);

    /**
     * 单个增加对象信息
     * 
     * @param productDict
     * @return
     */
    public boolean insert(ProductDict productDict);

    /**
     * 更新 对象信息
     * 
     * @param productDict
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ProductDict productDict);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ProductDict> queryProductDictList(ProductDictQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ProductDict> queryProductDictListWithPage(ProductDictQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param productDict
     *            　
     * @return
     */
    public boolean delete(ProductDict productDict);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ProductDict getProductDictById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param productDicts
     *            ProductDict集合
     * @return
     */
    public boolean delete(ProductDict[] productDicts);
}
