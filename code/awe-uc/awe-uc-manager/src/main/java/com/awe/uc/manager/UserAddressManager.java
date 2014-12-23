package com.awe.uc.manager;

import java.util.List;

import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * UserAddressManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
public interface UserAddressManager {

    /**
     * 批量增加对象信息
     * 
     * @param userAddressList
     * @return
     */
    public boolean insert(List<UserAddress> userAddressList);

    /**
     * 单个增加对象信息
     * 
     * @param userAddress
     * @return
     */
    public boolean insert(UserAddress userAddress);

    /**
     * 更新 对象信息
     * 
     * @param userAddress
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(UserAddress userAddress);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAddress> queryUserAddressList(UserAddressQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<UserAddress> queryUserAddressListWithPage(UserAddressQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryUserAddressCount(UserAddressQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param userAddress
     *            　
     * @return
     */
    public boolean delete(UserAddress userAddress);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public UserAddress getUserAddressById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param userAddresss
     *            UserAddress集合
     * @return
     */
    public boolean delete(UserAddress[] userAddresss);

    /**
     * 判断是否存在
     * 
     * @param userAddress
     * @return
     */
    public boolean exist(UserAddress userAddress);
}
