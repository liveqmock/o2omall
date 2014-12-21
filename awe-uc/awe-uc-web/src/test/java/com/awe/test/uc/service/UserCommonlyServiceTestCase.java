package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
import com.awe.uc.service.UserCommonlyService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * UserCommonlyService单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:53
 * 
 */
public class UserCommonlyServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserCommonlyService userCommonlyService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        String userUsername = null; //TODO 初始化
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        userCommonly.setUserPassword(userPassword);
        userCommonly.setCreateUser(TestConstants.UER_NAME);
        boolean result = userCommonlyService.insert(userCommonly);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        String userUsername = null; //TODO 初始化// 已经存在的
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化// 已经存在的
        userCommonly.setUserPassword(userPassword);
        userCommonly.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userCommonlyService.insert(userCommonly);
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
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        userCommonly.setId(TEST_DEFAULT_EXIST_ID);
        String userUsername = null; //TODO 初始化
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        userCommonly.setUserPassword(userPassword);
        userCommonly.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userCommonlyService.delete(userCommonly);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        userCommonly.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String userUsername = null; //TODO 初始化
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        userCommonly.setUserPassword(userPassword);
        userCommonly.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userCommonlyService.delete(userCommonly);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        userCommonly.setId(TEST_DEFAULT_EXIST_ID);
        String userUsername = null; //TODO 初始化
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        userCommonly.setUserPassword(userPassword);
        userCommonly.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userCommonlyService.update(userCommonly);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userCommonlyService);
        UserCommonly userCommonly = new UserCommonly();
        userCommonly.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String userUsername = null; //TODO 初始化
        userCommonly.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        userCommonly.setUserPassword(userPassword);
        userCommonly.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userCommonlyService.update(userCommonly);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userCommonlyService);
        UserCommonly c = userCommonlyService.getUserCommonlyById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userCommonlyService);
        UserCommonly c = userCommonlyService.getUserCommonlyById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userCommonlyService);
        UserCommonlyQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserCommonly> list = userCommonlyService.queryUserCommonlyListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userCommonlyService);
        UserCommonlyQuery queryBean = new UserCommonlyQuery();
        String userUsername = null; //TODO 初始化
        queryBean.setUserUsername(userUsername);
        String userPassword = null; //TODO 初始化
        queryBean.setUserPassword(userPassword);
        List<UserCommonly> list = userCommonlyService.queryUserCommonlyList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
