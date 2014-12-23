package com.hbird.test.common.core.redis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.common.utils.page.Query;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * TODO
 * <p/>
 * User: ljz Date: 2014-4-18 Time: 上午10:50:46 Version: 1.0
 */
public class JsonUtilTest {
    @Test
    public void testJson() {
        PaginatedArrayList<Query> list = new PaginatedArrayList<Query>();
        List<Query> list2 = new ArrayList<Query>();

        Query e = new Query();
        e.setPageIndex(1);
        e.setPageSize(10);
        list.add(e);
        list.setTotalItem(30);

        list2.add(e);
        String json = JsonHelper.toJson(list);
        String json2 = JsonHelper.toJson(list2);

        Assert.notNull(json);
        Assert.notNull(json2);

    }
}
