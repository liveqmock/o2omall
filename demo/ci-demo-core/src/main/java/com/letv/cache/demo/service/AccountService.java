/**
 * 
 */
package com.letv.cache.demo.service;

import com.letv.cache.demo.domain.Account;

/**
 * 账号服务接口
 * 
 * @author lijianzhong
 * 
 */
public interface AccountService {

    /**
     * 查询
     * 
     * @param acctName
     * @return
     */
    Account getAccountByName(String acctName);

    /**
     * 修改
     * 
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 重置缓存
     */
    void reload();
}
