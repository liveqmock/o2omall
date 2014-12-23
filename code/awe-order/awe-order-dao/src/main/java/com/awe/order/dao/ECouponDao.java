package com.awe.order.dao;

import java.util.List;

import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;
/**
 * ECouponDao接口<br/>
 * 对'电子券'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:35
 * 
 */
public interface ECouponDao {
    
    /**
     * 新增对象
     * 
     * @param eCoupon 
     * @return
     */
    public boolean insert(ECoupon eCoupon);

    /**
     * 更新对象
     * 
     * @param eCoupon
     * @return
     */
    public boolean update(ECoupon eCoupon);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ECoupon> queryECouponList(ECouponQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryECouponCount(ECouponQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ECoupon> queryECouponListWithPage(ECouponQuery queryBean);

    /**
     * 删除记录
     * 
     * @param eCoupon
     * @return
     */
    public boolean delete(ECoupon eCoupon);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public ECoupon getECouponById(Long id);

    /**
     * 判断是否存在
     * 
     * @param eCoupon
     * @return
     */
    public boolean exist(ECoupon eCoupon);

}
