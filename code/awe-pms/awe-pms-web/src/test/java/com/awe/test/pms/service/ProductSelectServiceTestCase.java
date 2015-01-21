package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.ProductSelect;
import com.awe.pms.domain.query.ProductSelectQuery;
import com.awe.pms.service.ProductSelectService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductSelectService单元测试
 * 
 * @author ljz
 * @version 2015-1-21 10:47:34
 * 
 */
public class ProductSelectServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductSelectService productSelectService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        String productNo = null; //TODO 初始化
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化
        productSelect.setProductName(productName);
        productSelect.setCreateUser(TestConstants.UER_NAME);
        boolean result = productSelectService.insert(productSelect);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        String productNo = null; //TODO 初始化// 已经存在的
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化// 已经存在的
        productSelect.setProductName(productName);
        productSelect.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productSelectService.insert(productSelect);
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
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        productSelect.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化
        productSelect.setProductName(productName);
        productSelect.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSelectService.delete(productSelect);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        productSelect.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化
        productSelect.setProductName(productName);
        productSelect.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSelectService.delete(productSelect);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        productSelect.setId(TEST_DEFAULT_EXIST_ID);
        String productNo = null; //TODO 初始化
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化
        productSelect.setProductName(productName);
        productSelect.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSelectService.update(productSelect);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productSelectService);
        ProductSelect productSelect = new ProductSelect();
        productSelect.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String productNo = null; //TODO 初始化
        productSelect.setProductNo(productNo);
        String productName = null; //TODO 初始化
        productSelect.setProductName(productName);
        productSelect.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productSelectService.update(productSelect);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productSelectService);
        ProductSelect c = productSelectService.getProductSelectById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productSelectService);
        ProductSelect c = productSelectService.getProductSelectById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productSelectService);
        ProductSelectQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ProductSelect> list = productSelectService.queryProductSelectListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productSelectService);
        ProductSelectQuery queryBean = new ProductSelectQuery();
        String productNo = null; //TODO 初始化
        queryBean.setProductNo(productNo);
        String productName = null; //TODO 初始化
        queryBean.setProductName(productName);
        List<ProductSelect> list = productSelectService.queryProductSelectList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
