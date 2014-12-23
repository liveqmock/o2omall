package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.ProductBrand;
import com.awe.pms.domain.query.ProductBrandQuery;
import com.awe.pms.service.ProductBrandService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductBrandService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductBrandServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductBrandService productBrandService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        Long categoryOneId = null; //TODO 初始化
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        productBrand.setCategoryOne(categoryOne);
        productBrand.setCreateUser(TestConstants.UER_NAME);
        boolean result = productBrandService.insert(productBrand);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        Long categoryOneId = null; //TODO 初始化// 已经存在的
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化// 已经存在的
        productBrand.setCategoryOne(categoryOne);
        productBrand.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productBrandService.insert(productBrand);
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
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(TEST_DEFAULT_EXIST_ID);
        Long categoryOneId = null; //TODO 初始化
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        productBrand.setCategoryOne(categoryOne);
        productBrand.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productBrandService.delete(productBrand);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long categoryOneId = null; //TODO 初始化
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        productBrand.setCategoryOne(categoryOne);
        productBrand.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productBrandService.delete(productBrand);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(TEST_DEFAULT_EXIST_ID);
        Long categoryOneId = null; //TODO 初始化
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        productBrand.setCategoryOne(categoryOne);
        productBrand.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productBrandService.update(productBrand);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productBrandService);
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long categoryOneId = null; //TODO 初始化
        productBrand.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        productBrand.setCategoryOne(categoryOne);
        productBrand.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productBrandService.update(productBrand);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productBrandService);
        ProductBrand c = productBrandService.getProductBrandById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productBrandService);
        ProductBrand c = productBrandService.getProductBrandById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productBrandService);
        ProductBrandQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ProductBrand> list = productBrandService.queryProductBrandListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productBrandService);
        ProductBrandQuery queryBean = new ProductBrandQuery();
        Long categoryOneId = null; //TODO 初始化
        queryBean.setCategoryOneId(categoryOneId);
        String categoryOne = null; //TODO 初始化
        queryBean.setCategoryOne(categoryOne);
        List<ProductBrand> list = productBrandService.queryProductBrandList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
