package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.awe.pms.service.SkuImagesService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * SkuImagesService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class SkuImagesServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        String skuNo = null; //TODO 初始化
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        skuImages.setImgType(imgType);
        skuImages.setCreateUser(TestConstants.UER_NAME);
        boolean result = skuImagesService.insert(skuImages);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        String skuNo = null; //TODO 初始化// 已经存在的
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化// 已经存在的
        skuImages.setImgType(imgType);
        skuImages.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = skuImagesService.insert(skuImages);
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
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        skuImages.setId(TEST_DEFAULT_EXIST_ID);
        String skuNo = null; //TODO 初始化
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        skuImages.setImgType(imgType);
        skuImages.setUpdateUser(TestConstants.UER_NAME);
        boolean result = skuImagesService.delete(skuImages);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        skuImages.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String skuNo = null; //TODO 初始化
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        skuImages.setImgType(imgType);
        skuImages.setUpdateUser(TestConstants.UER_NAME);
        boolean result = skuImagesService.delete(skuImages);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        skuImages.setId(TEST_DEFAULT_EXIST_ID);
        String skuNo = null; //TODO 初始化
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        skuImages.setImgType(imgType);
        skuImages.setUpdateUser(TestConstants.UER_NAME);
        boolean result = skuImagesService.update(skuImages);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(skuImagesService);
        SkuImages skuImages = new SkuImages();
        skuImages.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String skuNo = null; //TODO 初始化
        skuImages.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        skuImages.setImgType(imgType);
        skuImages.setUpdateUser(TestConstants.UER_NAME);
        boolean result = skuImagesService.update(skuImages);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(skuImagesService);
        SkuImages c = skuImagesService.getSkuImagesById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(skuImagesService);
        SkuImages c = skuImagesService.getSkuImagesById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(skuImagesService);
        SkuImagesQuery queryBean = null;
        PageUtil pageUtil = null;
        List<SkuImages> list = skuImagesService.querySkuImagesListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(skuImagesService);
        SkuImagesQuery queryBean = new SkuImagesQuery();
        String skuNo = null; //TODO 初始化
        queryBean.setSkuNo(skuNo);
        Integer imgType = null; //TODO 初始化
        queryBean.setImgType(imgType);
        List<SkuImages> list = skuImagesService.querySkuImagesList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
