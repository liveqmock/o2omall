package com.awe.test.order.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.service.OrdersService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * OrdersService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrdersServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private OrdersService ordersService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        String orderNo = null; //TODO 初始化
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        orders.setOrderType(orderType);
        orders.setCreateUser(TestConstants.UER_NAME);
        boolean result = ordersService.insert(orders);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        String orderNo = null; //TODO 初始化// 已经存在的
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化// 已经存在的
        orders.setOrderType(orderType);
        orders.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = ordersService.insert(orders);
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
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        orders.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        orders.setOrderType(orderType);
        orders.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersService.delete(orders);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        orders.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        orders.setOrderType(orderType);
        orders.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersService.delete(orders);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        orders.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        orders.setOrderType(orderType);
        orders.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersService.update(orders);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(ordersService);
        Orders orders = new Orders();
        orders.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        orders.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        orders.setOrderType(orderType);
        orders.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersService.update(orders);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(ordersService);
        Orders c = ordersService.getOrdersById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(ordersService);
        Orders c = ordersService.getOrdersById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(ordersService);
        OrdersQuery queryBean = null;
        PageUtil pageUtil = null;
        List<Orders> list = ordersService.queryOrdersListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(ordersService);
        OrdersQuery queryBean = new OrdersQuery();
        String orderNo = null; //TODO 初始化
        queryBean.setOrderNo(orderNo);
        Integer orderType = null; //TODO 初始化
        queryBean.setOrderType(orderType);
        List<Orders> list = ordersService.queryOrdersList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
