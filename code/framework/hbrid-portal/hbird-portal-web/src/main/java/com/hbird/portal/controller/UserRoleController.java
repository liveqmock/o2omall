package com.hbird.portal.controller;

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
import com.hbird.portal.domain.Role;
import com.hbird.portal.domain.UserRole;
import com.hbird.portal.domain.query.UserRoleQuery;
import com.hbird.portal.service.RoleService;
import com.hbird.portal.service.UserRoleService;
import com.hbird.portal.web.util.JsonResult;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-20 下午10:14:29
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/queryConfigedRoleList")
    @ResponseBody
    public JsonResult queryConfigedRoleList(Long userId) {
        this.logger.debug("userRole --> queryConfigedRoleList，userId = " + userId);

        UserRoleQuery queryBean = new UserRoleQuery();
        queryBean.setUserId(userId);

        JsonResult jsonResult = new JsonResult();
        try {
            List<Role> list = roleService.queryConfigedRoleList(queryBean);
            jsonResult.setResult(list);
        } catch (Exception e) {
            this.logger.error("userRole --> queryConfigedRoleList 查询数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;
    }

    @RequestMapping(value = "/queryAvailableRoleList")
    @ResponseBody
    public JsonResult queryAvailableRoleList(Long userId) {

        this.logger.debug("userRole --> queryAvailableRoleList，userId = " + userId);
        UserRoleQuery queryBean = new UserRoleQuery();
        queryBean.setUserId(userId);
        JsonResult jsonResult = new JsonResult();
        try {
            List<Role> list = roleService.queryAvailableRoleList(queryBean);
            jsonResult.setResult(list);
        } catch (Exception e) {
            this.logger.error("userRole --> queryAvailableRoleList 查询数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;
    }

    /**
     * 查询用户分配的角色
     * 
     * @param userIds
     * @return
     */
    @RequestMapping(value = "/queryUserRoleList")
    @ResponseBody
    public JsonResult queryUserRoleList(@RequestParam("userIds") String[] userIds) {

        this.logger.debug("userRole --> queryAvailableRoleList，userIds = " + userIds);
        UserRoleQuery queryBean = new UserRoleQuery();
        queryBean.setUserIds(userIds);
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserRole> list = userRoleService.queryUserRoleList(queryBean);
            if (list != null && list.size() > 0) {
                jsonResult.setCode(JsonResult.CODE_FAIL);
            }
        } catch (Exception e) {
            this.logger.error("userRole --> queryAvailableRoleList 查询数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(Long userId, @RequestParam("roleIds") String[] roleIds) {
        this.logger.debug("userRole --> save，userId = " + userId + ",roleIds=" + Arrays.toString(roleIds));
        String createUser = getLoginUserName();
        JsonResult jsonResult = new JsonResult();
        try {
            boolean result = userRoleService.batchSave(userId, roleIds, createUser);
            jsonResult.setResult(result);
        } catch (Exception e) {
            this.logger.error("userRole --> save 保存数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;
    }

    /**
     * 批量分配用户角色
     * 
     * @param roleIds
     * @param userIds
     * @return
     */
    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult saveUserRole(@RequestParam("roleIds") String[] roleIds, @RequestParam("userIds") String[] userIds) {
        JsonResult jsonResult = new JsonResult();
        this.logger.debug("userRole --> save，userId = " + userIds + ",roleIds=" + Arrays.toString(roleIds));
        String createUser = getLoginUserName();
        try {
            boolean result = userRoleService.batchSaves(userIds, roleIds, createUser);
            jsonResult.setResult(result);
        } catch (Exception e) {
            this.logger.error("userRole --> save 保存数据异常:", e);
            jsonResult.setCode(JsonResult.CODE_SERVER_ERROR);
        }

        return jsonResult;

    }
}
