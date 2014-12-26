package com.awe.test.uc.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;
import com.awe.uc.service.UserProfileService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.security.MD5Util;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * UserProfileService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class UserProfileServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;

    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private UserProfileService userProfileService;

    /**
     * 测试插入数据-成功
     */
    @Test
    @Rollback(false)
    public void testInsert() {
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(2L);
        userProfile.setCnName("李四");
        userProfile.setSex(1);
        userProfile.setNickname("会飞的鱼");
        userProfile.setEmail("1qaz@126.com");
        userProfile.setEmailValidated(1);
        userProfile.setBirthday(new Date());
        userProfile.setConstellation("白羊座");
        userProfile.setUserPhoto("imges/aa.jpg");
        userProfile.setDescription("hello world");
        userProfile.setProvinceName("北京");
        userProfile.setProvinceNo("1");
        userProfile.setCityName("朝阳");
        userProfile.setCityNo("2");
        userProfile.setCountyName("北苑");
        userProfile.setCountyNo("3");
        userProfile.setAddress("华堂商场3层");
        userProfile.setPhone("010-66668888");
        userProfile.setMobile("13155556666");
        userProfile.setSafeQuestion("name ?");
        userProfile.setSafeAnswer("zhang");
        userProfile.setQq("1234567890");
        userProfile.setGrade(2);
        userProfile.setPayPassword(MD5Util.md5Hex("123456"));
        userProfile.setScore(0);
        userProfile.setCreateUser(TestConstants.UER_NAME);
        boolean result = userProfileService.insert(userProfile);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(1L);// 已经存在的
        userProfile.setCnName("张三");
        userProfile.setSex(1);
        userProfile.setNickname("会飞的鱼");
        userProfile.setEmail("1qaz@126.com");
        userProfile.setEmailValidated(1);
        userProfile.setBirthday(new Date());
        userProfile.setConstellation("白羊座");
        userProfile.setUserPhoto("imges/aa.jpg");
        userProfile.setDescription("hello world");
        userProfile.setProvinceName("北京");
        userProfile.setProvinceNo("1");
        userProfile.setCityName("朝阳");
        userProfile.setCityNo("2");
        userProfile.setCountyName("北苑");
        userProfile.setCountyNo("3");
        userProfile.setAddress("华堂商场3层");
        userProfile.setPhone("010-66668888");
        userProfile.setMobile("13155556666");
        userProfile.setSafeQuestion("name ?");
        userProfile.setSafeAnswer("zhang");
        userProfile.setQq("1234567890");
        userProfile.setGrade(2);
        userProfile.setPayPassword(MD5Util.md5Hex("123456"));
        userProfile.setScore(0);
        userProfile.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = userProfileService.insert(userProfile);
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
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(TEST_DEFAULT_EXIST_ID);
        userProfile.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userProfileService.delete(userProfile);
        Assert.isTrue(result);
    }

    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        userProfile.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userProfileService.delete(userProfile);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(TEST_DEFAULT_EXIST_ID);
        userProfile.setCnName("李四");
        userProfile.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userProfileService.update(userProfile);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(userProfileService);
        UserProfile userProfile = new UserProfile();
        userProfile.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        userProfile.setCnName("李四");
        userProfile.setUpdateUser(TestConstants.UER_NAME);
        boolean result = userProfileService.update(userProfile);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(userProfileService);
        UserProfile c = userProfileService.getUserProfileById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(userProfileService);
        UserProfile c = userProfileService.getUserProfileById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(userProfileService);
        UserProfileQuery queryBean = null;
        PageUtil pageUtil = null;
        List<UserProfile> list = userProfileService.queryUserProfileListWithPage(queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(userProfileService);
        UserProfileQuery queryBean = new UserProfileQuery();
        List<UserProfile> list = userProfileService.queryUserProfileList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
