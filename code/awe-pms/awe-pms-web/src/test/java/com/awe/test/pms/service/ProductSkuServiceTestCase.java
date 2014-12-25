package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.ProductSku;
import com.awe.pms.domain.query.ProductSkuQuery;
import com.awe.pms.service.ProductSkuService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductSkuService单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:57
 * 
 */
public class ProductSkuServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductSkuService productSkuService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        String productNo = null; //TODO 初始化
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        productSku.setSkuNo(skuNo);
        productSku.setCreateUser(TestConstants.UER_NAME);
        boolean result = productSkuService.insert(productSku);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        String productNo = null; //TODO 初始化// 已经存在的
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化// 已经存在的
        productSku.setSkuNo(skuNo);
        productSku.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productSkuService.insert(productSku);
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
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        productSku.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        productSku.setSkuNo(skuNo);
        productSku.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSkuService.delete(productSku);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        productSku.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        productSku.setSkuNo(skuNo);
        productSku.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSkuService.delete(productSku);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        productSku.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        productSku.setSkuNo(skuNo);
        productSku.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSkuService.update(productSku);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productSkuService);
        ProductSku productSku = new ProductSku();
        productSku.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        productSku.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        productSku.setSkuNo(skuNo);
        productSku.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSkuService.update(productSku);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productSkuService);
        ProductSku c = productSkuService.getProductSkuById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productSkuService);
        ProductSku c = productSkuService.getProductSkuById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productSkuService);
        ProductSkuQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ProductSku> list = productSkuService.queryProductSkuListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productSkuService);
        ProductSkuQuery queryBean = new ProductSkuQuery();
        String productNo = null; //TODO 初始化
        queryBean.setProductNo(productNo);
        String skuNo = null; //TODO 初始化
        queryBean.setSkuNo(skuNo);
        List<ProductSku> list = productSkuService.queryProductSkuList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
