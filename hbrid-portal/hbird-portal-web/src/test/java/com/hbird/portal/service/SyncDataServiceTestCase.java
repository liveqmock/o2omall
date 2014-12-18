/**
 * 
 */
package com.hbird.portal.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.hbird.portal.domain.User;
import com.hbird.portal.test.BaseTransactionTestCase;

/**
 * 
 * 用户和部门同步的TestCase
 * 
 * @author ljz
 * @version 2014-11-27 下午9:09:38
 */
public class SyncDataServiceTestCase extends BaseTransactionTestCase {

    @Autowired
    private SyncDataService syncDataService;

    @Test
    public void testExecuteDep() {
        syncDataService.executeDep();
    }

    @Test
    public void testExecuteUser() {
        syncDataService.executeUser();
    }

    @Test
    public void testSyncUser() {
        String username = "lijianzhong@hbird.com";
        User result = syncDataService.syncUser(username);
        Assert.notNull(result);
    }
}
