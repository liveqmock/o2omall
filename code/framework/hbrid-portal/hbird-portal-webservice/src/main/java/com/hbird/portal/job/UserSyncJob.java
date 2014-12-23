package com.hbird.portal.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbird.portal.service.SyncDataService;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-15 上午10:36:15
 */
public class UserSyncJob {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private SyncDataService syncDataService;

    public void execute() {
        this.logger.info("UserSyncJob 定时任务 开始");
        this.syncDataService.executeUser();
    }
}
