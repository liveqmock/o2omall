package com.awe.test.pay.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;
import com.awe.pay.service.TradeRefundFailService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * TradeRefundFailService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeRefundFailServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TradeRefundFailService tradeRefundFailService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        Long orderNo = null; //TODO 初始化
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setCreateUser(TestConstants.UER_NAME);
        boolean result = tradeRefundFailService.insert(tradeRefundFail);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        Long orderNo = null; //TODO 初始化// 已经存在的
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化// 已经存在的
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tradeRefundFailService.insert(tradeRefundFail);
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
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        tradeRefundFail.setId(TEST_DEFAULT_EXIST_ID);
        Long orderNo = null; //TODO 初始化
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeRefundFailService.delete(tradeRefundFail);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        tradeRefundFail.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long orderNo = null; //TODO 初始化
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeRefundFailService.delete(tradeRefundFail);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        tradeRefundFail.setId(TEST_DEFAULT_EXIST_ID);
        Long orderNo = null; //TODO 初始化
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeRefundFailService.update(tradeRefundFail);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail tradeRefundFail = new TradeRefundFail();
        tradeRefundFail.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long orderNo = null; //TODO 初始化
        tradeRefundFail.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        tradeRefundFail.setPayType(payType);
        tradeRefundFail.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeRefundFailService.update(tradeRefundFail);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail c = tradeRefundFailService.getTradeRefundFailById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFail c = tradeRefundFailService.getTradeRefundFailById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFailQuery queryBean = null;
        PageUtil pageUtil = null;
        List<TradeRefundFail> list = tradeRefundFailService.queryTradeRefundFailListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tradeRefundFailService);
        TradeRefundFailQuery queryBean = new TradeRefundFailQuery();
        Long orderNo = null; //TODO 初始化
        queryBean.setOrderNo(orderNo);
        Integer payType = null; //TODO 初始化
        queryBean.setPayType(payType);
        List<TradeRefundFail> list = tradeRefundFailService.queryTradeRefundFailList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
