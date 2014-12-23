package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * UserAccountService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
public interface UserAccountService {

    /**
     * 批量增加对象信息
     * 
     * @param userAccountList
     * @return
     */
    public boolean insert(List<UserAccount> userAccountList);

    /**
     * 单个增加对象信息
     * 
     * @param userAccount
     * @return
     */
    public boolean insert(UserAccount userAccount);

    /**
     * 更新 对象信息
     * 
     * @param userAccount
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserAccount userAccount);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAccount> queryUserAccountList(UserAccountQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserAccount> queryUserAccountListWithPage(UserAccountQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userAccount
     *            　
     * @return
     */
    public boolean delete(UserAccount userAccount);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserAccount getUserAccountById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userAccounts
     *            UserAccount集合
     * @return
     */
    public boolean delete(UserAccount[] userAccounts);
}
