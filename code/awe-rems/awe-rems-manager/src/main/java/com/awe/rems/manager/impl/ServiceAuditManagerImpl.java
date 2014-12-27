package com.awe.rems.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.awe.rems.dao.ServiceAuditDao;
import com.awe.rems.manager.ServiceAuditManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ServiceAuditManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 9:16:21
 * 
 */
@Component
public class ServiceAuditManagerImpl extends BaseManager implements ServiceAuditManager {
	
    @Autowired
    private ServiceAuditDao serviceAuditDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ServiceAudit> serviceAuditList) {
        boolean resultFlag = false;
        if (null != serviceAuditList && serviceAuditList.size() > 0) {
            for (ServiceAudit serviceAudit : serviceAuditList) {
                resultFlag = serviceAuditDao.insert(serviceAudit);
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
    public boolean insert(ServiceAudit serviceAudit) {
        return serviceAuditDao.insert(serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ServiceAudit serviceAudit) {
        return serviceAuditDao.update(serviceAudit);
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean) {
        return serviceAuditDao.queryServiceAuditList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ServiceAuditQuery();
        }

        // 查询总数
        int totalItem = queryServiceAuditCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return serviceAuditDao.queryServiceAuditListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryServiceAuditCount(ServiceAuditQuery queryBean) {
        return serviceAuditDao.queryServiceAuditCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public ServiceAudit getServiceAuditById(Long id) {
        return serviceAuditDao.getServiceAuditById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(ServiceAudit serviceAudit) {
        return serviceAuditDao.exist(serviceAudit);
    }
}
