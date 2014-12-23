package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * AreaService接口
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
 * 
 */
public interface AreaService {

    /**
     * 批量增加对象信息
     * 
     * @param areaList
     * @return
     */
    public boolean insert(List<Area> areaList);

    /**
     * 单个增加对象信息
     * 
     * @param area
     * @return
     */
    public boolean insert(Area area);

    /**
     * 更新 对象信息
     * 
     * @param area
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Area area);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Area> queryAreaList(AreaQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Area> queryAreaListWithPage(AreaQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param area
     *            　
     * @return
     */
    public boolean delete(Area area);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Area getAreaById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param areas
     *            Area集合
     * @return
     */
    public boolean delete(Area[] areas);
}
