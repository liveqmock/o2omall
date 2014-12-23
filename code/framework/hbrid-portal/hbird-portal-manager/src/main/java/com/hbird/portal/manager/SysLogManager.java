package com.hbird.portal.manager;

import java.util.List;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.query.SysLogQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface SysLogManager {

    /**
     * 批量增加对象信息
     * 
     * @param beanList
     * @return
     */
    boolean insert(List<SysLog> beanList);

    /**
     * 单个增加对象信息
     * 
     * @param bean
     * @return
     */
    boolean insert(SysLog bean);

    /**
     * 更新 对象信息
     * 
     * @param bean
     *            对象信息对象
     * @return false：失败 true：成功
     */
    boolean update(SysLog bean);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    List<SysLog> querySysLogList(SysLogQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    PaginatedArrayList<SysLog> querySysLogListWithPage(SysLogQuery queryBean, int pageIndex, int pageSize);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    int querySysLogCount(SysLogQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param id
     *            主键字段
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    SysLog getSysLogById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param ids
     *            主键集合
     * @return
     */
    boolean delete(String[] ids);
}
