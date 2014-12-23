package com.hbird.portal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.sdk.api.request.UserRequest;
import com.hbird.portal.sdk.api.response.dto.RoleDto;
import com.hbird.portal.service.RoleService;

/**
 * 角色REST服务：提供角色查询的接口
 * 
 * @author ljz
 */
@Component
@Path(CommonConstants.REST_URL)
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RoleResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RoleService roleService;

    /**
     * 依据用户ID查询用户所拥有的角色信息（角色名称）
     * 
     * @param request
     *            查询参数
     * @return
     */
    @POST
    @Path("/role/getUserRoleList")
    public Wrapper<List<RoleDto>> getUserRoleList(UserRequest request) {
        if (null == request || null == request.getId()) {
            this.logger.error("getUserRoleList 传入参数有误");
            return WrapMapper.illegalArgument();
        }

        try {
            UserRoleQuery queryBean = new UserRoleQuery();
            queryBean.setUserId(request.getId());
            List<Role> roles = roleService.queryConfigedRoleList(queryBean);
            for (Role role : roles) {
                System.out.println(role.getName());
            }
            List<RoleDto> response = convertList(roles);
            return new Wrapper<List<RoleDto>>().result(response);
        } catch (Exception e) {
            this.logger.error("getUserRoleList error,", e);
            return WrapMapper.error();
        }
    }

    // 数据转换
    private RoleDto convert(Role role) {
        if (null == role) {
            return null;
        }
        RoleDto roleResponse = new RoleDto();
        BeanUtils.copyProperties(role, roleResponse);
        return roleResponse;
    }

    // 数据转换
    private List<RoleDto> convertList(List<Role> roles) {
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>(roles.size());
        for (Role role : roles) {
            list.add(convert(role));
        }
        return list;
    }

}
