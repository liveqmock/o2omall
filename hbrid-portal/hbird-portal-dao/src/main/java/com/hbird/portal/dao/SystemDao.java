package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;

/**
 * SystemDao接口<br/>
 * 对'业务系统'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
public interface SystemDao {

    /**
     * 新增对象
     * 
     * @param system
     * @return
     */
    public boolean insert(System system);

    /**
     * 更新对象
     * 
     * @param system
     * @return
     */
    public boolean update(System system);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<System> querySystemList(SystemQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int querySystemCount(SystemQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<System> querySystemListWithPage(SystemQuery queryBean);

    /**
     * 删除记录
     * 
     * @param system
     * @return
     */
    public boolean delete(System system);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public System getSystemById(Long id);

    /**
     * 判断是否存在
     * 
     * @param system
     * @return
     */
    public boolean exist(System system);

}
