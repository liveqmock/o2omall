package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
/**
 * TaskOrdersDao接口<br/>
 * 对'作业表'表进行基本的操作
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
public interface TaskOrdersDao {
    
    /**
     * 新增对象
     * 
     * @param taskOrders 
     * @return
     */
    public boolean insert(TaskOrders taskOrders);

    /**
     * 更新对象
     * 
     * @param taskOrders
     * @return
     */
    public boolean update(TaskOrders taskOrders);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TaskOrders> queryTaskOrdersList(TaskOrdersQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryTaskOrdersCount(TaskOrdersQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<TaskOrders> queryTaskOrdersListWithPage(TaskOrdersQuery queryBean);

    /**
     * 删除记录
     * 
     * @param taskOrders
     * @return
     */
    public boolean delete(TaskOrders taskOrders);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public TaskOrders getTaskOrdersById(Long id);

    /**
     * 判断是否存在
     * 
     * @param taskOrders
     * @return
     */
    public boolean exist(TaskOrders taskOrders);

}
