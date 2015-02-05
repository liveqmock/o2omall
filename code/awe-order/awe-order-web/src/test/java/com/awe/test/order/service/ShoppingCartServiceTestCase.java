package com.awe.test.order.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.awe.order.manager.ShoppingCartManager;
import com.awe.order.service.ShoppingCartService;
import com.awe.order.utils.exceptions.ExistedException;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;
import com.hbird.common.utils.page.PageUtil;

/**
 * ShoppingCartService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:58:09
 * 
 */
public class ShoppingCartServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartManager ShoppingCartManager;
    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        Long userId = null; //TODO 初始化
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setCreateUser(TestConstants.UER_NAME);
        boolean result = shoppingCartService.insert(shoppingCart);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        Long userId = null; //TODO 初始化// 已经存在的
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化// 已经存在的
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = shoppingCartService.insert(shoppingCart);
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
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(TEST_DEFAULT_EXIST_ID);
        Long userId = null; //TODO 初始化
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setUpdateUser(TestConstants.UER_NAME);
        boolean result = shoppingCartService.delete(shoppingCart);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userId = null; //TODO 初始化
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setUpdateUser(TestConstants.UER_NAME);
        boolean result = shoppingCartService.delete(shoppingCart);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(TEST_DEFAULT_EXIST_ID);
        Long userId = null; //TODO 初始化
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setUpdateUser(TestConstants.UER_NAME);
        boolean result = shoppingCartService.update(shoppingCart);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(shoppingCartService);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long userId = null; //TODO 初始化
        shoppingCart.setUserId(userId);
        String skuNo = null; //TODO 初始化
        shoppingCart.setSkuNo(skuNo);
        shoppingCart.setUpdateUser(TestConstants.UER_NAME);
        boolean result = shoppingCartService.update(shoppingCart);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(shoppingCartService);
        ShoppingCart c = shoppingCartService.getShoppingCartById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(shoppingCartService);
        ShoppingCart c = shoppingCartService.getShoppingCartById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(shoppingCartService);
        ShoppingCartQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ShoppingCart> list = shoppingCartService.queryShoppingCartListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(shoppingCartService);
        ShoppingCartQuery queryBean = new ShoppingCartQuery();
        Long userId = 1L; //TODO 初始化
        queryBean.setUserId(userId);
        String skuNo = "10000000000001"; //TODO 初始化
        //queryBean.setSkuNo(skuNo);
        List<ShoppingCart> list = shoppingCartService.queryShoppingCartList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
    @Test
    public void getShoppingCart(){
    	ShoppingCart shoppingCart = new ShoppingCart();
    	shoppingCart.setSkuNo("10000000000001");
    	shoppingCart.setUserId(1L);
    	ShoppingCart sc = ShoppingCartManager.getShoppingCart(shoppingCart);
    	Assert.notNull(sc);
    }
}
