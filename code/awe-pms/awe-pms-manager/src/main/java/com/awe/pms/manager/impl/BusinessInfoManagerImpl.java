package com.awe.pms.manager.impl;

import java.util.List;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.awe.pms.domain.BusinessInfo;
import com.awe.pms.domain.query.BusinessInfoQuery;
import com.awe.pms.dao.BusinessInfoDao;
import com.awe.pms.manager.BusinessInfoManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BusinessInfoManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-25 14:47:31
 * 
 */
@Component
public class BusinessInfoManagerImpl extends BaseManager implements BusinessInfoManager {
	
    @Autowired
    private BusinessInfoDao businessInfoDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<BusinessInfo> businessInfoList) {
        boolean resultFlag = false;
        if (null != businessInfoList && businessInfoList.size() > 0) {
            for (BusinessInfo businessInfo : businessInfoList) {
                resultFlag = businessInfoDao.insert(businessInfo);
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
    public boolean insert(BusinessInfo businessInfo) {
        return businessInfoDao.insert(businessInfo);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final BusinessInfo businessInfo) {
        return businessInfoDao.update(businessInfo);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessInfo> queryBusinessInfoList(BusinessInfoQuery queryBean) {
        return businessInfoDao.queryBusinessInfoList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<BusinessInfo> queryBusinessInfoListWithPage(BusinessInfoQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new BusinessInfoQuery();
        }

        // 查询总数
        int totalItem = queryBusinessInfoCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return businessInfoDao.queryBusinessInfoListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryBusinessInfoCount(BusinessInfoQuery queryBean) {
        return businessInfoDao.queryBusinessInfoCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(BusinessInfo businessInfo) {
        return businessInfoDao.delete(businessInfo);
    }

    /**
     * {@inheritDoc}
     */
    public BusinessInfo getBusinessInfoById(Long id) {
        return businessInfoDao.getBusinessInfoById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final BusinessInfo[] businessInfos) {
        boolean resultFlag = false;
        if (null != businessInfos && businessInfos.length > 0) {
            for (int i = 0; i < businessInfos.length; i++) {
                resultFlag = delete(businessInfos[i]);
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
    public boolean exist(BusinessInfo businessInfo) {
        return businessInfoDao.exist(businessInfo);
    }
}
