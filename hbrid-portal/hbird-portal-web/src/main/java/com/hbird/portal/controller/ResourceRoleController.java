package com.hbird.portal.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.ResourceRole;
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.query.ResourceRoleQuery;
import com.hbird.portal.service.ResourceRoleService;
import com.hbird.portal.service.RoleService;
import com.hbird.portal.web.util.JsonResult;

/**
 * 资源角色Controller
 * 
 * @author ljz
 * @version 2014-12-11 下午4:14:53
 */
@Controller
@RequestMapping("/resourceRole")
public class ResourceRoleController extends BaseController {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceRoleService resourceRoleService;

    @RequestMapping(value = "/queryResourceConfigedRoleList")
    @ResponseBody
    public JsonResult queryResourceConfigedRoleList(Long resourceId) {
        this.logger.debug("resourceRole --> queryResourceConfigedRoleList，resourceId = " + resourceId);
        JsonResult jsonResult = new JsonResult();
        ResourceRoleQuery query = new ResourceRoleQuery();
        query.setResId(resourceId);
        try {
            List<Role> list = roleService.queryResourceConfigedRoleList(query);
            jsonResult.setResult(list);
        } catch (Exception e) {
            this.logger.error("resourceRole --> queryResourceConfigedRoleList 查询数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/queryResourceAvailableRoleList")
    @ResponseBody
    public JsonResult queryAvailableRoleList(Long resourceId) {

        this.logger.debug("resourceRole --> queryResourceAvailableRoleList，resourceId = " + resourceId);
        ResourceRoleQuery query = new ResourceRoleQuery();
        query.setResId(resourceId);
        JsonResult jsonResult = new JsonResult();
        try {
            List<Role> list = roleService.queryResourceAvailableRoleList(query);
            jsonResult.setResult(list);
        } catch (Exception e) {
            this.logger.error("resourceRole --> queryResourceAvailableRoleList 查询数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;
    }

    /**
     * 给资源分配角色
     * 
     * @param roleId
     * @param resIds
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(ResourceRole oldResourceRole, @RequestParam("roleIds") String[] roleIds) {
        JsonResult jsonResult = new JsonResult();
        try {
            this.logger.debug("resourceRole --> save，resId = " + oldResourceRole.getResId() + ",roleIds="
                    + Arrays.toString(roleIds));
            oldResourceRole.setUpdateUser(getLoginUserCnName());

            List<ResourceRole> newResourceRoles = null;
            if (null != roleIds && roleIds.length > 0) {
                newResourceRoles = new ArrayList<ResourceRole>(roleIds.length);
                for (String roleId : roleIds) {
                    ResourceRole resourceRole = new ResourceRole();
                    resourceRole.setResId(oldResourceRole.getResId());
                    resourceRole.setRoleId(Long.valueOf(roleId));
                    resourceRole.setCreateUser(getLoginUserCnName());
                    newResourceRoles.add(resourceRole);
                }
            }
            boolean result = resourceRoleService.update(oldResourceRole, newResourceRoles);
            jsonResult.setResult(result);
        } catch (Exception e) {
            this.logger.error("resourceRole --> save 保存数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return jsonResult;
    }

    /**
     * 给角色分配资源
     * 
     * @param roleId
     * @param resIds
     * @return
     */
    @RequestMapping(value = "/saveRoleResources", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveRoleResources(ResourceRole oldResourceRole, @RequestParam("resIds") String[] resIds) {
        JsonResult jsonResult = new JsonResult();
        try {
            this.logger.info("resourceRole --> saveRoleResources，roleId = " + oldResourceRole.getRoleId() + ",resIds="
                    + Arrays.toString(resIds));
            oldResourceRole.setUpdateUser(getLoginUserCnName());

            List<ResourceRole> newResourceRoles = null;
            if (null != resIds && resIds.length > 0) {
                newResourceRoles = new ArrayList<ResourceRole>(resIds.length);
                for (String resId : resIds) {
                    ResourceRole resourceRole = new ResourceRole();
                    resourceRole.setRoleId(oldResourceRole.getRoleId());
                    resourceRole.setResId(Long.valueOf(resId));
                    resourceRole.setCreateUser(getLoginUserCnName());
                    newResourceRoles.add(resourceRole);
                }
            }
            boolean result = resourceRoleService.update(oldResourceRole, newResourceRoles);
            jsonResult.setResult(result);
        } catch (Exception e) {
            this.logger.error("resourceRole --> saveRoleResources 保存数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return jsonResult;
    }

}
