package com.letv.cache.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.letv.cache.demo.domain.Account;
import com.letv.cache.demo.service.AccountService;

/**
 * 账号服务实现类二：借助注解@Cacheable
 * 
 * @author lijianzhong
 * 
 */
@Service("secondAccountService")
public class SecondAccountServiceImpl implements AccountService {

    private static final Log LOGGER = LogFactory.getLog(SecondAccountServiceImpl.class);

    // 使用了一个缓存名叫 accountCache
    @Cacheable(value = "accountCache")
    public Account getAccountByName(String acctName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        LOGGER.info("real query account. acctName=" + acctName);
        return getFromDB(acctName);
    }

    private Account getFromDB(String acctName) {
        LOGGER.info("real querying db..." + acctName);
        return new Account(acctName);
    }

    public void reload() {
        // do nothing
    }

    public void updateAccount(Account account) {
        // do nothing
    }
}
