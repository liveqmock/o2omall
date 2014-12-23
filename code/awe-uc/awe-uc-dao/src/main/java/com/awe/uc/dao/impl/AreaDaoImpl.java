package com.awe.uc.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.awe.uc.dao.AreaDao;
import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * AreaDAO实现类<br/>
 * 对'三级地址'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
 * 
 */
@Repository
public class AreaDaoImpl extends BaseDao implements AreaDao {
    /** namespace */
    private final String namespace = AreaDaoImpl.class.getName();
    
    /**
     * {@inheritDoc}
     */
    public List<Area> queryAreaList(AreaQuery queryBean) {
        return (List<Area>) queryForList(namespace +".queryAreaList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Area area) {
        return insert(namespace +".insert", area);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Area area) {
        return update(namespace +".update", area);
    }

    /**
     * {@inheritDoc}
     */
    public int queryAreaCount(AreaQuery queryBean) {
        return (Integer) queryForObject(namespace +".queryAreaCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Area> queryAreaListWithPage(AreaQuery queryBean) {
        return (List<Area>) queryForList(namespace +".queryAreaListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Area configuration) {
        return delete(namespace +".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Area getAreaById(Long id) {
        return (Area) queryForObject(namespace +".getAreaById", id);
    } 
    
    /**
     * {@inheritDoc}
     */
    public boolean exist(Area area) {
        int count = (Integer) queryForObject(namespace +".exist", area);
        return count > 0;
    }
}
