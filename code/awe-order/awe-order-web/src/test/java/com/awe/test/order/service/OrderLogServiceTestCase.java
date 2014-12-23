package com.awe.test.order.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
import com.awe.order.service.OrderLogService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * OrderLogService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:37
 * 
 */
public class OrderLogServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private OrderLogService orderLogService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        String orderNo = null; //TODO 初始化
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        orderLog.setStatus(status);
        orderLog.setCreateUser(TestConstants.UER_NAME);
        boolean result = orderLogService.insert(orderLog);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        String orderNo = null; //TODO 初始化// 已经存在的
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化// 已经存在的
        orderLog.setStatus(status);
        orderLog.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = orderLogService.insert(orderLog);
            Assert.isTrue(!result);
        } catch (ExistedException e) {
            ex = e;
        }
        Assert.notNull(ex);
    }

    /**
     * 测试删除数据-成功
     */
    @Test
    public void testDelete() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        orderLog.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        orderLog.setStatus(status);
        orderLog.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderLogService.delete(orderLog);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        orderLog.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        orderLog.setStatus(status);
        orderLog.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderLogService.delete(orderLog);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        orderLog.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        orderLog.setStatus(status);
        orderLog.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderLogService.update(orderLog);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(orderLogService);
        OrderLog orderLog = new OrderLog();
        orderLog.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        orderLog.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        orderLog.setStatus(status);
        orderLog.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderLogService.update(orderLog);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(orderLogService);
        OrderLog c = orderLogService.getOrderLogById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(orderLogService);
        OrderLog c = orderLogService.getOrderLogById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(orderLogService);
        OrderLogQuery queryBean = null;
        PageUtil pageUtil = null;
        List<OrderLog> list = orderLogService.queryOrderLogListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(orderLogService);
        OrderLogQuery queryBean = new OrderLogQuery();
        String orderNo = null; //TODO 初始化
        queryBean.setOrderNo(orderNo);
        Integer status = null; //TODO 初始化
        queryBean.setStatus(status);
        List<OrderLog> list = orderLogService.queryOrderLogList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
