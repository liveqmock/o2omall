package com.hbird.portal.service;

import java.util.List;

import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * SystemService接口
 * 
 * @author ljz
 * @version 2014-12-3 18:22:26
 * 
 */
public interface SystemService {

    /**
     * 批量增加对象信息
     * 
     * @param systemList
     * @return
     */
    public boolean insert(List<System> systemList);

    /**
     * 单个增加对象信息
     * 
     * @param system
     * @return
     */
    public boolean insert(System system);

    /**
     * 更新 对象信息
     * 
     * @param system
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(System system);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<System> querySystemList(SystemQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<System> querySystemListWithPage(SystemQuery queryBean, PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param system
     *            　
     * @return
     */
    public boolean delete(System system);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public System getSystemById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param systems
     *            System集合
     * @return
     */
    public boolean delete(System[] systems);
}
