package com.hbird.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.sdk.api.response.dto.ResourceDto;
import com.hbird.portal.test.BaseTransactionTestCase;

public class ResourceServiceTestCase extends BaseTransactionTestCase {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testQueryResourceTree() {
        Assert.notNull(resourceService);

        List<Resource> resources = resourceService.queryResourceTree(3L);
        Assert.notEmpty(resources);

        logger.info("resources 查询结果：" + resources.size());
    }

    @Test
    public void testQueryResourceList() {
        Assert.notNull(resourceService);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userName", "zhangsan");
        paramMap.put("systemId", 10);

        List<Resource> resources = resourceService.queryResourceList(paramMap);
        Assert.notEmpty(resources);

        logger.info("resources 查询结果：" + resources.size());
        List<ResourceDto> list = convert(resources);
        Assert.notEmpty(list);
    }

    // 数据转换
    private List<ResourceDto> convert(List<Resource> resources) {
        if (CollectionUtils.isEmpty(resources)) {
            return null;
        }
        List<ResourceDto> list = new ArrayList<ResourceDto>(resources.size());
        for (Resource resource : resources) {
            ResourceDto response = new ResourceDto();
            BeanUtils.copyProperties(resource, response);
            list.add(response);
        }
        return list;
    }

}
