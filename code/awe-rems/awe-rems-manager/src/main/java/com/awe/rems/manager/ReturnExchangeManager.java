package com.awe.rems.manager;

import java.util.List;

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ReturnExchangeManager接口
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
public interface ReturnExchangeManager {

    /**
     * 批量增加对象信息
     * 
     * @param returnExchangeList
     * @return
     */
    public boolean insert(List<ReturnExchange> returnExchangeList);

    /**
     * 单个增加对象信息
     * 
     * @param returnExchange
     * @return
     */
    public boolean insert(ReturnExchange returnExchange);

    /**
     * 更新 对象信息
     * 
     * @param returnExchange
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ReturnExchange returnExchange);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ReturnExchange> queryReturnExchangeList(ReturnExchangeQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ReturnExchange> queryReturnExchangeListWithPage(ReturnExchangeQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryReturnExchangeCount(ReturnExchangeQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param returnExchange
     *            　
     * @return
     */
    public boolean delete(ReturnExchange returnExchange);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ReturnExchange getReturnExchangeById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param returnExchanges
     *            ReturnExchange集合
     * @return
     */
    public boolean delete(ReturnExchange[] returnExchanges);

    /**
     * 判断是否存在
     * 
     * @param returnExchange
     * @return
     */
    public boolean exist(ReturnExchange returnExchange);
}
