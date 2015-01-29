package com.awe.order.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
import com.awe.order.dao.TaskOrdersDao;
import com.awe.order.manager.TaskOrdersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TaskOrdersManager接口的实现类
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
 * 
 */
@Component
public class TaskOrdersManagerImpl extends BaseManager implements TaskOrdersManager {
	
    @Autowired
    private TaskOrdersDao taskOrdersDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<TaskOrders> taskOrdersList) {
        boolean resultFlag = false;
        if (null != taskOrdersList && taskOrdersList.size() > 0) {
            for (TaskOrders taskOrders : taskOrdersList) {
                resultFlag = taskOrdersDao.insert(taskOrders);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(TaskOrders taskOrders) {
        return taskOrdersDao.insert(taskOrders);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final TaskOrders taskOrders) {
        return taskOrdersDao.update(taskOrders);
    }

    /**
     * {@inheritDoc}
     */
    public List<TaskOrders> queryTaskOrdersList(TaskOrdersQuery queryBean) {
        return taskOrdersDao.queryTaskOrdersList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<TaskOrders> queryTaskOrdersListWithPage(TaskOrdersQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new TaskOrdersQuery();
        }

        // 查询总数
        int totalItem = queryTaskOrdersCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return taskOrdersDao.queryTaskOrdersListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryTaskOrdersCount(TaskOrdersQuery queryBean) {
        return taskOrdersDao.queryTaskOrdersCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(TaskOrders taskOrders) {
        return taskOrdersDao.delete(taskOrders);
    }

    /**
     * {@inheritDoc}
     */
    public TaskOrders getTaskOrdersById(Long id) {
        return taskOrdersDao.getTaskOrdersById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final TaskOrders[] taskOrderss) {
        boolean resultFlag = false;
        if (null != taskOrderss && taskOrderss.length > 0) {
            for (int i = 0; i < taskOrderss.length; i++) {
                resultFlag = delete(taskOrderss[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(TaskOrders taskOrders) {
        return taskOrdersDao.exist(taskOrders);
    }
}
