package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.Product;
import com.awe.pms.domain.query.ProductQuery;
import com.awe.pms.service.ProductService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductService单元测试
 * 
 * @author ljz
 * @version 2014-12-25 14:47:40
 * 
 */
public class ProductServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductService productService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productService);
        Product product = new Product();
        String productNo = null; //TODO 初始化
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化
        product.setProductName(productName);
        product.setCreateUser(TestConstants.UER_NAME);
        boolean result = productService.insert(product);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productService);
        Product product = new Product();
        String productNo = null; //TODO 初始化// 已经存在的
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化// 已经存在的
        product.setProductName(productName);
        product.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productService.insert(product);
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
        Assert.notNull(productService);
        Product product = new Product();
        product.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化
        product.setProductName(productName);
        product.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productService.delete(product);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productService);
        Product product = new Product();
        product.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化
        product.setProductName(productName);
        product.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productService.delete(product);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productService);
        Product product = new Product();
        product.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化
        product.setProductName(productName);
        product.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productService.update(product);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productService);
        Product product = new Product();
        product.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        product.setProductNo(productNo);
        String productName = null; //TODO 初始化
        product.setProductName(productName);
        product.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productService.update(product);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productService);
        Product c = productService.getProductById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productService);
        Product c = productService.getProductById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productService);
        ProductQuery queryBean = null;
        PageUtil pageUtil = null;
        List<Product> list = productService.queryProductListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productService);
        ProductQuery queryBean = new ProductQuery();
        String productNo = null; //TODO 初始化
        queryBean.setProductNo(productNo);
        String productName = null; //TODO 初始化
        queryBean.setProductName(productName);
        List<Product> list = productService.queryProductList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
