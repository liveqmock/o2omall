package com.hbird.portal.dao.impl;

import com.hbird.common.dao.mybatis.BaseDao;
import com.hbird.portal.dao.ResourceDao;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.query.ResourceQuery;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ResourceDAO实现类<br/>
 * 对'资源表'表进行基本的操作
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
@Repository
public class ResourceDaoImpl extends BaseDao implements ResourceDao {
    /** namespace */
    private final String namespace = ResourceDaoImpl.class.getName();

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceList(ResourceQuery queryBean) {
        return (List<Resource>) queryForList(namespace + ".queryResourceList", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Resource resource) {
        return insert(namespace + ".insert", resource);
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(Resource resource) {
        return update(namespace + ".update", resource);
    }

    /**
     * {@inheritDoc}
     */
    public int queryResourceCount(ResourceQuery queryBean) {
        return (Integer) queryForObject(namespace + ".queryResourceCount", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceListWithPage(ResourceQuery queryBean) {
        return (List<Resource>) queryForList(namespace + ".queryResourceListWithPage", queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Resource configuration) {
        return delete(namespace + ".delete", configuration);
    }

    /**
     * {@inheritDoc}
     */
    public Resource getResourceById(Long id) {
        return (Resource) queryForObject(namespace + ".getResourceById", id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(Resource resource) {
        int count = (Integer) queryForObject(namespace + ".exist", resource);
        return count > 0;
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceTree(Long roleId) {
        return (List<Resource>) queryForList(namespace + ".queryResourceTree", roleId);
    }
}
