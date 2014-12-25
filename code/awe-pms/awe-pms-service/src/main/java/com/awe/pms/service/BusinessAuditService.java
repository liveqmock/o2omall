package com.awe.pms.service;

import java.util.List;

import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * BusinessAuditService接口
 * 
 * @author ljz
 * @version 2014-12-25 9:31:54
 * 
 */
public interface BusinessAuditService {

    /**
     * 批量增加对象信息
     * 
     * @param businessAuditList
     * @return
     */
    public boolean insert(List<BusinessAudit> businessAuditList);

    /**
     * 单个增加对象信息
     * 
     * @param businessAudit
     * @return
     */
    public boolean insert(BusinessAudit businessAudit);

    /**
     * 更新 对象信息
     * 
     * @param businessAudit
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(BusinessAudit businessAudit);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<BusinessAudit> queryBusinessAuditList(BusinessAuditQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<BusinessAudit> queryBusinessAuditListWithPage(BusinessAuditQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param businessAudit
     *            　
     * @return
     */
    public boolean delete(BusinessAudit businessAudit);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public BusinessAudit getBusinessAuditById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param businessAudits
     *            BusinessAudit集合
     * @return
     */
    public boolean delete(BusinessAudit[] businessAudits);
}
