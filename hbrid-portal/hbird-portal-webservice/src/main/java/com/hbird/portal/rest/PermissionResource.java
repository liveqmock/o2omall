package com.hbird.portal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.sdk.api.request.PermissionCheckRequest;
import com.hbird.portal.sdk.api.request.PermissionQueryRequest;
import com.hbird.portal.sdk.api.response.dto.ButtonResourceDto;
import com.hbird.portal.service.PermissionService;

/**
 * 权限服务,权限查询和验证
 * 
 * @author ljz
 * @version 2014-11-26 下午3:19:40
 */
@Component
@Path(CommonConstants.REST_URL)
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PermissionResource {
    private final static Logger log = LogManager.getLogger(PermissionResource.class);

    @Autowired
    private PermissionService permissionService;

    /**
     * 根据用户ID和父资源码获取其有权限子资源列表
     * 
     * @param request
     *            查询参数 userId:用户ID parentResourceCode：父资源码
     * @return
     */
    @POST
    @Path("/permission/query")
    public Wrapper<?> query(PermissionQueryRequest request) {
        if (null == request || null == request.getUserId() || StringUtils.isBlank(request.getParentResourceCode())) {
            return WrapMapper.illegalArgument();
        }

        Resource resource = new Resource();
        resource.setCode(request.getParentResourceCode());

        try {
            List<String> permissions = permissionService.getPermissionByParentCode(request.getUserId(), resource);
            return WrapMapper.ok().result(permissions);
        } catch (Exception e) {
            log.error("根据用户ID和父资源码获取其有权限子资源列表异常,", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户是否拥有某个资源权限
     * 
     * @param request
     *            查询参数 userId:用户ID resourceCode：资源码
     * @return
     */
    @POST
    @Path("/permission/isPermitted")
    public Wrapper<?> isPermitted(PermissionCheckRequest request) {
        if (null == request || null == request.getUserId()
                || (StringUtils.isBlank(request.getResourceUrl()) && StringUtils.isBlank(request.getResourceCode()))) {
            return WrapMapper.illegalArgument();
        }

        Resource resource = new Resource();
        resource.setCode(request.getResourceCode());
        resource.setUrl(request.getResourceUrl());

        try {
            boolean isPermitted = permissionService.isPermitted(request.getUserId(), resource);
            if (isPermitted) {
                return WrapMapper.ok();
            }
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "没有访问权限");
        } catch (Exception e) {
            log.error("用户是否拥有某个资源权限 异常,", e);
            return WrapMapper.error();
        }
    }

    /**
     * 根据用户ID和父资源查询按钮资源列表
     * 
     * @param request
     *            查询参数 userId:用户ID parentResourceCode：父资源码
     * @return
     */
    @POST
    @Path("/permission/buttonResource")
    public Wrapper<?> buttonResource(PermissionCheckRequest request) {
        if (null == request || null == request.getUserId()
                || (StringUtils.isBlank(request.getResourceUrl()) && StringUtils.isBlank(request.getResourceCode()))) {
            return WrapMapper.illegalArgument();
        }

        Resource resource = new Resource();
        resource.setCode(request.getResourceCode());
        resource.setUrl(request.getResourceUrl());

        try {
            List<Resource> buttonResources = permissionService.queryButtonResources(request.getUserId(), resource);
            List<ButtonResourceDto> buttonResourceDtos = toButtonResources(buttonResources);
            return WrapMapper.ok().result(buttonResourceDtos);
        } catch (Exception e) {
            log.error("根据用户ID和父资源查询按钮资源列表异常,", e);
            return WrapMapper.error();
        }
    }

    /**
     * 数据转换
     * 
     * @param buttonResources
     * @return
     */
    private List<ButtonResourceDto> toButtonResources(List<Resource> buttonResources) {
        if (CollectionUtils.isEmpty(buttonResources)) {
            return null;
        }

        List<ButtonResourceDto> list = new ArrayList<ButtonResourceDto>(buttonResources.size());
        for (Resource resource : buttonResources) {
            ButtonResourceDto dto = new ButtonResourceDto();
            dto.setButtonId(resource.getUrl());
            dto.setButtonName(resource.getName());
            dto.setCode(resource.getCode());
            dto.setIsPermitted(resource.getParentId() != null);// 非空则有权限访问
            list.add(dto);
        }
        return list;
    }
}
