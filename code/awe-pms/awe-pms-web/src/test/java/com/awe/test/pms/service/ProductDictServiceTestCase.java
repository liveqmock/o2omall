package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.ProductDict;
import com.awe.pms.domain.query.ProductDictQuery;
import com.awe.pms.service.ProductDictService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ProductDictService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:21:00
 * 
 */
public class ProductDictServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ProductDictService productDictService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        Integer type = null; //TODO 初始化
        productDict.setType(type);
        String attr = null; //TODO 初始化
        productDict.setAttr(attr);
        productDict.setCreateUser(TestConstants.UER_NAME);
        boolean result = productDictService.insert(productDict);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        Integer type = null; //TODO 初始化// 已经存在的
        productDict.setType(type);
        String attr = null; //TODO 初始化// 已经存在的
        productDict.setAttr(attr);
        productDict.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = productDictService.insert(productDict);
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
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        productDict.setId(TEST_DEFAULT_EXIST_ID);
        Integer type = null; //TODO 初始化
        productDict.setType(type);
        String attr = null; //TODO 初始化
        productDict.setAttr(attr);
        productDict.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productDictService.delete(productDict);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        productDict.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Integer type = null; //TODO 初始化
        productDict.setType(type);
        String attr = null; //TODO 初始化
        productDict.setAttr(attr);
        productDict.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productDictService.delete(productDict);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        productDict.setId(TEST_DEFAULT_EXIST_ID);
        Integer type = null; //TODO 初始化
        productDict.setType(type);
        String attr = null; //TODO 初始化
        productDict.setAttr(attr);
        productDict.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productDictService.update(productDict);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(productDictService);
        ProductDict productDict = new ProductDict();
        productDict.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Integer type = null; //TODO 初始化
        productDict.setType(type);
        String attr = null; //TODO 初始化
        productDict.setAttr(attr);
        productDict.setUpdateUser(TestConstants.UER_NAME);
        boolean result = productDictService.update(productDict);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(productDictService);
        ProductDict c = productDictService.getProductDictById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(productDictService);
        ProductDict c = productDictService.getProductDictById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(productDictService);
        ProductDictQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ProductDict> list = productDictService.queryProductDictListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(productDictService);
        ProductDictQuery queryBean = new ProductDictQuery();
        Integer type = null; //TODO 初始化
        queryBean.setType(type);
        String attr = null; //TODO 初始化
        queryBean.setAttr(attr);
        List<ProductDict> list = productDictService.queryProductDictList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
