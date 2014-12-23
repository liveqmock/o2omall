package com.awe.order.manager;

import java.util.List;

import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * ECouponManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
public interface ECouponManager {

    /**
     * 批量增加对象信息
     * 
     * @param eCouponList
     * @return
     */
    public boolean insert(List<ECoupon> eCouponList);

    /**
     * 单个增加对象信息
     * 
     * @param eCoupon
     * @return
     */
    public boolean insert(ECoupon eCoupon);

    /**
     * 更新 对象信息
     * 
     * @param eCoupon
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ECoupon eCoupon);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ECoupon> queryECouponList(ECouponQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ECoupon> queryECouponListWithPage(ECouponQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryECouponCount(ECouponQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param eCoupon
     *            　
     * @return
     */
    public boolean delete(ECoupon eCoupon);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ECoupon getECouponById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param eCoupons
     *            ECoupon集合
     * @return
     */
    public boolean delete(ECoupon[] eCoupons);

    /**
     * 判断是否存在
     * 
     * @param eCoupon
     * @return
     */
    public boolean exist(ECoupon eCoupon);
}
