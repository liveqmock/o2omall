package com.awe.test.rems.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.service.ServiceAuditService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;

/**
 * ServiceAuditService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 10:06:17
 * 
 */
public class ServiceAuditServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private ServiceAuditService serviceAuditService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        Long returnExchangeId = null; //TODO 初始化
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setCreateUser(TestConstants.UER_NAME);
        boolean result = serviceAuditService.insert(serviceAudit);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        Long returnExchangeId = null; //TODO 初始化// 已经存在的
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化// 已经存在的
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = serviceAuditService.insert(serviceAudit);
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
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        serviceAudit.setId(TEST_DEFAULT_EXIST_ID);
        Long returnExchangeId = null; //TODO 初始化
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setUpdateUser(TestConstants.UER_NAME);
        boolean result = serviceAuditService.delete(serviceAudit);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        serviceAudit.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long returnExchangeId = null; //TODO 初始化
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setUpdateUser(TestConstants.UER_NAME);
        boolean result = serviceAuditService.delete(serviceAudit);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        serviceAudit.setId(TEST_DEFAULT_EXIST_ID);
        Long returnExchangeId = null; //TODO 初始化
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setUpdateUser(TestConstants.UER_NAME);
        boolean result = serviceAuditService.update(serviceAudit);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(serviceAuditService);
        ServiceAudit serviceAudit = new ServiceAudit();
        serviceAudit.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        Long returnExchangeId = null; //TODO 初始化
        serviceAudit.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        serviceAudit.setServiceNo(serviceNo);
        serviceAudit.setUpdateUser(TestConstants.UER_NAME);
        boolean result = serviceAuditService.update(serviceAudit);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(serviceAuditService);
        ServiceAudit c = serviceAuditService.getServiceAuditById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(serviceAuditService);
        ServiceAudit c = serviceAuditService.getServiceAuditById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(serviceAuditService);
        ServiceAuditQuery queryBean = null;
        PageUtil pageUtil = null;
        List<ServiceAudit> list = serviceAuditService.queryServiceAuditListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(serviceAuditService);
        ServiceAuditQuery queryBean = new ServiceAuditQuery();
        Long returnExchangeId = null; //TODO 初始化
        queryBean.setReturnExchangeId(returnExchangeId);
        String serviceNo = null; //TODO 初始化
        queryBean.setServiceNo(serviceNo);
        List<ServiceAudit> list = serviceAuditService.queryServiceAuditList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
