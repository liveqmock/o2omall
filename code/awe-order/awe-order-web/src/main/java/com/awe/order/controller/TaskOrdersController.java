package com.awe.order.controller;
   

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

import com.awe.order.controller.base.BaseController;
import com.awe.order.domain.TaskOrders;
import com.awe.order.domain.query.TaskOrdersQuery;
import com.awe.order.service.TaskOrdersService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * TaskOrdersController ：作业表控制器
 * 
 * @author ljz
 * @version 2015-1-29 16:02:03
*/
@Controller
@RequestMapping("taskOrders")
public class TaskOrdersController extends BaseController {

    @Autowired
    private TaskOrdersService taskOrdersService;

    /** 视图前缀 */
    private static final String viewPrefix ="taskOrders";
    
    private static final Log LOG = LogFactory.getLog(TaskOrdersController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TaskOrdersQuery query) {
        try {
            List<TaskOrders> dataList = taskOrdersService.queryTaskOrdersListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("taskOrders index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 作业表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 作业表----添加
     * 
     * @param taskOrders
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TaskOrders taskOrders) {
        try {
            taskOrders.setCreateUser(getLoginUserCnName());
            if (taskOrdersService.insert(taskOrders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("taskOrders add fail, exist taskOrders.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("taskOrders add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 作业表----更新跳转
     * 
     * @param model
     * @param taskOrders
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TaskOrders taskOrders) {
        try {
            TaskOrders taskOrdersResult = taskOrdersService.getTaskOrdersById(taskOrders.getId());
            model.addAttribute("taskOrders", taskOrdersResult);
        } catch (Exception e) {
            LOG.error("taskOrders updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 作业表----更新
     * 
     * @param model
     * @param taskOrders
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TaskOrders taskOrders) {
        try {
            taskOrders.setUpdateUser(getLoginUserCnName());
            if (taskOrdersService.update(taskOrders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("taskOrders update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 作业表----删除
     * 
     * @param taskOrders
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TaskOrders taskOrders) {
        try {
            taskOrders.setUpdateUser(getLoginUserCnName());
            if (taskOrdersService.delete(taskOrders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("taskOrders delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 作业表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(TaskOrdersQuery query) {
        try {
            List<TaskOrders> list = taskOrdersService.queryTaskOrdersList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("taskOrders query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询作业表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(TaskOrdersQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            TaskOrders taskOrders = taskOrdersService.getTaskOrdersById(query.getId());
            if (taskOrders != null) {
                return new Wrapper<TaskOrders>().result(taskOrders);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询作业表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail taskOrders has error.", e);
            return error();
        }
    }
}
