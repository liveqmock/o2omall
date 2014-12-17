package com.letv.cache.demo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.letv.cache.demo.domain.Account;
import com.letv.cache.demo.service.AccountService;
import com.letv.test.BaseTestCase;

public class AccountServiceTestCase extends BaseTestCase {

    @Autowired
    private AccountService firstAccountService;

    @Autowired
    private AccountService secondAccountService;
    @Autowired
    private AccountService thirdAccountService;

    @Test
    public void testFirst() {
        testAccount(firstAccountService, "somebody1");
    }

    @Test
    public void testSecond() {
        testAccount(secondAccountService, "somebody2");
    }

    @Test
    public void testThird() {
        testAccount(thirdAccountService, "somebody3");

        logger.info("start testing clear cache...");
        testUpdateAccount(thirdAccountService);
    }

    private void testUpdateAccount(AccountService service) {
        // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = service.getAccountByName("somebody31");
        Assert.notNull(account1);
        logger.info("account1.name= " + account1.getName());

        Account account2 = service.getAccountByName("somebody32");
        Assert.notNull(account2);
        logger.info("account2.name= " + account2.getName());

        logger.info("update account1......");
        account1.setId(344);
        service.updateAccount(account1);

        // 开始更新其中一个
        logger.info("after updating account1......");
        // 因为被更新了，所以会查询数据库
        Account account21 = service.getAccountByName("somebody31");
        Assert.notNull(account21);
        logger.info("account1.name= " + account21.getName());
        // 再次查询，应该走缓存
        Account account31 = service.getAccountByName("somebody31");
        Assert.notNull(account31);
        logger.info("account1.name= " + account31.getName());

        // 没有更新过，应该走缓存
        Account account22 = service.getAccountByName("somebody32");
        Assert.notNull(account22);
        logger.info("account2.name= " + account22.getName());
    }

    protected void testAccount(AccountService service, String accName) {
        // 开始查询账号
        // 第一次查询，应该是数据库查询
        queryAccount(service, accName, 1);
        // 第二次查询，应该直接从缓存返回
        queryAccount(service, accName, 2);

        // 重置缓存
        service.reload();
        logger.info("after reload...");

        // 第三次查询，应该是数据库查询
        queryAccount(service, accName, 3);

        // 第四次查询，应该直接从缓存返回
        queryAccount(service, accName, 4);

    }

    protected void queryAccount(AccountService service, String accName, int times) {
        Account account = service.getAccountByName(accName);
        Assert.notNull(account);
        logger.info("account" + String.valueOf(times) + ".name= " + account.getName());
    }

}
