package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;
import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
import com.awe.uc.service.UserAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

/**
 * UserAddressService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class UserAddressServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;

    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserAddressService userAddressService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(1L);
        userAddress.setName("李四");
        userAddress.setProvinceName("北京");
        userAddress.setProvinceNo("1");
        userAddress.setCityName("朝阳区");
        userAddress.setCityNo("2");
        userAddress.setCountyName("北苑");
        userAddress.setCountyNo("3");
        userAddress.setAddress("华堂商场3层");
        userAddress.setPhone("010-66668888");
        userAddress.setMobile("13155556666");
        userAddress.setZipcode("100101");
        userAddress.setEmail("1qaz@126.com");
        userAddress.setCreateUser(TestConstants.UER_NAME);
        boolean result = userAddressService.insert(userAddress);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(1L);// 已经存在的
        userAddress.setName("张三");// 已经存在的
        userAddress.setProvinceName("北京");
        userAddress.setProvinceNo("1");// 已经存在的
        userAddress.setCityName("朝阳区");
        userAddress.setCityNo("2");// 已经存在的
        userAddress.setCountyName("北苑");
        userAddress.setCountyNo("3");// 已经存在的
        userAddress.setAddress("华堂商场3层");
        userAddress.setPhone("010-66668888");
        userAddress.setMobile("13155556666");
        userAddress.setZipcode("100101");
        userAddress.setEmail("1qaz@126.com");
        userAddress.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userAddressService.insert(userAddress);
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
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setId(TEST_DEFAULT_EXIST_ID);
        userAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAddressService.delete(userAddress);
        Assert.isTrue(result);
    }

    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        userAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAddressService.delete(userAddress);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setId(TEST_DEFAULT_EXIST_ID);
        userAddress.setPhone("010-66668888");
        userAddress.setUpdateUser(TestConstants.UER_NAME);
        userAddress.setIsdefault(1);
        boolean result = userAddressService.update(userAddress);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userAddressService);
        UserAddress userAddress = new UserAddress();
        userAddress.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        userAddress.setPhone("010-66668888");
        userAddress.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userAddressService.update(userAddress);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userAddressService);
        UserAddress c = userAddressService.getUserAddressById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userAddressService);
        UserAddress c = userAddressService.getUserAddressById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userAddressService);
        UserAddressQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserAddress> list = userAddressService.queryUserAddressListWithPage(queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userAddressService);
        UserAddressQuery queryBean = new UserAddressQuery();
        List<UserAddress> list = userAddressService.queryUserAddressList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
