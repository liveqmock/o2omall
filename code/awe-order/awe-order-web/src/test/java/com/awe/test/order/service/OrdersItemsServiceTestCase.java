package com.awe.test.order.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;
import com.awe.order.service.OrdersItemsService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * OrdersItemsService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:37
 * 
 */
public class OrdersItemsServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private OrdersItemsService ordersItemsService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        String orderNo = null; //TODO 初始化
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        ordersItems.setSkuNo(skuNo);
        ordersItems.setCreateUser(TestConstants.UER_NAME);
        boolean result = ordersItemsService.insert(ordersItems);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        String orderNo = null; //TODO 初始化// 已经存在的
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化// 已经存在的
        ordersItems.setSkuNo(skuNo);
        ordersItems.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = ordersItemsService.insert(ordersItems);
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
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        ordersItems.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        ordersItems.setSkuNo(skuNo);
        ordersItems.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersItemsService.delete(ordersItems);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        ordersItems.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        ordersItems.setSkuNo(skuNo);
        ordersItems.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersItemsService.delete(ordersItems);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        ordersItems.setId(TEST_DEFAULT_EXIST_ID);
        String orderNo = null; //TODO 初始化
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        ordersItems.setSkuNo(skuNo);
        ordersItems.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersItemsService.update(ordersItems);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(ordersItemsService);
        OrdersItems ordersItems = new OrdersItems();
        ordersItems.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String orderNo = null; //TODO 初始化
        ordersItems.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        ordersItems.setSkuNo(skuNo);
        ordersItems.setUpdateUser(TestConstants.UER_NAME);
        boolean result = ordersItemsService.update(ordersItems);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(ordersItemsService);
        OrdersItems c = ordersItemsService.getOrdersItemsById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(ordersItemsService);
        OrdersItems c = ordersItemsService.getOrdersItemsById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(ordersItemsService);
        OrdersItemsQuery queryBean = null;
        PageUtil pageUtil = null;
        List<OrdersItems> list = ordersItemsService.queryOrdersItemsListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(ordersItemsService);
        OrdersItemsQuery queryBean = new OrdersItemsQuery();
        String orderNo = null; //TODO 初始化
        queryBean.setOrderNo(orderNo);
        String skuNo = null; //TODO 初始化
        queryBean.setSkuNo(skuNo);
        List<OrdersItems> list = ordersItemsService.queryOrdersItemsList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
