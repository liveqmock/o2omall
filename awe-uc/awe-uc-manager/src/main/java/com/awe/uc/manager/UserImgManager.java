package com.awe.uc.manager;

import java.util.List;

import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * UserImgManager接口
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:31
 * 
 */
public interface UserImgManager {

    /**
     * 批量增加对象信息
     * 
     * @param userImgList
     * @return
     */
    public boolean insert(List<UserImg> userImgList);

    /**
     * 单个增加对象信息
     * 
     * @param userImg
     * @return
     */
    public boolean insert(UserImg userImg);

    /**
     * 更新 对象信息
     * 
     * @param userImg
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserImg userImg);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserImg> queryUserImgList(UserImgQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserImg> queryUserImgListWithPage(UserImgQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryUserImgCount(UserImgQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userImg
     *            　
     * @return
     */
    public boolean delete(UserImg userImg);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserImg getUserImgById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userImgs
     *            UserImg集合
     * @return
     */
    public boolean delete(UserImg[] userImgs);

    /**
     * 判断是否存在
     * 
     * @param userImg
     * @return
     */
    public boolean exist(UserImg userImg);
}
