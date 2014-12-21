package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
/**
 * AreaDao接口<br/>
 * 对'三级地址基础信息'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
public interface AreaDao {
    
    /**
     * 新增对象
     * 
     * @param area 
     * @return
     */
    public boolean insert(Area area);

    /**
     * 更新对象
     * 
     * @param area
     * @return
     */
    public boolean update(Area area);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Area> queryAreaList(AreaQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryAreaCount(AreaQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Area> queryAreaListWithPage(AreaQuery queryBean);

    /**
     * 删除记录
     * 
     * @param area
     * @return
     */
    public boolean delete(Area area);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Area getAreaById(Long id);

    /**
     * 判断是否存在
     * 
     * @param area
     * @return
     */
    public boolean exist(Area area);

}
