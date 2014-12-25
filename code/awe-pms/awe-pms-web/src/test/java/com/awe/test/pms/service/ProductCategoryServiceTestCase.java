package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.ProductCategory;
import com.awe.pms.domain.query.ProductCategoryQuery;
import com.awe.pms.service.ProductCategoryService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductCategoryService单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:57
 * 
 */
public class ProductCategoryServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        Long fid = null; //TODO 初始化
        productCategory.setFid(fid);
        String name = null; //TODO 初始化
        productCategory.setName(name);
        productCategory.setCreateUser(TestConstants.UER_NAME);
        boolean result = productCategoryService.insert(productCategory);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        Long fid = null; //TODO 初始化// 已经存在的
        productCategory.setFid(fid);
        String name = null; //TODO 初始化// 已经存在的
        productCategory.setName(name);
        productCategory.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productCategoryService.insert(productCategory);
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
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(TEST_DEFAULT_EXIST_ID);
        Long fid = null; //TODO 初始化
        productCategory.setFid(fid);
        String name = null; //TODO 初始化
        productCategory.setName(name);
        productCategory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productCategoryService.delete(productCategory);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long fid = null; //TODO 初始化
        productCategory.setFid(fid);
        String name = null; //TODO 初始化
        productCategory.setName(name);
        productCategory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productCategoryService.delete(productCategory);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(TEST_DEFAULT_EXIST_ID);
        Long fid = null; //TODO 初始化
        productCategory.setFid(fid);
        String name = null; //TODO 初始化
        productCategory.setName(name);
        productCategory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productCategoryService.update(productCategory);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productCategoryService);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long fid = null; //TODO 初始化
        productCategory.setFid(fid);
        String name = null; //TODO 初始化
        productCategory.setName(name);
        productCategory.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productCategoryService.update(productCategory);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productCategoryService);
        ProductCategory c = productCategoryService.getProductCategoryById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productCategoryService);
        ProductCategory c = productCategoryService.getProductCategoryById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productCategoryService);
        ProductCategoryQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ProductCategory> list = productCategoryService.queryProductCategoryListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productCategoryService);
        ProductCategoryQuery queryBean = new ProductCategoryQuery();
        Long fid = null; //TODO 初始化
        queryBean.setFid(fid);
        String name = null; //TODO 初始化
        queryBean.setName(name);
        List<ProductCategory> list = productCategoryService.queryProductCategoryList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
