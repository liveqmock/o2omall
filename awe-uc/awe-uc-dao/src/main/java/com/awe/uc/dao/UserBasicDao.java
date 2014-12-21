package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
/**
 * UserBasicDao接口<br/>
 * 对'用户基本信息'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
public interface UserBasicDao {
    
    /**
     * 新增对象
     * 
     * @param userBasic 
     * @return
     */
    public boolean insert(UserBasic userBasic);

    /**
     * 更新对象
     * 
     * @param userBasic
     * @return
     */
    public boolean update(UserBasic userBasic);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserBasic> queryUserBasicList(UserBasicQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserBasicCount(UserBasicQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserBasic> queryUserBasicListWithPage(UserBasicQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userBasic
     * @return
     */
    public boolean delete(UserBasic userBasic);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserBasic getUserBasicById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userBasic
     * @return
     */
    public boolean exist(UserBasic userBasic);

}
