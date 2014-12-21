package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
import com.awe.uc.service.OrderAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * OrderAddressService单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:53
 * 
 */
public class OrderAddressServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private OrderAddressService orderAddressService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        Long userNo = null; //TODO 初始化
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化
        orderAddress.setAddName(addName);
        orderAddress.setCreateUser(TestConstants.UER_NAME);
        boolean result = orderAddressService.insert(orderAddress);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        Long userNo = null; //TODO 初始化// 已经存在的
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化// 已经存在的
        orderAddress.setAddName(addName);
        orderAddress.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = orderAddressService.insert(orderAddress);
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
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setId(TEST_DEFAULT_EXIST_ID);
        Long userNo = null; //TODO 初始化
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化
        orderAddress.setAddName(addName);
        orderAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderAddressService.delete(orderAddress);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userNo = null; //TODO 初始化
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化
        orderAddress.setAddName(addName);
        orderAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderAddressService.delete(orderAddress);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setId(TEST_DEFAULT_EXIST_ID);
        Long userNo = null; //TODO 初始化
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化
        orderAddress.setAddName(addName);
        orderAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderAddressService.update(orderAddress);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(orderAddressService);
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userNo = null; //TODO 初始化
        orderAddress.setUserNo(userNo);
        String addName = null; //TODO 初始化
        orderAddress.setAddName(addName);
        orderAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = orderAddressService.update(orderAddress);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(orderAddressService);
        OrderAddress c = orderAddressService.getOrderAddressById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(orderAddressService);
        OrderAddress c = orderAddressService.getOrderAddressById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(orderAddressService);
        OrderAddressQuery queryBean = null;
        PageUtil pageUtil = null;
        List<OrderAddress> list = orderAddressService.queryOrderAddressListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(orderAddressService);
        OrderAddressQuery queryBean = new OrderAddressQuery();
        Long userNo = null; //TODO 初始化
        queryBean.setUserNo(userNo);
        String addName = null; //TODO 初始化
        queryBean.setAddName(addName);
        List<OrderAddress> list = orderAddressService.queryOrderAddressList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
