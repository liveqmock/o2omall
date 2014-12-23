package com.hbird.portal.manager.impl;

import java.util.List;

import com.hbird.common.core.util.codegenerate.BusinessCodeGenerator;
import com.hbird.common.manager.BaseManager;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.query.ResourceQuery;
import com.hbird.portal.dao.ResourceDao;
import com.hbird.portal.manager.ResourceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ResourceManager接口的实现类
 * 
 * @author ljz
 * @version 2014-12-3 18:22:25
 * 
 */
@Component
public class ResourceManagerImpl extends BaseManager implements ResourceManager {

    @Autowired
    private ResourceDao resourceDao;

    /**
     * {@inheritDoc}
     */
    public boolean insert(final List<Resource> resourceList) {
        boolean resultFlag = false;
        if (null != resourceList && resourceList.size() > 0) {
            for (Resource resource : resourceList) {
                resultFlag = insert(resource);
                if (!resultFlag) {
                    throw new RuntimeException("批量新增表信息异常");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean insert(Resource resource) {
        boolean resultFlag = resourceDao.insert(resource);
        if (resultFlag) {
            String resCode = BusinessCodeGenerator.getResourceCode(resource.getId());
            resource.setCode(resCode);
            resultFlag = resourceDao.update(resource);
        } else {
            throw new RuntimeException("生成资源编码异常！ID【" + resource.getId() + "】");
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean update(final Resource resource) {
        return resourceDao.update(resource);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceList(ResourceQuery queryBean) {
        return resourceDao.queryResourceList(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceListWithPage(ResourceQuery queryBean, PageUtil pageUtil) {
        if (null == queryBean) {
            queryBean = new ResourceQuery();
        }

        // 查询总数
        int totalItem = queryResourceCount(queryBean);

        if (pageUtil == null) {
            pageUtil = new PageUtil();
        }
        pageUtil.setTotalRow(totalItem);
        pageUtil.init();

        if (totalItem > 0) {
            queryBean.setPageIndex(pageUtil.getCurPage());
            queryBean.setPageSize(pageUtil.getPageSize());
            // 调用Dao翻页方法
            return resourceDao.queryResourceListWithPage(queryBean);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public int queryResourceCount(ResourceQuery queryBean) {
        return resourceDao.queryResourceCount(queryBean);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(Resource resource) {
        boolean resultFlag = resourceDao.delete(resource);
        if (resultFlag) { // 删除子资源
            Resource childResource = new Resource();
            childResource.setParentId(resource.getId());
            childResource.setUpdateUser(resource.getUpdateUser());
            resourceDao.delete(childResource);
        } else {
            throw new RuntimeException("生成资源编码异常！ID【" + resource.getId() + "】");
        }
        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public Resource getResourceById(Long id) {
        return resourceDao.getResourceById(id);
    }

    /**
     * {@inheritDoc}
     */
    public boolean delete(final Resource[] resources) {
        boolean resultFlag = false;
        if (null != resources && resources.length > 0) {
            for (int i = 0; i < resources.length; i++) {
                resultFlag = delete(resources[i]);
                if (!resultFlag) {
                    throw new RuntimeException("批量删除表信息异常!");
                }
            }
        }

        return resultFlag;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exist(Resource resource) {
        return resourceDao.exist(resource);
    }

    /**
     * {@inheritDoc}
     */
    public List<Resource> queryResourceTree(Long roleId) {
        return resourceDao.queryResourceTree(roleId);
    }
}
