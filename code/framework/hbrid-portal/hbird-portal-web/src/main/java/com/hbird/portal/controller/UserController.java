package com.hbird.portal.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.common.utils.security.MD5Util;
import com.hbird.common.web.context.UserContext;
import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.domain.query.UserQuery;
import com.hbird.portal.service.UserService;
import com.hbird.portal.web.util.JsonReader;
import com.hbird.portal.web.util.JsonResult;

/**
 * 用户相关界面的 控制器
 * 
 * @author zhc
 * @author ljz
 * @version 2014-11-28 下午4:47:00
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        this.logger.debug("user --> index");

        // initDateTimePicker(model);
        return "user/index";
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryList(@RequestParam Map<String, Object> paramMap, UserQuery userQuery, Model model) {
        this.logger.debug("user --> queryList, paramMap" + paramMap);

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
            PaginatedArrayList<User> users = this.userService.queryUserListWithPage(userQuery, currPage, rows);
            result.setPaginatedData(users);
        } catch (Exception e) {
            this.logger.error("user --> queryList 查询数据异常:", e);
            result.setError();
        }
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(User user) {
        JsonResult jsonResult = new JsonResult();

        if (null == user || null == user.getName()) {
            this.logger.warn("add user fail, user is null");
            jsonResult.setFail();
        } else if (userService.exist(user)) {
            this.logger.warn("add user fail, user name exist, name=" + user.getName());
            jsonResult.setCode(JsonResult.CODE_FAIL);
            jsonResult.setMessage("账号" + user.getName() + "已存在");
        } else {
            user.setCreateUser(getLoginUserName());
            user.setPassword(MD5Util.md5Hex(user.getPassword()));
            boolean result = this.userService.insert(user);
            this.logger.info("add user, name=" + user.getName() + ", result=" + result);

            if (!result) {
                jsonResult.setFail();
            }
        }

        return jsonResult;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(User user) {
        JsonResult jsonResult = new JsonResult();

        if (user == null || user.getId() == null || user.getId() == 0) {
            this.logger.error("update user fail, user or user's id is null");
            jsonResult.setFail();
        } else {
            user.setUpdateUser(getLoginUserName());
            boolean result = this.userService.update(user);
            this.logger.info("update user, name=" + user.getName() + ", result=" + result);

            if (!result) {
                jsonResult.setFail();
            }
        }

        return jsonResult;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@RequestParam("userIds") String[] userIds) {
        JsonResult jsonResult = new JsonResult();

        if (null == userIds || userIds.length == 0) {
            this.logger.error("delete user fail, userIds is null or length is 0");
            jsonResult.setFail();
        } else {
            boolean result = this.userService.delete(userIds);
            this.logger.info("delete user, userIds=" + Arrays.toString(userIds) + ", result=" + result);
            if (!result) {
                jsonResult.setFail();
            }
        }

        return jsonResult;
    }

    @RequestMapping(value = "resetPassword", method = RequestMethod.GET)
    public String resetPassword(Model model) {
        this.logger.debug("user --> resetPassword");
        return "user/resetPassword";
    }

    @RequestMapping(value = "modifyPassword", method = RequestMethod.GET)
    public String modifyPassword(Model model) {
        this.logger.debug("user --> modifyPassword");
        return "user/modifyPassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult changePassword(User user) {
        JsonResult jsonResult = new JsonResult();

        if (user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getRemark())) {
            this.logger.error("update user fail, user or user's name or password is null");
            jsonResult.setFail();
        } else {
            String name = user.getName();// 用户名
            // 操作类型：modify 自己修改，reset 管理员重置其他账号的密码
            String type = user.getRemark();
            String password = user.getPassword();// 新密码
            String passwordOld = user.getCnName();// 原始密码
            User queryUser = userService.getUserByName(name);
            if (null == queryUser) {
                jsonResult.setCode(JsonResult.CODE_FAIL);
                jsonResult.setMessage("账号" + name + "不存在");
            } else if (CommonConstants.USER_TYPE_INNER == queryUser.getUserType()) {
                jsonResult.setCode(JsonResult.CODE_FAIL);
                jsonResult.setMessage(name + "为内部员工账号，不支持修改");
            } else if ("modify".equals(type)) {
                // 修改自己密码，验证账号密码的正确性
                if (!(null != queryUser.getPassword() && queryUser.getPassword().equals(MD5Util.md5Hex(passwordOld)))) {
                    jsonResult.setCode(JsonResult.CODE_FAIL);
                    jsonResult.setMessage("原始密码错误");
                } else {
                    doChangePassword(queryUser, password, jsonResult);
                }
            } else if ("reset".equals(type)) {
                // 管理员重置其他账号的密码
                doChangePassword(queryUser, password, jsonResult);
            } else {
                // 不支持的操作
                jsonResult.setCode(JsonResult.CODE_FAIL);
                jsonResult.setMessage("不支持的操作");
            }
        }

        return jsonResult;
    }

    /**
     * @param queryUser
     * @param jsonResult
     * @param password
     */
    private void doChangePassword(User user, String password, JsonResult jsonResult) {
        user.setPassword(MD5Util.md5Hex(password));
        user.setUpdateUser(getLoginUserName());
        boolean result = this.userService.update(user);
        this.logger.info("chang user password, name=" + user.getName() + ", result=" + result);

        if (!result) {
            jsonResult.setFail();
        }
    }

    @RequestMapping(value = "/getUserStatus", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getUserStatus() {
        return new JsonResult(CommonConstants.getUserStatus());
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        this.logger.debug("user --> profile");
        model.addAttribute("user", UserContext.get().getUser());
        return "user/profile";
    }

    /**
     * 跳转到补用户数据界面
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "toSupplement", method = RequestMethod.GET)
    public String toSupplement(Model model) {
        return "user/supplement";
    }

    /**
     * 补用户数据
     * 
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "supplement", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult supplement(User user, Model model) {
        JsonResult jsonResult = new JsonResult();
        if (null == user || StringUtils.isBlank(user.getName())) {
            jsonResult.setFail();
        }

        String name = user.getName();
        this.logger.info("补全用户，操作人：" + getLoginUserName());

        try {
            // do nothing
            jsonResult.setFail();
            this.logger.info("补全用户[" + name + "]信息失败");
        } catch (Exception e) {
            jsonResult.setError();
            this.logger.warn("补全用户[" + name + "]信息异常，", e);
        }

        return jsonResult;
    }
}
