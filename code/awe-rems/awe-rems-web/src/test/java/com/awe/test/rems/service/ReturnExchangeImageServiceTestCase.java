package com.awe.test.rems.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
import com.awe.rems.service.ReturnExchangeImageService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ReturnExchangeImageService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:17
 * 
 */
public class ReturnExchangeImageServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ReturnExchangeImageService returnExchangeImageService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        Long returnExchangeId = null; //TODO 初始化
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setCreateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeImageService.insert(returnExchangeImage);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        Long returnExchangeId = null; //TODO 初始化// 已经存在的
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化// 已经存在的
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = returnExchangeImageService.insert(returnExchangeImage);
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
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        returnExchangeImage.setId(TEST_DEFAULT_EXIST_ID);
        Long returnExchangeId = null; //TODO 初始化
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeImageService.delete(returnExchangeImage);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        returnExchangeImage.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long returnExchangeId = null; //TODO 初始化
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeImageService.delete(returnExchangeImage);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        returnExchangeImage.setId(TEST_DEFAULT_EXIST_ID);
        Long returnExchangeId = null; //TODO 初始化
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeImageService.update(returnExchangeImage);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage returnExchangeImage = new ReturnExchangeImage();
        returnExchangeImage.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long returnExchangeId = null; //TODO 初始化
        returnExchangeImage.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        returnExchangeImage.setServiceNo(serviceNo);
        returnExchangeImage.setUpdateUser(TestConstants.UER_NAME);
        boolean result = returnExchangeImageService.update(returnExchangeImage);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage c = returnExchangeImageService.getReturnExchangeImageById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImage c = returnExchangeImageService.getReturnExchangeImageById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImageQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ReturnExchangeImage> list = returnExchangeImageService.queryReturnExchangeImageListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(returnExchangeImageService);
        ReturnExchangeImageQuery queryBean = new ReturnExchangeImageQuery();
        Long returnExchangeId = null; //TODO 初始化
        queryBean.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        queryBean.setServiceNo(serviceNo);
        List<ReturnExchangeImage> list = returnExchangeImageService.queryReturnExchangeImageList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
