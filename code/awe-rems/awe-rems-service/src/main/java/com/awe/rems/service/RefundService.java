package com.awe.rems.service;

import java.util.List;

import com.awe.rems.domain.Refund;
import com.awe.rems.domain.query.RefundQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * RefundService接口
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
public interface RefundService {

    /**
     * 批量增加对象信息
     * 
     * @param refundList
     * @return
     */
    public boolean insert(List<Refund> refundList);

    /**
     * 单个增加对象信息
     * 
     * @param refund
     * @return
     */
    public boolean insert(Refund refund);

    /**
     * 更新 对象信息
     * 
     * @param refund
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(Refund refund);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Refund> queryRefundList(RefundQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<Refund> queryRefundListWithPage(RefundQuery queryBean,PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param refund
     *            　
     * @return
     */
    public boolean delete(Refund refund);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public Refund getRefundById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param refunds
     *            Refund集合
     * @return
     */
    public boolean delete(Refund[] refunds);
    
    /**
     * 根据queryBean获取对象
     * @param queryBean
     * @return
     */
    public Refund getRefundByBean(RefundQuery queryBean);
}
