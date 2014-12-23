package com.hbird.portal.dao;

import java.util.List;

import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
public interface DepDao {

    /**
     * 新增对象
     * 
     * @param bean
     * @return
     */
    boolean insert(Dep bean);

    /**
     * 更新对象
     * 
     * @param bean
     * @return
     */
    boolean update(Dep bean);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    List<Dep> queryDepList(DepQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    int queryDepCount(DepQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    List<Dep> queryDepListWithPage(DepQuery queryBean);

    /**
     * 根据主键删除记录
     * 
     * @param id
     * @return
     */
    boolean deleteDepById(Long id);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    Dep getDepById(Long id);

    /**
     * 根据部门编号获取部门信息
     * 
     * @param code
     * @return
     */
    Dep getDepByCode(String code);
}
