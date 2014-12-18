package com.hbird.common.manager;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * manager基类 User: ljz Date: 2014-4-4 Time: 11:31:19
 */
public class BaseManager {
    private PlatformTransactionManager transactionManager;

    public TransactionTemplate getDataSourceTransactionManager() {
        return new TransactionTemplate(transactionManager);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
