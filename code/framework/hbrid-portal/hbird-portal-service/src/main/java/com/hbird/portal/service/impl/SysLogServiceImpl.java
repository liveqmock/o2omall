package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.query.SysLogQuery;
import com.hbird.portal.manager.SysLogManager;
import com.hbird.portal.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;

/**
 * User: ljz Date: 2014-04-15 Time: 10:22:04
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    private final static Logger log = LogManager.getLogger(SysLogServiceImpl.class);
    @Autowired
    private SysLogManager sysLogManager;

    @Profiled(tag = "SysLogService.batchInsert")
    public boolean insert(List<SysLog> beanList) {
        boolean resultFlag = false;
        try {
            resultFlag = sysLogManager.insert(beanList);
        } catch (Exception e) {
            log.error("SysLogServiceImpl -> insert() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SysLogService.insert")
    public boolean insert(SysLog bean) {
        boolean resultFlag = false;
        try {
            if (null != bean) {
                resultFlag = sysLogManager.insert(bean);
            } else {
                log.error("param is null!");
            }
        } catch (Exception e) {
            log.error("SysLogServiceImpl!insert(SysLog bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SysLogService.update")
    public boolean update(SysLog bean) {
        boolean resultFlag = false;
        try {
            resultFlag = sysLogManager.update(bean);
        } catch (Exception e) {
            log.error("SysLogServiceImpl!update(SysLog bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SysLogService.querySysLogList")
    public List<SysLog> querySysLogList(SysLogQuery queryBean) {
        List<SysLog> sysLogList = null;
        try {
            sysLogList = sysLogManager.querySysLogList(queryBean);
        } catch (Exception e) {
            log.error("SysLogServiceImpl -> querySysLogList() error!!", e);
        }
        return sysLogList;
    }

    @Profiled(tag = "SysLogService.querySysLogListWithPage")
    public PaginatedArrayList<SysLog> querySysLogListWithPage(SysLogQuery queryBean, int pageIndex, int pageSize) {
        PaginatedArrayList<SysLog> sysLogList = null;
        try {
            sysLogList = sysLogManager.querySysLogListWithPage(queryBean, pageIndex, pageSize);
        } catch (Exception e) {
            log.error("SysLogServiceImpl -> querySysLogPages() error!!", e);
        }
        return sysLogList;
    }

    @Profiled(tag = "SysLogService.delete")
    public boolean delete(Long id) {
        boolean resultFlag = false;
        try {
            if (null != id && id.intValue() > 0) {
                resultFlag = sysLogManager.delete(id);
            } else {
                log.error("SysLogServiceImpl!delete(Long id) param: " + id + " Illegal!");
            }
        } catch (Exception e) {
            log.error("SysLogServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SysLogService.batchDelete")
    public boolean delete(String[] ids) {
        boolean resultFlag = false;
        try {
            resultFlag = sysLogManager.delete(ids);
        } catch (Exception e) {
            log.error("SysLogServiceImpl -> delete() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "SysLogService.getSysLogById")
    public SysLog getSysLogById(Long id) {
        SysLog sysLog = null;
        try {
            sysLog = sysLogManager.getSysLogById(id);
        } catch (Exception e) {
            log.error("SysLogServiceImpl!getSysLogById(Integer id) error!", e);
        }
        return sysLog;
    }
}
