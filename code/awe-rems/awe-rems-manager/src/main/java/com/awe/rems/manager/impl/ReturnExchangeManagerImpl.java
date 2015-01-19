package com.awe.rems.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awe.rems.dao.ReturnExchangeDao;
import com.awe.rems.dao.ServiceAuditDao;
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.constant.CommonConstant;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.awe.rems.manager.ReturnExchangeManager;
import com.awe.rems.utils.code.BusinessCodeGenerator;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;

/**
 * ReturnExchangeManager接口的实现类
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Component
public class ReturnExchangeManagerImpl extends BaseManager implements ReturnExchangeManager {
	
    @Autowired
    private ReturnExchangeDao returnExchangeDao;
    @Autowired
    private ServiceAuditDao serviceAuditDao;
    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<ReturnExchange> returnExchangeList) {
        boolean resultFlag = false;
        if (null != returnExchangeList && returnExchangeList.size() > 0) {
            for (ReturnExchange returnExchange : returnExchangeList) {
                resultFlag = returnExchangeDao.insert(returnExchange);
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
    public boolean insert(ReturnExchange returnExchange) {
    	boolean ret = false;
    	boolean result = false;
    	boolean auditResult = false;
    	ret = returnExchangeDao.insert(returnExchange);
    	String prefix = "";
    	if(ret){
    		if((null != returnExchange.getServiceType()) && (CommonConstant.ServiceType.H == returnExchange.getServiceType().intValue())){
    			prefix = CommonConstant.HUANHUO_CODE_PREFIX;
    		} else if((null != returnExchange.getServiceType()) && (CommonConstant.ServiceType.T == returnExchange.getServiceType().intValue())){
    			prefix = CommonConstant.TUIHUO_CODE_PREFIX;
    		}else if((null != returnExchange.getServiceType()) && (CommonConstant.ServiceType.X == returnExchange.getServiceType().intValue())){
    			prefix = CommonConstant.WEIXU_CODE_PREFIX;
    		}
    		String serviceNo = BusinessCodeGenerator.getCode(prefix, returnExchange.getId(), 10);
    		returnExchange.setServiceNo(serviceNo);
    		result = returnExchangeDao.update(returnExchange);
    		if(result){
    			ServiceAudit serviceAudit = new ServiceAudit();
    			serviceAudit.setOrderNo(returnExchange.getOrderNo());
    			serviceAudit.setReturnExchangeId(returnExchange.getId());
    			serviceAudit.setCreateUser(returnExchange.getCreateUser());
    			serviceAudit.setCreateUserId(returnExchange.getCreateUserId());
    			serviceAudit.setServiceNo(serviceNo);
    			serviceAudit.setStatus(CommonConstant.ReturnExchangeStatus.USER_SUBMIT_STATUS);
    			serviceAudit.setUpdateUser(returnExchange.getUpdateUser());
    			serviceAudit.setUpdateUserId(returnExchange.getUpdateUserId());
    			auditResult = serviceAuditDao.insert(serviceAudit);
    		}
    	}
    	if(ret && result && auditResult){
    		return true;
    	}else{
    		return false;
    	}
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final ReturnExchange returnExchange) {
        return returnExchangeDao.update(returnExchange);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchange> queryReturnExchangeList(ReturnExchangeQuery queryBean) {
        return returnExchangeDao.queryReturnExchangeList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<ReturnExchange> queryReturnExchangeListWithPage(ReturnExchangeQuery queryBean,
            PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ReturnExchangeQuery();
        }

        // 查询总数
        int totalItem = queryReturnExchangeCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();
        
        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return returnExchangeDao.queryReturnExchangeListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryReturnExchangeCount(ReturnExchangeQuery queryBean) {
        return returnExchangeDao.queryReturnExchangeCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(ReturnExchange returnExchange) {
        return returnExchangeDao.delete(returnExchange);
    }

    /**
     * {@inheritDoc}
     */
    public ReturnExchange getReturnExchangeById(Long id) {
        return returnExchangeDao.getReturnExchangeById(id);
    }
    
    public ReturnExchange getReturnExchangeByServiceNo(String ServiceNo){
    	return returnExchangeDao.getReturnExchangeByServiceNo(ServiceNo);
    }
    /**
     * {@inheritDoc}
     */
    public boolean delete(final ReturnExchange[] returnExchanges) {
        boolean resultFlag = false;
        if (null != returnExchanges && returnExchanges.length > 0) {
            for (int i = 0; i < returnExchanges.length; i++) {
                resultFlag = delete(returnExchanges[i]);
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
    public boolean exist(ReturnExchange returnExchange) {
        return returnExchangeDao.exist(returnExchange);
    }
}
