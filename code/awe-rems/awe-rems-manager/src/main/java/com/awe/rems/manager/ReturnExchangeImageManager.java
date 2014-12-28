package com.awe.rems.manager;

import java.util.List;

import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ReturnExchangeImageManager接口
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
public interface ReturnExchangeImageManager {

    /**
     * 批量增加对象信息
     * 
     * @param returnExchangeImageList
     * @return
     */
    public boolean insert(List<ReturnExchangeImage> returnExchangeImageList);

    /**
     * 单个增加对象信息
     * 
     * @param returnExchangeImage
     * @return
     */
    public boolean insert(ReturnExchangeImage returnExchangeImage);

    /**
     * 更新 对象信息
     * 
     * @param returnExchangeImage
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ReturnExchangeImage returnExchangeImage);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageList(ReturnExchangeImageQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ReturnExchangeImage> queryReturnExchangeImageListWithPage(ReturnExchangeImageQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryReturnExchangeImageCount(ReturnExchangeImageQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param returnExchangeImage
     *            　
     * @return
     */
    public boolean delete(ReturnExchangeImage returnExchangeImage);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ReturnExchangeImage getReturnExchangeImageById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param returnExchangeImages
     *            ReturnExchangeImage集合
     * @return
     */
    public boolean delete(ReturnExchangeImage[] returnExchangeImages);

    /**
     * 判断是否存在
     * 
     * @param returnExchangeImage
     * @return
     */
    public boolean exist(ReturnExchangeImage returnExchangeImage);
}
