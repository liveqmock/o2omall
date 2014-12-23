package com.awe.test.pay.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;
import com.awe.pay.service.TradeService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * TradeService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class TradeServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private TradeService tradeService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        String loginNo = null; //TODO 初始化
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        trade.setLoginName(loginName);
        trade.setCreateUser(TestConstants.UER_NAME);
        boolean result = tradeService.insert(trade);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        String loginNo = null; //TODO 初始化// 已经存在的
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化// 已经存在的
        trade.setLoginName(loginName);
        trade.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = tradeService.insert(trade);
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
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        trade.setId(TEST_DEFAULT_EXIST_ID);
        String loginNo = null; //TODO 初始化
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        trade.setLoginName(loginName);
        trade.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeService.delete(trade);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        trade.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String loginNo = null; //TODO 初始化
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        trade.setLoginName(loginName);
        trade.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeService.delete(trade);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        trade.setId(TEST_DEFAULT_EXIST_ID);
        String loginNo = null; //TODO 初始化
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        trade.setLoginName(loginName);
        trade.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeService.update(trade);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(tradeService);
        Trade trade = new Trade();
        trade.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String loginNo = null; //TODO 初始化
        trade.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        trade.setLoginName(loginName);
        trade.setUpdateUser(TestConstants.UER_NAME);
        boolean result = tradeService.update(trade);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(tradeService);
        Trade c = tradeService.getTradeById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(tradeService);
        Trade c = tradeService.getTradeById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(tradeService);
        TradeQuery queryBean = null;
        PageUtil pageUtil = null;
        List<Trade> list = tradeService.queryTradeListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(tradeService);
        TradeQuery queryBean = new TradeQuery();
        String loginNo = null; //TODO 初始化
        queryBean.setLoginNo(loginNo);
        String loginName = null; //TODO 初始化
        queryBean.setLoginName(loginName);
        List<Trade> list = tradeService.queryTradeList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
