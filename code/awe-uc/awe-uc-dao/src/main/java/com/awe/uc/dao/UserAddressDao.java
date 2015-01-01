package com.awe.uc.dao;

import java.util.List;

import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
/**
 * UserAddressDao接口<br/>
 * 对'收货地址'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 15:38:38
 * 
 */
public interface UserAddressDao {
    
    /**
     * 新增对象
     * 
     * @param userAddress 
     * @return
     */
    public boolean insert(UserAddress userAddress);

    /**
     * 更新对象
     * 
     * @param userAddress
     * @return
     */
    public boolean update(UserAddress userAddress);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAddress> queryUserAddressList(UserAddressQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryUserAddressCount(UserAddressQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<UserAddress> queryUserAddressListWithPage(UserAddressQuery queryBean);

    /**
     * 删除记录
     * 
     * @param userAddress
     * @return
     */
    public boolean delete(UserAddress userAddress);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public UserAddress getUserAddressById(Long id);

    /**
     * 判断是否存在
     * 
     * @param userAddress
     * @return
     */
    public boolean exist(UserAddress userAddress);
    /**
     * 设置默认配置地址
     * @param userAddress
     * @return
     */
    public boolean updateDefault(UserAddress userAddress);
}
