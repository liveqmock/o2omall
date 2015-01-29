package com.awe.order.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
import com.awe.order.manager.TaskOrdersManager;
import com.awe.order.service.TaskOrdersService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * TaskOrdersService接口的实现类
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
@Service
public class TaskOrdersServiceImpl implements TaskOrdersService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(TaskOrdersServiceImpl.class);

    @Autowired
    private TaskOrdersManager taskOrdersManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.batchInsert")
    public boolean insert(List<TaskOrders> taskOrdersList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(taskOrdersList)) {
                resultFlag = taskOrdersManager.insert(taskOrdersList);
            } else {
                LOG.warn("TaskOrdersServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.insert")
    public boolean insert(TaskOrders taskOrders) {
        boolean resultFlag = false;
        try {
            if (null != taskOrders) {
                if (taskOrdersManager.exist(taskOrders)) {
                    throw new ExistedException();
                }
                resultFlag = taskOrdersManager.insert(taskOrders);
            } else {
                LOG.warn("TaskOrdersServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("TaskOrdersServiceImpl#insert failed, taskOrders has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.update")
    public boolean update(TaskOrders taskOrders) {
        boolean resultFlag = false;
        try {
            if (null != taskOrders && null != taskOrders.getId()) {
                resultFlag = taskOrdersManager.update(taskOrders);
            } else {
                LOG.warn("TaskOrdersServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.queryTaskOrdersList")
    public List<TaskOrders> queryTaskOrdersList(TaskOrdersQuery queryBean) {
        List<TaskOrders> taskOrdersList = null;
        try {
            taskOrdersList = taskOrdersManager.queryTaskOrdersList(queryBean);
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#queryTaskOrdersList has error.", e);
        }
        return taskOrdersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.queryTaskOrdersListWithPage")
    public List<TaskOrders> queryTaskOrdersListWithPage(TaskOrdersQuery queryBean, PageUtil pageUtil) {
        List<TaskOrders> taskOrdersList = null;
        try {
            taskOrdersList = taskOrdersManager.queryTaskOrdersListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#queryTaskOrdersListWithPage has error.", e);
        }
        return taskOrdersList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.delete")
    public boolean delete(TaskOrders taskOrders) {
        boolean resultFlag = false;
        try {
            if (null != taskOrders && null != taskOrders.getId()) {
                resultFlag = taskOrdersManager.delete(taskOrders);
            } else {
                LOG.warn("TaskOrdersServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.batchDelete")
    public boolean delete(TaskOrders[] taskOrderss) {
        boolean resultFlag = false;
        try {
            if (null != taskOrderss && taskOrderss.length > 0) {
                resultFlag = taskOrdersManager.delete(taskOrderss);
            } else {
                LOG.warn("TaskOrdersServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "TaskOrdersService.getTaskOrdersById")
    public TaskOrders getTaskOrdersById(Long id) {
        TaskOrders taskOrders = null;
        try {
            if (null != id) {
                taskOrders = taskOrdersManager.getTaskOrdersById(id);
            } else {
                LOG.warn("TaskOrdersServiceImpl#getTaskOrdersById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("TaskOrdersServiceImpl#getTaskOrdersById has error.", e);
        }
        return taskOrders;
    }
}

