package com.hbird.portal.controller;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.*;
import com.hbird.portal.domain.query.RoleQuery;
import com.hbird.portal.service.RoleService;
import com.hbird.portal.web.util.JsonReader;
import com.hbird.portal.web.util.JsonResult;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * User: ljz Date: 14-4-14 Time: 下午2:15
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        this.logger.debug("role --> role");
        return "role/role";
    }

    @RequestMapping(value = "/queryRoles", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryRoleList(@RequestParam Map<String, Object> paramMap, RoleQuery query) {
        JsonReader result = new JsonReader();
        try {
            List<Role> list = roleService.queryRoles(query);
            result.setResult(list);
        } catch (Exception e) {
            this.logger.error("system --> queryRoles 查询数据异常:", e);
            result.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return result;
    }

    /**
     * 查询角色列表
     * 
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/queryRoleList", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryBusinessList(@RequestParam Map<String, Object> paramMap, RoleQuery query) {
        this.logger.info("RoleController --> queryRoleList 按条件查询角色信息");
        String currPageStr = (String) paramMap.get("page");
        int currPage = 1;
        if (StringUtils.isNotBlank(currPageStr)) {
            currPage = Integer.valueOf(currPageStr);
        }
        String rowsStr = (String) paramMap.get("rows");
        int rows = 0;
        if (StringUtils.isNotBlank(rowsStr)) {
            rows = Integer.valueOf(rowsStr);
        }
        JsonReader result = new JsonReader();
        result.setCurrpage(currPage);
        try {
            PaginatedArrayList<Role> roles = roleService.queryRoleListWithPage(query, currPage, rows);
            result.setTotalpages(roles.getTotalPage());
            result.setTotalrecords(roles.getTotalItem());
            result.setResult(roles.getRows());

        } catch (Exception e) {
            this.logger.error("roles --> queryRoleList 查询数据异常:", e);
            result.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return result;
    }

    /**
     * 角色新增，修改，删除
     * 
     * @param role
     * @param oper
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult save(Role role, String oper, String ids) {
        this.logger.info("RoleController -->save,oper=" + oper);
        if ("add".equals(oper)) {
            this.logger.info("Role -->save 新增角色开始，角色名称【" + role.getName() + "】");
            role.setCreateUser(getLoginUserName());
            boolean result = roleService.insert(role);
            this.logger.info("Role -->save 新增角色结束，角色名称【" + role.getName() + "】,结果 【" + result + "】");
        } else {
            if ((role != null && role.getId() != null && role.getId() > 0) || StringUtils.isNotBlank(ids)) {
                if ("edit".equals(oper)) {
                    this.logger.info("Role -->save 修改角色开始，角色名称【" + role.getName() + "】");
                    role.setUpdateUser(getLoginUserName());
                    boolean result = roleService.update(role);
                    this.logger.info("Role -->save 修改角色结束，角色名称【" + role.getName() + "】， 结果 【" + result + "】");
                } else if ("del".equals(oper)) {
                    this.logger.info("Role -->save 删除角色开始");
                    String[] roleIds = ids.split(",");
                    boolean result = roleService.delete(roleIds);
                    this.logger.info("Role -->save 删除角色结束，结果 【" + result + "】");
                }
            } else {
                this.logger.error("Role-->" + oper + ",传入参数不正确！");
                return new JsonResult(JsonResult.CODE_PARAM_ERROR, JsonResult.MESSAGE_PARAM_ERROR);
            }
        }
        return new JsonResult(JsonResult.CODE_SUCCESS, JsonResult.MESSAGE_SUCCESS);
    }
}
