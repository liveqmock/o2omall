package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
import com.awe.uc.service.UserBasicService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * UserBasicService单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:53
 * 
 */
public class UserBasicServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserBasicService userBasicService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        Long userId = null; //TODO 初始化
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        userBasic.setUserSex(userSex);
        userBasic.setCreateUser(TestConstants.UER_NAME);
        boolean result = userBasicService.insert(userBasic);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        Long userId = null; //TODO 初始化// 已经存在的
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化// 已经存在的
        userBasic.setUserSex(userSex);
        userBasic.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userBasicService.insert(userBasic);
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
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        userBasic.setId(TEST_DEFAULT_EXIST_ID);
        Long userId = null; //TODO 初始化
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        userBasic.setUserSex(userSex);
        userBasic.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userBasicService.delete(userBasic);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        userBasic.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userId = null; //TODO 初始化
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        userBasic.setUserSex(userSex);
        userBasic.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userBasicService.delete(userBasic);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        userBasic.setId(TEST_DEFAULT_EXIST_ID);
        Long userId = null; //TODO 初始化
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        userBasic.setUserSex(userSex);
        userBasic.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userBasicService.update(userBasic);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userBasicService);
        UserBasic userBasic = new UserBasic();
        userBasic.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userId = null; //TODO 初始化
        userBasic.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        userBasic.setUserSex(userSex);
        userBasic.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userBasicService.update(userBasic);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userBasicService);
        UserBasic c = userBasicService.getUserBasicById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userBasicService);
        UserBasic c = userBasicService.getUserBasicById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userBasicService);
        UserBasicQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserBasic> list = userBasicService.queryUserBasicListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userBasicService);
        UserBasicQuery queryBean = new UserBasicQuery();
        Long userId = null; //TODO 初始化
        queryBean.setUserId(userId);
        Integer userSex = null; //TODO 初始化
        queryBean.setUserSex(userSex);
        List<UserBasic> list = userBasicService.queryUserBasicList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
