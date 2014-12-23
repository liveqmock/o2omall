package com.hbird.portal.manager.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.dao.SysLogDao;
import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.query.SysLogQuery;
import com.hbird.portal.manager.SysLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Component
public class SysLogManagerImpl extends BaseManager implements SysLogManager {
    private final static Logger log = LogManager.getLogger(SysLogManagerImpl.class);
    @Autowired
    private SysLogDao sysLogDao;

    public boolean insert(final List<SysLog> beanList) {
        boolean resultFlag = true;
        if (null != beanList && beanList.size() > 0) {
            for (SysLog bean : beanList) {
                resultFlag = sysLogDao.insert(bean);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    public boolean insert(SysLog bean) {
        return sysLogDao.insert(bean);
    }

    public boolean update(final SysLog bean) {
        boolean resultFlag = true;
        if (null != bean) {
            resultFlag = sysLogDao.update(bean);
            if (!resultFlag) {
                throw new RuntimeException("单个表信息更新异常,ID:[" + bean.getId() + "]!");
            }
        } else {
            log.debug("SysLogManagerImpl!update(SysLog bean) Error,参数为空!");
            throw new RuntimeException("单个表信息更新时，表信息对象为NULL!");
        }

        return resultFlag;
    }

    public List<SysLog> querySysLogList(SysLogQuery queryBean) {
        return sysLogDao.querySysLogList(queryBean);
    }

    public PaginatedArrayList<SysLog> querySysLogListWithPage(SysLogQuery queryBean, int pageIndex, int pageSize) {
        if (null == queryBean) {
            queryBean = new SysLogQuery();
        }
        queryBean.setPageIndex(pageIndex);
        queryBean.setPageSize(pageSize);
        // 查询总数
        int totalItem = querySysLogCount(queryBean);
        // 创建翻页集合,根据第几页和每页大小
        PaginatedArrayList<SysLog> sysLogs = new PaginatedArrayList<SysLog>(pageIndex, pageSize);
        // 设置总数,同时将会计算出开始行和结束行
        sysLogs.setTotalItem(totalItem);

        // 设置开始行
        // queryBean.setStartRow(sysLogs.getStartRow());
        // 设置最后行
        queryBean.setEndRow(sysLogs.getPageSize());
        // 调用Dao翻页方法
        List<SysLog> sysLogList = sysLogDao.querySysLogListWithPage(queryBean);
        sysLogs.addAll(sysLogList);

        return sysLogs;
    }

    public int querySysLogCount(SysLogQuery queryBean) {
        return sysLogDao.querySysLogCount(queryBean);
    }

    public boolean delete(Long id) {
        return sysLogDao.deleteSysLogById(id);
    }

    public SysLog getSysLogById(Long id) {
        return sysLogDao.getSysLogById(id);
    }

    public boolean delete(final String[] ids) {
        boolean resultFlag = true;
        if (null != ids && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                resultFlag = delete(Long.parseLong(ids[i]));
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        } else {
            log.error("ids param is null!");
        }

        return resultFlag;
    }
}
