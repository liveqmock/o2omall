package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
/**
 * UserAccountDao接口<br/>
 * 对'用户账号'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
public interface UserAccountDao {
    
    /**
     * 新增对象
     * 
     * @param userAccount 
     * @return
     */
    public boolean insert(UserAccount userAccount);

    /**
     * 更新对象
     * 
     * @param userAccount
     * @return
     */
    public boolean update(UserAccount userAccount);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAccount> queryUserAccountList(UserAccountQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserAccountCount(UserAccountQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAccount> queryUserAccountListWithPage(UserAccountQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userAccount
     * @return
     */
    public boolean delete(UserAccount userAccount);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserAccount getUserAccountById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userAccount
     * @return
     */
    public boolean exist(UserAccount userAccount);

}
