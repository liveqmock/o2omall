package com.letv.cache.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.letv.cache.demo.domain.Account;
import com.letv.cache.demo.service.AccountService;

/**
 * 账号服务实现类三：借助注解@Cacheable，同时添加清除缓存
 * 
 * @author lijianzhong
 * 
 */
@Service("thirdAccountService")
public class ThirdAccountServiceImpl implements AccountService {

    private static final Log LOGGER = LogFactory.getLog(ThirdAccountServiceImpl.class);

    /**
     * 使用了一个缓存名叫 accountCache
     */
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

    /**
     * 清空 accountCache 缓存
     */
    @CacheEvict(value = "accountCache", key = "#account.getName()")
    public void updateAccount(Account account) {
        updateDB(account);
    }

    /**
     * 清空 accountCache 缓存
     */
    @CacheEvict(value = "accountCache", allEntries = true)
    public void reload() {
    }

    private void updateDB(Account account) {
        LOGGER.info("real update db..." + account.getName());
    }
}
