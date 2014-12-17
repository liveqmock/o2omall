package com.letv.cache.demo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.letv.cache.demo.domain.Account;
import com.letv.cache.demo.service.AccountService;

/**
 * 账号服务实现类一：自定义缓存实现
 * 
 * @author lijianzhong
 * 
 */
@Service("firstAccountService")
public class FirstAccountServiceImpl implements AccountService {

    private static final Log LOGGER = LogFactory.getLog(FirstAccountServiceImpl.class);

    private MyCacheManager<Account> cacheManager;

    public FirstAccountServiceImpl() {
        cacheManager = new MyCacheManager<Account>();// 构造一个缓存管理器
    }

    public Account getAccountByName(String acctName) {
        LOGGER.info("real query account. acctName=" + acctName);

        Account result = cacheManager.getValue(acctName);// 首先查询缓存
        if (result != null) {
            LOGGER.info("get from cache..." + acctName);
            return result;// 如果在缓存中，则直接返回缓存的结果
        }

        result = getFromDB(acctName);// 否则到数据库中查询
        if (result != null) {// 将数据库查询的结果更新到缓存中
            cacheManager.addOrUpdateCache(acctName, result);
        }
        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private Account getFromDB(String acctName) {
        LOGGER.info("real querying db..." + acctName);
        return new Account(acctName);
    }

    public void updateAccount(Account account) {
        // do nothing
    }
}
