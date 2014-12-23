package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.UserProfile;
import com.awe.uc.domain.query.UserProfileQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * UserProfileService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
public interface UserProfileService {

    /**
     * 批量增加对象信息
     * 
     * @param userProfileList
     * @return
     */
    public boolean insert(List<UserProfile> userProfileList);

    /**
     * 单个增加对象信息
     * 
     * @param userProfile
     * @return
     */
    public boolean insert(UserProfile userProfile);

    /**
     * 更新 对象信息
     * 
     * @param userProfile
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserProfile userProfile);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserProfile> queryUserProfileList(UserProfileQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserProfile> queryUserProfileListWithPage(UserProfileQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userProfile
     *            　
     * @return
     */
    public boolean delete(UserProfile userProfile);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserProfile getUserProfileById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userProfiles
     *            UserProfile集合
     * @return
     */
    public boolean delete(UserProfile[] userProfiles);
}
