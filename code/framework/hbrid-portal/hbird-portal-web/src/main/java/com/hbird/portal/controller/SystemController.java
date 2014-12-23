package com.hbird.portal.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.System;
import com.hbird.portal.domain.query.SystemQuery;
import com.hbird.portal.service.SystemService;
import com.hbird.portal.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * SystemController ：业务系统控制器
 * 
 * @author ljz
 * @version 2014-12-3 18:22:26
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

    @Autowired
    private SystemService systemService;

    /** 视图前缀 */
    private static final String viewPrefix = "system";

    private static final Log LOG = LogFactory.getLog(SystemController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, SystemQuery query) {
        try {
            List<System> dataList = systemService.querySystemListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("system index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 业务系统----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 业务系统----添加
     * 
     * @param system
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(System system) {
        try {
            system.setCreateUser(getLoginUserCnName());
            if (systemService.insert(system)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("system add fail, exist system.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("system add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 业务系统----更新跳转
     * 
     * @param model
     * @param system
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, System system) {
        try {
            System systemResult = systemService.getSystemById(system.getId());
            model.addAttribute("system", systemResult);
        } catch (Exception e) {
            LOG.error("system updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 业务系统----更新
     * 
     * @param model
     * @param system
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, System system) {
        try {
            system.setUpdateUser(getLoginUserCnName());
            if (systemService.update(system)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("system update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 业务系统----删除
     * 
     * @param system
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(System system) {
        try {
            system.setUpdateUser(getLoginUserCnName());
            if (systemService.delete(system)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("system delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 业务系统----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(SystemQuery query) {
        try {
            List<System> list = systemService.querySystemList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("system query has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 查询业务系统详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(SystemQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            System system = systemService.getSystemById(query.getId());
            if (system != null) {
                return new Wrapper<System>().result(system);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询业务系统详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail system has error.", e);
            return error();
        }
    }
}
