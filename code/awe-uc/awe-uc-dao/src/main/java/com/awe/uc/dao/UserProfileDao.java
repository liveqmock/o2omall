package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;
/**
 * UserProfileDao接口<br/>
 * 对'用户基本信息'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 15:38:38
 * 
 */
public interface UserProfileDao {
    
    /**
     * 新增对象
     * 
     * @param userProfile 
     * @return
     */
    public boolean insert(UserProfile userProfile);

    /**
     * 更新对象
     * 
     * @param userProfile
     * @return
     */
    public boolean update(UserProfile userProfile);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserProfile> queryUserProfileList(UserProfileQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserProfileCount(UserProfileQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserProfile> queryUserProfileListWithPage(UserProfileQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userProfile
     * @return
     */
    public boolean delete(UserProfile userProfile);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserProfile getUserProfileById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userProfile
     * @return
     */
    public boolean exist(UserProfile userProfile);
    /**
     * 根据UserProfile bean获取UserProfile
     * @param userProfile
     * @return
     */
    public UserProfile getUserProfileByBean(UserProfile userProfile);

}
