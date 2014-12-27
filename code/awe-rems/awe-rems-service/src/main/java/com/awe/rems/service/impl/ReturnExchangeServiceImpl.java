package com.awe.rems.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.awe.rems.manager.ReturnExchangeManager;
import com.awe.rems.service.ReturnExchangeService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;
 
/**
 * ReturnExchangeService接口的实现类
 * 
 * @author zyq
 * @version 2014-12-25 9:16:21
 * 
 */
@Service
public class ReturnExchangeServiceImpl implements ReturnExchangeService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ReturnExchangeServiceImpl.class);

    @Autowired
    private ReturnExchangeManager returnExchangeManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.batchInsert")
    public boolean insert(List<ReturnExchange> returnExchangeList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(returnExchangeList)) {
                resultFlag = returnExchangeManager.insert(returnExchangeList);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.insert")
    public boolean insert(ReturnExchange returnExchange) {
        boolean resultFlag = false;
        try {
            if (null != returnExchange) {
                if (returnExchangeManager.exist(returnExchange)) {
                    throw new ExistedException();
                }
                resultFlag = returnExchangeManager.insert(returnExchange);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ReturnExchangeServiceImpl#insert failed, returnExchange has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.update")
    public boolean update(ReturnExchange returnExchange) {
        boolean resultFlag = false;
        try {
            if (null != returnExchange && null != returnExchange.getId()) {
                resultFlag = returnExchangeManager.update(returnExchange);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.queryReturnExchangeList")
    public List<ReturnExchange> queryReturnExchangeList(ReturnExchangeQuery queryBean) {
        List<ReturnExchange> returnExchangeList = null;
        try {
            returnExchangeList = returnExchangeManager.queryReturnExchangeList(queryBean);
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#queryReturnExchangeList has error.", e);
        }
        return returnExchangeList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.queryReturnExchangeListWithPage")
    public List<ReturnExchange> queryReturnExchangeListWithPage(ReturnExchangeQuery queryBean, PageUtil pageUtil) {
        List<ReturnExchange> returnExchangeList = null;
        try {
            returnExchangeList = returnExchangeManager.queryReturnExchangeListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#queryReturnExchangeListWithPage has error.", e);
        }
        return returnExchangeList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.delete")
    public boolean delete(ReturnExchange returnExchange) {
        boolean resultFlag = false;
        try {
            if (null != returnExchange && null != returnExchange.getId()) {
                resultFlag = returnExchangeManager.delete(returnExchange);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.batchDelete")
    public boolean delete(ReturnExchange[] returnExchanges) {
        boolean resultFlag = false;
        try {
            if (null != returnExchanges && returnExchanges.length > 0) {
                resultFlag = returnExchangeManager.delete(returnExchanges);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ReturnExchangeService.getReturnExchangeById")
    public ReturnExchange getReturnExchangeById(Long id) {
        ReturnExchange returnExchange = null;
        try {
            if (null != id) {
                returnExchange = returnExchangeManager.getReturnExchangeById(id);
            } else {
                LOG.warn("ReturnExchangeServiceImpl#getReturnExchangeById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ReturnExchangeServiceImpl#getReturnExchangeById has error.", e);
        }
        return returnExchange;
    }
}

