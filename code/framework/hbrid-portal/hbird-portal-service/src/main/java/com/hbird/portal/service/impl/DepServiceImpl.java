package com.hbird.portal.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;
import com.hbird.portal.manager.DepManager;
import com.hbird.portal.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.perf4j.aop.Profiled;

/**
 * User: ljz Date: 2014-04-15 Time: 10:22:03
 */
@Service
public class DepServiceImpl implements DepService {
    private final static Logger log = LogManager.getLogger(DepServiceImpl.class);
    @Autowired
    private DepManager depManager;

    @Profiled(tag = "DepService.batchInsert")
    public boolean insert(List<Dep> beanList) {
        boolean resultFlag = false;
        try {
            resultFlag = depManager.insert(beanList);
        } catch (Exception e) {
            log.error("DepServiceImpl -> insert() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "DepService.insert")
    public boolean insert(Dep bean) {
        boolean resultFlag = false;
        try {
            if (null != bean) {
                resultFlag = depManager.insert(bean);
            } else {
                log.error("param is null!");
            }
        } catch (Exception e) {
            log.error("DepServiceImpl!insert(Dep bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "DepService.update")
    public boolean update(Dep bean) {
        boolean resultFlag = false;
        try {
            resultFlag = depManager.update(bean);
        } catch (Exception e) {
            log.error("DepServiceImpl!update(Dep bean) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "DepService.queryDepList")
    public List<Dep> queryDepList(DepQuery queryBean) {
        List<Dep> depList = null;
        try {
            depList = depManager.queryDepList(queryBean);
        } catch (Exception e) {
            log.error("DepServiceImpl -> queryDepList() error!!", e);
        }
        return depList;
    }

    @Profiled(tag = "DepService.queryDepListWithPage")
    public PaginatedArrayList<Dep> queryDepListWithPage(DepQuery queryBean, int pageIndex, int pageSize) {
        PaginatedArrayList<Dep> depList = null;
        try {
            depList = depManager.queryDepListWithPage(queryBean, pageIndex, pageSize);
        } catch (Exception e) {
            log.error("DepServiceImpl -> queryDepPages() error!!", e);
        }
        return depList;
    }

    @Profiled(tag = "DepService.delete")
    public boolean delete(Long id) {
        boolean resultFlag = false;
        try {
            if (null != id && id.intValue() > 0) {
                resultFlag = depManager.delete(id);
            } else {
                log.error("DepServiceImpl!delete(Long id) param: " + id + " Illegal!");
            }
        } catch (Exception e) {
            log.error("DepServiceImpl!delete(Integer id) error!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "DepService.batchDelete")
    public boolean delete(String[] ids) {
        boolean resultFlag = false;
        try {
            resultFlag = depManager.delete(ids);
        } catch (Exception e) {
            log.error("DepServiceImpl -> delete() error!!", e);
        }
        return resultFlag;
    }

    @Profiled(tag = "DepService.getDepById")
    public Dep getDepById(Long id) {
        Dep dep = null;
        try {
            dep = depManager.getDepById(id);
        } catch (Exception e) {
            log.error("DepServiceImpl!getDepById(Integer id) error!", e);
        }
        return dep;
    }
}
