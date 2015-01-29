package com.awe.order.manager;

import java.util.List;

import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * TaskOrdersManager接口
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
public interface TaskOrdersManager {

    /**
     * 批量增加对象信息
     * 
     * @param taskOrdersList
     * @return
     */
    public boolean insert(List<TaskOrders> taskOrdersList);

    /**
     * 单个增加对象信息
     * 
     * @param taskOrders
     * @return
     */
    public boolean insert(TaskOrders taskOrders);

    /**
     * 更新 对象信息
     * 
     * @param taskOrders
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(TaskOrders taskOrders);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TaskOrders> queryTaskOrdersList(TaskOrdersQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<TaskOrders> queryTaskOrdersListWithPage(TaskOrdersQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryTaskOrdersCount(TaskOrdersQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param taskOrders
     *            　
     * @return
     */
    public boolean delete(TaskOrders taskOrders);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public TaskOrders getTaskOrdersById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param taskOrderss
     *            TaskOrders集合
     * @return
     */
    public boolean delete(TaskOrders[] taskOrderss);

    /**
     * 判断是否存在
     * 
     * @param taskOrders
     * @return
     */
    public boolean exist(TaskOrders taskOrders);
}
