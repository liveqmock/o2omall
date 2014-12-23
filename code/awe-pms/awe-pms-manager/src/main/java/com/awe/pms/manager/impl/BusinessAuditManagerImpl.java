package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.BusinessAudit;
import com.awe.pms.domain.query.BusinessAuditQuery;
import com.awe.pms.dao.BusinessAuditDao;
import com.awe.pms.manager.BusinessAuditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BusinessAuditManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:20:58
 * 
 */
@Component
public class BusinessAuditManagerImpl extends BaseManager implements BusinessAuditManager {
	
    @Autowired
    private BusinessAuditDao businessAuditDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<BusinessAudit> businessAuditList) {
        boolean resultFlag = false;
        if (null != businessAuditList && businessAuditList.size() > 0) {
            for (BusinessAudit businessAudit : businessAuditList) {
                resultFlag = businessAuditDao.insert(businessAudit);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(BusinessAudit businessAudit) {
        return businessAuditDao.insert(businessAudit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final BusinessAudit businessAudit) {
        return businessAuditDao.update(businessAudit);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessAudit> queryBusinessAuditList(BusinessAuditQuery queryBean) {
        return businessAuditDao.queryBusinessAuditList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessAudit> queryBusinessAuditListWithPage(BusinessAuditQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new BusinessAuditQuery();
        }

        // 查询总数
        int totalItem = queryBusinessAuditCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return businessAuditDao.queryBusinessAuditListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryBusinessAuditCount(BusinessAuditQuery queryBean) {
        return businessAuditDao.queryBusinessAuditCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BusinessAudit businessAudit) {
        return businessAuditDao.delete(businessAudit);
    }

    /**
     * {@inheritDoc}
     */
    public BusinessAudit getBusinessAuditById(Long id) {
        return businessAuditDao.getBusinessAuditById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final BusinessAudit[] businessAudits) {
        boolean resultFlag = false;
        if (null != businessAudits && businessAudits.length > 0) {
            for (int i = 0; i < businessAudits.length; i++) {
                resultFlag = delete(businessAudits[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(BusinessAudit businessAudit) {
        return businessAuditDao.exist(businessAudit);
    }
}
