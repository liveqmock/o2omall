package com.awe.test.order.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.service.OrderCancelService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * OrderCancelService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class OrderCancelServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private OrderCancelService orderCancelService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        String refund = null; //TODO 初始化
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化
        orderCancel.setStatus(status);
        orderCancel.setCreateUser(TestConstants.UER_NAME);
        boolean result = orderCancelService.insert(orderCancel);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        String refund = null; //TODO 初始化// 已经存在的
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化// 已经存在的
        orderCancel.setStatus(status);
        orderCancel.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = orderCancelService.insert(orderCancel);
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
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        orderCancel.setId(TEST_DEFAULT_EXIST_ID);
        String refund = null; //TODO 初始化
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化
        orderCancel.setStatus(status);
        orderCancel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderCancelService.delete(orderCancel);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        orderCancel.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String refund = null; //TODO 初始化
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化
        orderCancel.setStatus(status);
        orderCancel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderCancelService.delete(orderCancel);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        orderCancel.setId(TEST_DEFAULT_EXIST_ID);
        String refund = null; //TODO 初始化
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化
        orderCancel.setStatus(status);
        orderCancel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderCancelService.update(orderCancel);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(orderCancelService);
        OrderCancel orderCancel = new OrderCancel();
        orderCancel.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String refund = null; //TODO 初始化
        orderCancel.setRefund(refund);
        Integer status = null; //TODO 初始化
        orderCancel.setStatus(status);
        orderCancel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderCancelService.update(orderCancel);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(orderCancelService);
        OrderCancel c = orderCancelService.getOrderCancelById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(orderCancelService);
        OrderCancel c = orderCancelService.getOrderCancelById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(orderCancelService);
        OrderCancelQuery queryBean = null;
        PageUtil pageUtil = null;
        List<OrderCancel> list = orderCancelService.queryOrderCancelListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(orderCancelService);
        OrderCancelQuery queryBean = new OrderCancelQuery();
        String refund = null; //TODO 初始化
        queryBean.setRefund(refund);
        Integer status = null; //TODO 初始化
        queryBean.setStatus(status);
        List<OrderCancel> list = orderCancelService.queryOrderCancelList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
