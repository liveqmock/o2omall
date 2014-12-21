package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
import com.awe.uc.service.UserImgService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * UserImgService单元测试
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:53
 * 
 */
public class UserImgServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserImgService userImgService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        String userNo = null; //TODO 初始化
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        userImg.setImgCatalog(imgCatalog);
        userImg.setCreateUser(TestConstants.UER_NAME);
        boolean result = userImgService.insert(userImg);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        String userNo = null; //TODO 初始化// 已经存在的
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化// 已经存在的
        userImg.setImgCatalog(imgCatalog);
        userImg.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userImgService.insert(userImg);
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
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        userImg.setId(TEST_DEFAULT_EXIST_ID);
        String userNo = null; //TODO 初始化
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        userImg.setImgCatalog(imgCatalog);
        userImg.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userImgService.delete(userImg);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        userImg.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String userNo = null; //TODO 初始化
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        userImg.setImgCatalog(imgCatalog);
        userImg.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userImgService.delete(userImg);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        userImg.setId(TEST_DEFAULT_EXIST_ID);
        String userNo = null; //TODO 初始化
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        userImg.setImgCatalog(imgCatalog);
        userImg.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userImgService.update(userImg);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userImgService);
        UserImg userImg = new UserImg();
        userImg.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String userNo = null; //TODO 初始化
        userImg.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        userImg.setImgCatalog(imgCatalog);
        userImg.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userImgService.update(userImg);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userImgService);
        UserImg c = userImgService.getUserImgById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userImgService);
        UserImg c = userImgService.getUserImgById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userImgService);
        UserImgQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserImg> list = userImgService.queryUserImgListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userImgService);
        UserImgQuery queryBean = new UserImgQuery();
        String userNo = null; //TODO 初始化
        queryBean.setUserNo(userNo);
        String imgCatalog = null; //TODO 初始化
        queryBean.setImgCatalog(imgCatalog);
        List<UserImg> list = userImgService.queryUserImgList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
