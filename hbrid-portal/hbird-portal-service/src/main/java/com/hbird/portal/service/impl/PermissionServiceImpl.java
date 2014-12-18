package com.hbird.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.perf4j.aop.Profiled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.query.ResourceQuery;
import com.hbird.portal.manager.MenuManager;
import com.hbird.portal.manager.ResourceManager;
import com.hbird.portal.service.PermissionService;

/**
 * 权限服务
 * <p/>
 * User: ljz Date: 2014-6-12 Time: 下午02:44:20 Version: 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private final static Logger log = LogManager.getLogger(PermissionServiceImpl.class);
    @Autowired
    private ResourceManager resourceManager;
    @Autowired
    private MenuManager menuManager;

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "PermissionService.getPermissionByParentCode")
    public List<String> getPermissionByParentCode(Long userId, Resource resource) {
        if (null == userId || null == resource
                || (StringUtils.isBlank(resource.getCode()) && StringUtils.isBlank(resource.getUrl()))) {
            log.warn("权限查询失败，传入参数非法，userId=" + userId);
            return null;
        }

        log.info("权限查询参数，userId=" + userId);
        log.info("权限查询参数，code=" + resource.getCode());
        log.info("权限查询参数，url=" + resource.getUrl());

        Resource parentResource = this.getResource(resource.getCode(), resource.getUrl());
        if (null == parentResource) {
            log.info("权限系统不存在该资源");
            return null;
        }

        List<String> codeList = null;
        try {
            List<Resource> resources = queryResourceListByUserId(userId);

            if (!CollectionUtils.isEmpty(resources)) {
                long perantResourceId = parentResource.getId().longValue();
                codeList = new ArrayList<String>();
                for (Resource r : resources) {
                    if (null != r.getParentId() && r.getParentId().longValue() == perantResourceId) {
                        codeList.add(r.getCode());
                    }
                }
            }
        } catch (Exception e) {
            log.error("权限查询异常,", e);
        }

        return codeList;
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "PermissionService.isPermitted")
    public boolean isPermitted(Long userId, Resource resource) {
        if (null == userId || null == resource
                || (StringUtils.isBlank(resource.getCode()) && StringUtils.isBlank(resource.getUrl()))) {
            log.warn("权限验证失败，传入参数非法，userId=" + userId);
            return false;
        }

        log.info("权限验证参数，userId=" + userId);
        log.info("权限验证参数，code=" + resource.getCode());
        log.info("权限验证参数，url=" + resource.getUrl());

        boolean result = false;

        Resource realResource = this.getResource(resource.getCode(), resource.getUrl());
        if (null == realResource) {
            log.info("权限系统不存在该资源，跳过");
            result = true;
        } else {
            try {
                List<Resource> resources = queryResourceListByUserId(userId);
                if (!CollectionUtils.isEmpty(resources)) {
                    for (Resource r : resources) {
                        if (null != realResource.getCode() && realResource.getCode().equals(r.getCode())) {
                            result = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                log.error("权限验证异常,", e);
            }
        }

        log.info("权限验证结果：" + result);

        return result;
    }

    /**
     * 根据用户ID集合查询拥有资源列表
     * 
     * @param user
     * @return
     */
    private List<Resource> queryResourceListByUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        List<Resource> resources = menuManager.queryResourceListByUserId(user);
        return resources;
    }

    /**
     * 根据资源编码或资源URL查询资源
     * 
     * @param code
     * @param url
     * 
     * @param userId
     *            用户ID
     * @param resource
     *            资源
     * @return
     */
    private Resource getResource(String code, String url) {
        ResourceQuery queryBean = new ResourceQuery();
        queryBean.setCode(code);
        queryBean.setUrl(url);

        try {
            List<Resource> parentResources = resourceManager.queryResourceList(queryBean);
            if (CollectionUtils.isEmpty(parentResources)) {
                return null;
            }
            return parentResources.get(0);
        } catch (Exception e) {
            log.warn("根据资源编码查询资源异常", e);
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Profiled(tag = "PermissionService.queryButtonResources")
    public List<Resource> queryButtonResources(Long userId, Resource resource) {
        if (null == userId || null == resource
                || (StringUtils.isBlank(resource.getUrl()) && StringUtils.isBlank(resource.getCode()))) {
            log.warn("按钮资源查询失败，传入参数非法，userId=" + userId);
            return null;
        }

        log.info("按钮资源查询参数，userId=" + userId);
        log.info("按钮资源查询参数，code=" + resource.getCode());
        log.info("按钮资源查询参数，url=" + resource.getUrl());
        List<Resource> resources = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("code", resource.getCode());
        map.put("url", resource.getUrl());
        try {
            resources = menuManager.queryButtonResources(map);
        } catch (Exception e) {
            log.error("按钮资源查询异常,", e);
        }
        return resources;
    }
}
