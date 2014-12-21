package com.awe.uc.service;

import java.util.List;

import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * UserBasicService接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
public interface UserBasicService {

    /**
     * 批量增加对象信息
     * 
     * @param userBasicList
     * @return
     */
    public boolean insert(List<UserBasic> userBasicList);

    /**
     * 单个增加对象信息
     * 
     * @param userBasic
     * @return
     */
    public boolean insert(UserBasic userBasic);

    /**
     * 更新 对象信息
     * 
     * @param userBasic
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserBasic userBasic);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserBasic> queryUserBasicList(UserBasicQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserBasic> queryUserBasicListWithPage(UserBasicQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userBasic
     *            　
     * @return
     */
    public boolean delete(UserBasic userBasic);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserBasic getUserBasicById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userBasics
     *            UserBasic集合
     * @return
     */
    public boolean delete(UserBasic[] userBasics);
}
