package com.awe.rems.dao;

import java.util.List;

import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
/**
 * ReturnExchangeImageDao接口<br/>
 * 对'退换货图片表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:15
 * 
 */
public interface ReturnExchangeImageDao {
    
    /**
     * 新增对象
     * 
     * @param returnExchangeImage 
     * @return
     */
    public boolean insert(ReturnExchangeImage returnExchangeImage);

    /**
     * 更新对象
     * 
     * @param returnExchangeImage
     * @return
     */
    public boolean update(ReturnExchangeImage returnExchangeImage);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageList(ReturnExchangeImageQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryReturnExchangeImageCount(ReturnExchangeImageQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageListWithPage(ReturnExchangeImageQuery queryBean);

    /**
     * 删除记录
     * 
     * @param returnExchangeImage
     * @return
     */
    public boolean delete(ReturnExchangeImage returnExchangeImage);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ReturnExchangeImage getReturnExchangeImageById(Long id);

    /**
     * 判断是否存在
     * 
     * @param returnExchangeImage
     * @return
     */
    public boolean exist(ReturnExchangeImage returnExchangeImage);

}
