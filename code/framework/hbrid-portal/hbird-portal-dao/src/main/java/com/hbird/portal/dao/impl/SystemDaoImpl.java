package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.SystemDao;
import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * SystemDAO实现类<br/>
 * 对'业务系统'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
@Repository
public class SystemDaoImpl extends BaseDao implements SystemDao {
    /** namespace */
    private final String namespace = SystemDaoImpl.class.getName();

    /**
     * {@inheritDoc}
     */
    public List<System> querySystemList(SystemQuery queryBean) {
        return (List<System>) queryForList(namespace + ".querySystemList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(System system) {
        return insert(namespace + ".insert", system);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(System system) {
        return update(namespace + ".update", system);
    }

    /**
     * {@inheritDoc}
     */
    public int querySystemCount(SystemQuery queryBean) {
        return (Integer) queryForObject(namespace + ".querySystemCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<System> querySystemListWithPage(SystemQuery queryBean) {
        return (List<System>) queryForList(namespace + ".querySystemListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(System configuration) {
        return delete(namespace + ".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public System getSystemById(Long id) {
        return (System) queryForObject(namespace + ".getSystemById", id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(System system) {
        int count = (Integer) queryForObject(namespace + ".exist", system);
        return count > 0;
    }
}
