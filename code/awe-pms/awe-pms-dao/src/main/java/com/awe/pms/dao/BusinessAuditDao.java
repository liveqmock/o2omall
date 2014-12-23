package com.awe.pms.dao;

import java.util.List;

import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;
/**
 * BusinessAuditDao接口<br/>
 * 对'审核商家流水表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:20:57
 * 
 */
public interface BusinessAuditDao {
    
    /**
     * 新增对象
     * 
     * @param businessAudit 
     * @return
     */
    public boolean insert(BusinessAudit businessAudit);

    /**
     * 更新对象
     * 
     * @param businessAudit
     * @return
     */
    public boolean update(BusinessAudit businessAudit);

    /**
     * 根据查询Bean获取对象集合，不带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BusinessAudit> queryBusinessAuditList(BusinessAuditQuery queryBean);

    /**
     * 根据查询Bean获取总数
     * 
     * @param queryBean
     * @return
     */
    public int queryBusinessAuditCount(BusinessAuditQuery queryBean);

    /**
     * 根据查询Bean获取集合，带翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BusinessAudit> queryBusinessAuditListWithPage(BusinessAuditQuery queryBean);

    /**
     * 删除记录
     * 
     * @param businessAudit
     * @return
     */
    public boolean delete(BusinessAudit businessAudit);

    /**
     * 根据主键获取对象
     * 
     * @param id
     *            主键字段
     * @return
     */
    public BusinessAudit getBusinessAuditById(Long id);

    /**
     * 判断是否存在
     * 
     * @param businessAudit
     * @return
     */
    public boolean exist(BusinessAudit businessAudit);

}
