package com.hbird.portal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.hbird.common.web.annotation.Permission;
import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.SysLog;
import com.hbird.portal.domain.User;
import com.hbird.portal.domain.dto.MenuParamDto;
import com.hbird.portal.domain.query.SysLogQuery;
import com.hbird.portal.service.SysLogService;
import com.hbird.portal.web.util.JsonReader;
import com.hbird.portal.web.util.JsonResult;

@Controller
@RequestMapping("sysLog")
public class SysLogController extends BaseController {

    private static final String SYSTEM = "system";

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private SysLogService sysLogService;

    @Permission("103")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        this.logger.debug("sysLog --> index");
        // initDateTimePicker(model);
        return "sysLog/index";
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryList(@RequestParam Map<String, Object> paramMap, SysLogQuery queryBean, Model model) {
        this.logger.debug("sysLog --> queryList");

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
            PaginatedArrayList<SysLog> list = this.sysLogService.querySysLogListWithPage(queryBean, currPage, rows);
            result.setTotalpages(list.getTotalPage());
            result.setTotalrecords(list.getTotalItem());
            result.setResult(list.getRows());

        } catch (Exception e) {
            this.logger.error("SysLog --> queryList 查询数据异常:", e);
            result.setError();
        }
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(MenuParamDto menu, Model model, HttpServletRequest request) {
        String remoteIp = getRemortIP(request);

        SysLog sysLog = new SysLog();
        User loginUser = getLoginUser();
        String userId = (loginUser != null) ? loginUser.getName() : null;
        sysLog.setUserId(userId);
        sysLog.setIp(remoteIp);
        sysLog.setCreateUser(SYSTEM);
        sysLog.setRName(menu.getMenuName());
        sysLog.setUrl(menu.getUrl());
        sysLog.setRemark("页面点击纪录");
        String content = "访问位置：" + menu.getParentMenuName() + "(" + menu.getParentMenuCode() + ") --> "
                + menu.getMenuName() + "(" + menu.getMenuCode() + ")";
        sysLog.setContent(content);

        boolean result = sysLogService.insert(sysLog);
        logger.debug("add sysLog:" + result);
        if (result) {
            return new JsonResult(result);
        } else {
            return new JsonResult(JsonResult.CODE_SERVER_ERROR, JsonResult.MESSAGE_SERVER_ERROR, result);
        }
    }

    private String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
