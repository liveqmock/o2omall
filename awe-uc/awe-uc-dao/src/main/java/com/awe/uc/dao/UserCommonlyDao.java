package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
/**
 * UserCommonlyDao接口<br/>
 * 对'用户-常用信息'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
public interface UserCommonlyDao {
    
    /**
     * 新增对象
     * 
     * @param userCommonly 
     * @return
     */
    public boolean insert(UserCommonly userCommonly);

    /**
     * 更新对象
     * 
     * @param userCommonly
     * @return
     */
    public boolean update(UserCommonly userCommonly);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserCommonly> queryUserCommonlyList(UserCommonlyQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserCommonlyCount(UserCommonlyQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserCommonly> queryUserCommonlyListWithPage(UserCommonlyQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userCommonly
     * @return
     */
    public boolean delete(UserCommonly userCommonly);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserCommonly getUserCommonlyById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userCommonly
     * @return
     */
    public boolean exist(UserCommonly userCommonly);

}
