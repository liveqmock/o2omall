package com.awe.test.uc.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.awe.test.base.BaseTransactionTestCase;
import com.awe.test.base.TestConstants;
import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
import com.awe.uc.service.AreaService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

/**
 * AreaService单元测试
 * 
 * @author ljz
 * @version 2014-12-23 15:38:41
 * 
 */
public class AreaServiceTestCase extends BaseTransactionTestCase {

    /** 不存在的 ID-删改查-失败的测试用例 */
    private static final long TEST_NOT_EXIST_ID = -2L;
    
    /** 默认 存在的ID-删改查-成功的测试用例,数据库需存在改ID对应的数据 */
    private static final long TEST_DEFAULT_EXIST_ID = 1L;

    @Autowired
    private AreaService areaService;

    /**
     * 测试插入数据-成功
     */
    @Test
    public void testInsert() {
        Assert.notNull(areaService);
        Area area = new Area();
        area.setParentCode("0");
        area.setCode("2");
        area.setName("上海");
        area.setLeval(1);
        area.setCreateUser(TestConstants.UER_NAME);
        boolean result = areaService.insert(area);
        Assert.isTrue(result);
    }

    /**
     * 测试插入数据-失败（重复、错误、长度越界等）
     */
    @Test
    public void testInsertFailure() {
        Assert.notNull(areaService);
        Area area = new Area();
        area.setParentCode("0");
        area.setCode("1");
        area.setName("北京");
        area.setLeval(1);
        area.setCreateUser(TestConstants.UER_NAME);
        ExistedException ex = null;
        try {
            boolean result = areaService.insert(area);
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
        Assert.notNull(areaService);
        Area area = new Area();
        area.setId(TEST_DEFAULT_EXIST_ID);
        area.setUpdateUser(TestConstants.UER_NAME);
        boolean result = areaService.delete(area);
        Assert.isTrue(result);
    }
    
    /**
     * 测试删除数据-失败（ID不存在等）
     */
    @Test
    public void testDeleteFailure() {
        Assert.notNull(areaService);
        Area area = new Area();
        area.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        area.setUpdateUser(TestConstants.UER_NAME);
        boolean result = areaService.delete(area);
        Assert.isTrue(!result);
    }

    /**
     * 测试修改数据-成功
     */
    @Test
    public void testUpdate() {
        Assert.notNull(areaService);
        Area area = new Area();
        area.setId(TEST_DEFAULT_EXIST_ID);
        area.setCode("2");
        area.setUpdateUser(TestConstants.UER_NAME);
        boolean result = areaService.update(area);
        Assert.isTrue(result);
    }

    /**
     * 测试修改数据-失败（ID不存在等）
     */
    @Test
    public void testUpdateFailure() {
        Assert.notNull(areaService);
        Area area = new Area();
        area.setId(TEST_NOT_EXIST_ID);// 不存在的ID
        area.setCode("2");
        area.setUpdateUser(TestConstants.UER_NAME);
        boolean result = areaService.update(area);
        Assert.isTrue(!result);
    }

    /**
     * 测试依据ID查询数据-成功
     */
    @Test
    public void testQuery() {
        Assert.notNull(areaService);
        Area c = areaService.getAreaById(TEST_DEFAULT_EXIST_ID);
        Assert.notNull(c);
    }

    /**
     * 测试依据ID查询数据-失败（ID不存在等）
     */
    @Test
    public void testQueryFailure() {
        Assert.notNull(areaService);
        Area c = areaService.getAreaById(TEST_NOT_EXIST_ID);// 不存在的ID
        Assert.isNull(c);
    }

    /**
     * 测试分页查询数据-成功
     */
    @Test
    public void testQueryWithPage() {
        Assert.notNull(areaService);
        AreaQuery queryBean = null;
        PageUtil pageUtil = null;
        List<Area> list = areaService.queryAreaListWithPage(
                queryBean, pageUtil);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }

    /**
     * 测试查询数据集合-成功
     */
    @Test
    public void testQueryList() {
        Assert.notNull(areaService);
        AreaQuery queryBean = new AreaQuery();
        List<Area> list = areaService.queryAreaList(queryBean);
        Assert.notEmpty(list);
        logger.info("list size = " + list.size());
    }
}
