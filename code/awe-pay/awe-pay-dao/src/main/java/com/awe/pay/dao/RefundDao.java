package com.awe.pay.dao;

import java.util.List;

import com.awe.pay.domain.Refund;
import com.awe.pay.domain.query.RefundQuery;
/**
 * RefundDao接口<br/>
 * 对'逆向退款'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:26
 * 
 */
public interface RefundDao {
    
    /**
     * 新增对象
     * 
     * @param refund 
     * @return
     */
    public boolean insert(Refund refund);

    /**
     * 更新对象
     * 
     * @param refund
     * @return
     */
    public boolean update(Refund refund);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Refund> queryRefundList(RefundQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryRefundCount(RefundQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<Refund> queryRefundListWithPage(RefundQuery queryBean);

    /**
     * 删除记录
     * 
     * @param refund
     * @return
     */
    public boolean delete(Refund refund);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public Refund getRefundById(Long id);

    /**
     * 判断是否存在
     * 
     * @param refund
     * @return
     */
    public boolean exist(Refund refund);

}
