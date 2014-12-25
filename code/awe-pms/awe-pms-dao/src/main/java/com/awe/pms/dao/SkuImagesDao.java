package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
/**
 * SkuImagesDao接口<br/>
 * 对'sku图片'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-25 9:31:53
 * 
 */
public interface SkuImagesDao {
    
    /**
     * 新增对象
     * 
     * @param skuImages 
     * @return
     */
    public boolean insert(SkuImages skuImages);

    /**
     * 更新对象
     * 
     * @param skuImages
     * @return
     */
    public boolean update(SkuImages skuImages);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<SkuImages> querySkuImagesList(SkuImagesQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int querySkuImagesCount(SkuImagesQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<SkuImages> querySkuImagesListWithPage(SkuImagesQuery queryBean);

    /**
     * 删除记录
     * 
     * @param skuImages
     * @return
     */
    public boolean delete(SkuImages skuImages);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public SkuImages getSkuImagesById(Long id);

    /**
     * 判断是否存在
     * 
     * @param skuImages
     * @return
     */
    public boolean exist(SkuImages skuImages);

}
