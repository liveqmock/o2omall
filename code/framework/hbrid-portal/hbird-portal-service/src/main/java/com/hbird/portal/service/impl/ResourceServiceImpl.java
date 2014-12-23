package com.hbird.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbird.common.utils.page.PageUtil;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.query.ResourceQuery;
import com.hbird.portal.manager.ResourceManager;
import com.hbird.portal.service.ResourceService;
import com.hbird.portal.utils.exceptions.ExistedException;

/**
 * ResourceService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:26
 * 
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    /** LOG */
    private static final Log LOG = LogFactory.getLog(ResourceServiceImpl.class);

    @Autowired
    private ResourceManager resourceManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.batchInsert")
    public boolean insert(List<Resource> resourceList) {
        boolean resultFlag = false;
        try {
            if (CollectionUtils.isNotEmpty(resourceList)) {
                resultFlag = resourceManager.insert(resourceList);
            } else {
                LOG.warn("ResourceServiceImpl#batchInsert failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#batchInsert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.insert")
    public boolean insert(Resource resource) {
        boolean resultFlag = false;
        try {
            if (null != resource) {
                if (resourceManager.exist(resource)) {
                    throw new ExistedException();
                }
                resultFlag = resourceManager.insert(resource);
            } else {
                LOG.warn("ResourceServiceImpl#insert failed, param is illegal.");
            }
        } catch (ExistedException e) {
            LOG.warn("ResourceServiceImpl#insert failed, resource has existed.");
            throw e;
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#insert has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.update")
    public boolean update(Resource resource) {
        boolean resultFlag = false;
        try {
            if (null != resource && null != resource.getId()) {
                resultFlag = resourceManager.update(resource);
            } else {
                LOG.warn("ResourceServiceImpl#update failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#update has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.queryResourceList")
    public List<Resource> queryResourceList(ResourceQuery queryBean) {
        List<Resource> resourceList = null;
        try {
            resourceList = resourceManager.queryResourceList(queryBean);
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#queryResourceList has error.", e);
        }
        return resourceList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.queryResourceListWithPage")
    public List<Resource> queryResourceListWithPage(ResourceQuery queryBean, PageUtil pageUtil) {
        List<Resource> resourceList = null;
        try {
            resourceList = resourceManager.queryResourceListWithPage(queryBean, pageUtil);
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#queryResourceListWithPage has error.", e);
        }
        return resourceList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.delete")
    public boolean delete(Resource resource) {
        boolean resultFlag = false;
        try {
            if (null != resource && null != resource.getId()) {
                resultFlag = resourceManager.delete(resource);
            } else {
                LOG.warn("ResourceServiceImpl#delete param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#delete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.batchDelete")
    public boolean delete(Resource[] resources) {
        boolean resultFlag = false;
        try {
            if (null != resources && resources.length > 0) {
                resultFlag = resourceManager.delete(resources);
            } else {
                LOG.warn("ResourceServiceImpl#batchDelete failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#batchDelete has error.", e);
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.getResourceById")
    public Resource getResourceById(Long id) {
        Resource resource = null;
        try {
            if (null != id) {
                resource = resourceManager.getResourceById(id);
            } else {
                LOG.warn("ResourceServiceImpl#getResourceById failed, param is illegal.");
            }
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#getResourceById has error.", e);
        }
        return resource;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "ResourceService.queryResourceTree")
    public List<Resource> queryResourceTree(Long roleId) {
        List<Resource> resourceList = null;
        try {
            resourceList = resourceManager.queryResourceTree(roleId);
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#queryResourceTree has error.", e);
        }
        return resourceList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.hbird.portal.service.ResourceService#queryResourceList(java.util.Map)
     */
    public List<Resource> queryResourceList(Map<String, Object> paramMap) {
        List<Resource> resourceList = null;
        try {
            // resourceList = resourceManager.queryResourceList(paramMap);
        } catch (Exception e) {
            LOG.error("ResourceServiceImpl#queryResourceList has error.", e);
        }
        return resourceList;
    }
}
