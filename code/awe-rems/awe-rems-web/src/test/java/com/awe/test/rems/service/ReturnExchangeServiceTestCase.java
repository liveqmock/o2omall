package com.awe.test.rems.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.awe.rems.service.ReturnExchangeService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ReturnExchangeService单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:16:23
 * 
 */
public class ReturnExchangeServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ReturnExchangeService returnExchangeService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        String serviceNo = null; //TODO 初始化
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setCreateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeService.insert(returnExchange);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        String serviceNo = null; //TODO 初始化// 已经存在的
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化// 已经存在的
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = returnExchangeService.insert(returnExchange);
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
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        returnExchange.setId(TEST_DEFAULT_EXIST_ID);
        String serviceNo = null; //TODO 初始化
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeService.delete(returnExchange);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        returnExchange.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String serviceNo = null; //TODO 初始化
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeService.delete(returnExchange);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        returnExchange.setId(TEST_DEFAULT_EXIST_ID);
        String serviceNo = null; //TODO 初始化
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeService.update(returnExchange);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(returnExchangeService);
        ReturnExchange returnExchange = new ReturnExchange();
        returnExchange.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String serviceNo = null; //TODO 初始化
        returnExchange.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        returnExchange.setPickupNo(pickupNo);
        returnExchange.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeService.update(returnExchange);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(returnExchangeService);
        ReturnExchange c = returnExchangeService.getReturnExchangeById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(returnExchangeService);
        ReturnExchange c = returnExchangeService.getReturnExchangeById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(returnExchangeService);
        ReturnExchangeQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ReturnExchange> list = returnExchangeService.queryReturnExchangeListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(returnExchangeService);
        ReturnExchangeQuery queryBean = new ReturnExchangeQuery();
        String serviceNo = null; //TODO 初始化
        queryBean.setServiceNo(serviceNo);
        String pickupNo = null; //TODO 初始化
        queryBean.setPickupNo(pickupNo);
        List<ReturnExchange> list = returnExchangeService.queryReturnExchangeList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
