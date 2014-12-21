package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * UserCommonlyService接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
public interface UserCommonlyService {

    /**
     * 批量增加对象信息
     * 
     * @param userCommonlyList
     * @return
     */
    public boolean insert(List<UserCommonly> userCommonlyList);

    /**
     * 单个增加对象信息
     * 
     * @param userCommonly
     * @return
     */
    public boolean insert(UserCommonly userCommonly);

    /**
     * 更新 对象信息
     * 
     * @param userCommonly
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserCommonly userCommonly);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserCommonly> queryUserCommonlyList(UserCommonlyQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserCommonly> queryUserCommonlyListWithPage(UserCommonlyQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userCommonly
     *            　
     * @return
     */
    public boolean delete(UserCommonly userCommonly);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserCommonly getUserCommonlyById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userCommonlys
     *            UserCommonly集合
     * @return
     */
    public boolean delete(UserCommonly[] userCommonlys);
}
