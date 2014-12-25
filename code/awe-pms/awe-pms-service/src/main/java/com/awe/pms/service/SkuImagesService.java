package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * SkuImagesService接口
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
public interface SkuImagesService {

    /**
     * 批量增加对象信息
     * 
     * @param skuImagesList
     * @return
     */
    public boolean insert(List<SkuImages> skuImagesList);

    /**
     * 单个增加对象信息
     * 
     * @param skuImages
     * @return
     */
    public boolean insert(SkuImages skuImages);

    /**
     * 更新 对象信息
     * 
     * @param skuImages
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(SkuImages skuImages);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<SkuImages> querySkuImagesList(SkuImagesQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<SkuImages> querySkuImagesListWithPage(SkuImagesQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param skuImages
     *            　
     * @return
     */
    public boolean delete(SkuImages skuImages);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public SkuImages getSkuImagesById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param skuImagess
     *            SkuImages集合
     * @return
     */
    public boolean delete(SkuImages[] skuImagess);
}
