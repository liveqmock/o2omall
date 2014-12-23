package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.awe.uc.service.UserAccountService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * UserAccountService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:48
 * 
 */
public class UserAccountServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserAccountService userAccountService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        String username = null; //TODO 初始化
        userAccount.setUsername(username);
        String password = null; //TODO 初始化
        userAccount.setPassword(password);
        userAccount.setCreateUser(TestConstants.UER_NAME);
        boolean result = userAccountService.insert(userAccount);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        String username = null; //TODO 初始化// 已经存在的
        userAccount.setUsername(username);
        String password = null; //TODO 初始化// 已经存在的
        userAccount.setPassword(password);
        userAccount.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userAccountService.insert(userAccount);
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
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(TEST_DEFAULT_EXIST_ID);
        String username = null; //TODO 初始化
        userAccount.setUsername(username);
        String password = null; //TODO 初始化
        userAccount.setPassword(password);
        userAccount.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAccountService.delete(userAccount);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String username = null; //TODO 初始化
        userAccount.setUsername(username);
        String password = null; //TODO 初始化
        userAccount.setPassword(password);
        userAccount.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAccountService.delete(userAccount);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(TEST_DEFAULT_EXIST_ID);
        String username = null; //TODO 初始化
        userAccount.setUsername(username);
        String password = null; //TODO 初始化
        userAccount.setPassword(password);
        userAccount.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAccountService.update(userAccount);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userAccountService);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String username = null; //TODO 初始化
        userAccount.setUsername(username);
        String password = null; //TODO 初始化
        userAccount.setPassword(password);
        userAccount.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAccountService.update(userAccount);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userAccountService);
        UserAccount c = userAccountService.getUserAccountById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userAccountService);
        UserAccount c = userAccountService.getUserAccountById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userAccountService);
        UserAccountQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserAccount> list = userAccountService.queryUserAccountListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userAccountService);
        UserAccountQuery queryBean = new UserAccountQuery();
        String username = null; //TODO 初始化
        queryBean.setUsername(username);
        String password = null; //TODO 初始化
        queryBean.setPassword(password);
        List<UserAccount> list = userAccountService.queryUserAccountList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
