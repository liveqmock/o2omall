package com.hbird.portal.service;

import java.util.List;

import com.hbird.portal.domain.Resource;

/**
 * 权限服务
 * <p/>
 * User: ljz Date: 2014-6-12 Time: 下午02:43:06 Version: 1.0
 */
public interface PermissionService {

    /**
     * 根据用户ID和父资源码获取其有权限子资源列表
     * 
     * @param userId
     *            用户ID
     * @param resource
     *            资源
     * @return
     */
    public List<String> getPermissionByParentCode(Long userId, Resource resource);

    /**
     * 用户是否拥有某个资源权限
     * 
     * @param userId
     *            用户ID
     * @param resource
     *            资源
     * @return
     */
    public boolean isPermitted(Long userId, Resource resource);

    /**
     * 根据用户ID和父资源查询按钮资源列表
     * 
     * @param userId
     *            用户ID
     * @param resource
     *            资源
     * @return
     */
    public List<Resource> queryButtonResources(Long userId, Resource resource);
}
