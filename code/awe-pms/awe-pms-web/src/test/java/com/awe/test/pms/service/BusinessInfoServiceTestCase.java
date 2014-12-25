package com.awe.test.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;
import com.awe.pms.service.BusinessInfoService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * BusinessInfoService单元测试
 * 
 * @author ljz
 * @version 2014-12-25 9:31:57
 * 
 */
public class BusinessInfoServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private BusinessInfoService businessInfoService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        String businessNo = null; //TODO 初始化
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        businessInfo.setBusinessName(businessName);
        businessInfo.setCreateUser(TestConstants.UER_NAME);
        boolean result = businessInfoService.insert(businessInfo);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        String businessNo = null; //TODO 初始化// 已经存在的
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化// 已经存在的
        businessInfo.setBusinessName(businessName);
        businessInfo.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = businessInfoService.insert(businessInfo);
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
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setId(TEST_DEFAULT_EXIST_ID);
        String businessNo = null; //TODO 初始化
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        businessInfo.setBusinessName(businessName);
        businessInfo.setUpdateUser(TestConstants.UER_NAME);
        boolean result = businessInfoService.delete(businessInfo);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String businessNo = null; //TODO 初始化
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        businessInfo.setBusinessName(businessName);
        businessInfo.setUpdateUser(TestConstants.UER_NAME);
        boolean result = businessInfoService.delete(businessInfo);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setId(TEST_DEFAULT_EXIST_ID);
        String businessNo = null; //TODO 初始化
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        businessInfo.setBusinessName(businessName);
        businessInfo.setUpdateUser(TestConstants.UER_NAME);
        boolean result = businessInfoService.update(businessInfo);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(businessInfoService);
        BusinessInfo businessInfo = new BusinessInfo();
        businessInfo.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        String businessNo = null; //TODO 初始化
        businessInfo.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        businessInfo.setBusinessName(businessName);
        businessInfo.setUpdateUser(TestConstants.UER_NAME);
        boolean result = businessInfoService.update(businessInfo);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(businessInfoService);
        BusinessInfo c = businessInfoService.getBusinessInfoById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(businessInfoService);
        BusinessInfo c = businessInfoService.getBusinessInfoById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(businessInfoService);
        BusinessInfoQuery queryBean = null;
        PageUtil pageUtil = null;
        List<BusinessInfo> list = businessInfoService.queryBusinessInfoListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(businessInfoService);
        BusinessInfoQuery queryBean = new BusinessInfoQuery();
        String businessNo = null; //TODO 初始化
        queryBean.setBusinessNo(businessNo);
        String businessName = null; //TODO 初始化
        queryBean.setBusinessName(businessName);
        List<BusinessInfo> list = businessInfoService.queryBusinessInfoList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
