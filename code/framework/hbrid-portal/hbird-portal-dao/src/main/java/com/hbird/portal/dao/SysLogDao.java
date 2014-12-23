package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.query.SysLogQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface SysLogDao {

    /**
     * 新增对象
     * 
     * @param bean
     * @return
     */
    boolean insert(SysLog bean);

    /**
     * 更新对象
     * 
     * @param bean
     * @return
     */
    boolean update(SysLog bean);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    List<SysLog> querySysLogList(SysLogQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    int querySysLogCount(SysLogQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    List<SysLog> querySysLogListWithPage(SysLogQuery queryBean);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean deleteSysLogById(Long id);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    SysLog getSysLogById(Long id);
}
