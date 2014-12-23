package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.SysLogDao;
import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.query.SysLogQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * User: ljz Date: 2014-04-08 Time: 18:43:58
 */
@Repository
public class SysLogDaoImpl extends BaseDao implements SysLogDao {

    public List<SysLog> querySysLogList(SysLogQuery queryBean) {
        return (List<SysLog>) queryForList("SysLog.querySysLogList", queryBean);
    }

    public boolean insert(SysLog bean) {
        return insert("SysLog.insert", bean);
    }

    public boolean update(SysLog bean) {
        return update("SysLog.update", bean);
    }

    public int querySysLogCount(SysLogQuery queryBean) {
        return (Integer) queryForObject("SysLog.querySysLogCount", queryBean);
    }

    public List<SysLog> querySysLogListWithPage(SysLogQuery queryBean) {
        return (List<SysLog>) queryForList("SysLog.querySysLogListWithPage", queryBean);
    }

    public boolean deleteSysLogById(Long id) {
        return delete("SysLog.deleteSysLogById", id);
    }

    public SysLog getSysLogById(Long id) {
        return (SysLog) queryForObject("SysLog.getSysLogById", id);
    }
}
