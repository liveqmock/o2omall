package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;
import com.hbird.portal.manager.SystemManager;
import com.hbird.portal.service.SystemService;
import com.hbird.portal.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;

/**
 * SystemService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:26
 * 
 */
@Service
public class SystemServiceImpl implements SystemService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(SystemServiceImpl.class);

    @Autowired
    private SystemManager systemManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.batchInsert")
    public boolean insert(List<System> systemList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(systemList)) {
                resultFlag = systemManager.insert(systemList);
            } else {
                LOG.warn("SystemServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.insert")
    public boolean insert(System system) {
        boolean resultFlag = false;
        try {
            if (null != system) {
                if (systemManager.exist(system)) {
                    throw new ExistedException();
                }
                resultFlag = systemManager.insert(system);
            } else {
                LOG.warn("SystemServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("SystemServiceImpl#insert failed, system has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.update")
    public boolean update(System system) {
        boolean resultFlag = false;
        try {
            if (null != system && null != system.getId()) {
                resultFlag = systemManager.update(system);
            } else {
                LOG.warn("SystemServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.querySystemList")
    public List<System> querySystemList(SystemQuery queryBean) {
        List<System> systemList = null;
        try {
            systemList = systemManager.querySystemList(queryBean);
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#querySystemList has error.", e);
        }
        return systemList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.querySystemListWithPage")
    public List<System> querySystemListWithPage(SystemQuery queryBean, PageUtil pageUtil) {
        List<System> systemList = null;
        try {
            systemList = systemManager.querySystemListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#querySystemListWithPage has error.", e);
        }
        return systemList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.delete")
    public boolean delete(System system) {
        boolean resultFlag = false;
        try {
            if (null != system && null != system.getId()) {
                resultFlag = systemManager.delete(system);
            } else {
                LOG.warn("SystemServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.batchDelete")
    public boolean delete(System[] systems) {
        boolean resultFlag = false;
        try {
            if (null != systems && systems.length > 0) {
                resultFlag = systemManager.delete(systems);
            } else {
                LOG.warn("SystemServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "SystemService.getSystemById")
    public System getSystemById(Long id) {
        System system = null;
        try {
            if (null != id) {
                system = systemManager.getSystemById(id);
            } else {
                LOG.warn("SystemServiceImpl#getSystemById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("SystemServiceImpl#getSystemById has error.", e);
        }
        return system;
    }
}
