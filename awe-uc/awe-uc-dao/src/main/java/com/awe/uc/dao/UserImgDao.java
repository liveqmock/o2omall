package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
/**
 * UserImgDao接口<br/>
 * 对'用户关联图片'表进行基本的操作
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:27
 * 
 */
public interface UserImgDao {
    
    /**
     * 新增对象
     * 
     * @param userImg 
     * @return
     */
    public boolean insert(UserImg userImg);

    /**
     * 更新对象
     * 
     * @param userImg
     * @return
     */
    public boolean update(UserImg userImg);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserImg> queryUserImgList(UserImgQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserImgCount(UserImgQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserImg> queryUserImgListWithPage(UserImgQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userImg
     * @return
     */
    public boolean delete(UserImg userImg);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserImg getUserImgById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userImg
     * @return
     */
    public boolean exist(UserImg userImg);

}
