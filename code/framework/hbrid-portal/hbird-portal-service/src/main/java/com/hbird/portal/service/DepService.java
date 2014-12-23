package com.hbird.portal.service;

import java.util.List;

import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;
import com.hbird.common.utils.page.PaginatedArrayList;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface DepService {

    /**
     * 批量增加对象信息
     * 
     * @param beanList
     * @return
     */
    boolean insert(List<Dep> beanList);

    /**
     * 单个增加对象信息
     * 
     * @param bean
     * @return
     */
    boolean insert(Dep bean);

    /**
     * 根据主键更新对象信息
     * 
     * @param bean
     *            对象信息对象
     * @return Result 对象
     */
    boolean update(Dep bean);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    List<Dep> queryDepList(DepQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    PaginatedArrayList<Dep> queryDepListWithPage(DepQuery queryBean, int pageIndex, int pageSize);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据对象信息ID，主键获取对象信息
     * 
     * @param id
     * @return
     */
    Dep getDepById(Long id);

    /**
     * 根据主键集合删除对象信息，该处做的是逻辑删除
     * 
     * @param ids
     *            主键集合
     * @return
     */
    boolean delete(String[] ids);

}
