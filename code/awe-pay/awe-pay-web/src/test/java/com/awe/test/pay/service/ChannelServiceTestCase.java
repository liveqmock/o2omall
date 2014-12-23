package com.awe.test.pay.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
import com.awe.pay.service.ChannelService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ChannelService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:28
 * 
 */
public class ChannelServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ChannelService channelService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(channelService);
        Channel channel = new Channel();
        Long channelNo = null; //TODO 初始化
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        channel.setChannelName(channelName);
        channel.setCreateUser(TestConstants.UER_NAME);
        boolean result = channelService.insert(channel);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(channelService);
        Channel channel = new Channel();
        Long channelNo = null; //TODO 初始化// 已经存在的
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化// 已经存在的
        channel.setChannelName(channelName);
        channel.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = channelService.insert(channel);
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
        Assert.notNull(channelService);
        Channel channel = new Channel();
        channel.setId(TEST_DEFAULT_EXIST_ID);
        Long channelNo = null; //TODO 初始化
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        channel.setChannelName(channelName);
        channel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = channelService.delete(channel);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(channelService);
        Channel channel = new Channel();
        channel.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long channelNo = null; //TODO 初始化
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        channel.setChannelName(channelName);
        channel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = channelService.delete(channel);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(channelService);
        Channel channel = new Channel();
        channel.setId(TEST_DEFAULT_EXIST_ID);
        Long channelNo = null; //TODO 初始化
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        channel.setChannelName(channelName);
        channel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = channelService.update(channel);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(channelService);
        Channel channel = new Channel();
        channel.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long channelNo = null; //TODO 初始化
        channel.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        channel.setChannelName(channelName);
        channel.setUpdateUser(TestConstants.UER_NAME);
        boolean result = channelService.update(channel);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(channelService);
        Channel c = channelService.getChannelById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(channelService);
        Channel c = channelService.getChannelById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(channelService);
        ChannelQuery queryBean = null;
        PageUtil pageUtil = null;
        List<Channel> list = channelService.queryChannelListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(channelService);
        ChannelQuery queryBean = new ChannelQuery();
        Long channelNo = null; //TODO 初始化
        queryBean.setChannelNo(channelNo);
        String channelName = null; //TODO 初始化
        queryBean.setChannelName(channelName);
        List<Channel> list = channelService.queryChannelList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
