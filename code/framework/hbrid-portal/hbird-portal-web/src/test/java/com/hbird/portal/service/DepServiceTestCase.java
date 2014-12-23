package com.hbird.portal.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;
import com.hbird.portal.test.BaseTransactionTestCase;

public class DepServiceTestCase extends BaseTransactionTestCase {

    @Autowired
    private DepService depService;

    @Test
    public void testInsert() {
        Dep dep = new Dep();
        dep.setCode("001");
        dep.setName("部门2");

        logger.info("部门信息增加结果：" + depService.insert(dep));
    }

    @Test
    public void testUpdate() {
        Dep dep = new Dep();
        dep.setId((long) 5);
        dep.setName("部门-upadte");

        logger.info("部门信息更新结果：" + depService.update(dep));
    }

    @Test
    public void testQueryWithPage() {
        DepQuery query = new DepQuery();
        query.setPageIndex(2);
        query.setPageSize(10);
        PaginatedArrayList<Dep> list = depService.queryDepListWithPage(query, 2, 10);
        Assert.notNull(list);
        Assert.notEmpty(list.getRows());

        logger.info("部门信息查询结果：" + list.size());
    }
}
