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
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
import com.awe.order.service.OrderLogService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrderLogController ：订单日志控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:58:07
*/
@Controller
@RequestMapping("orderLog")
public class OrderLogController extends BaseController {

    @Autowired
    private OrderLogService orderLogService;

    /** 视图前缀 */
    private static final String viewPrefix ="orderLog";
    
    private static final Log LOG = LogFactory.getLog(OrderLogController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, OrderLogQuery query) {
        try {
            List<OrderLog> dataList = orderLogService.queryOrderLogListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("orderLog index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 订单日志----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 订单日志----添加
     * 
     * @param orderLog
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(OrderLog orderLog) {
        try {
            orderLog.setCreateUser(getLoginUserCnName());
            if (orderLogService.insert(orderLog)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("orderLog add fail, exist orderLog.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("orderLog add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 订单日志----更新跳转
     * 
     * @param model
     * @param orderLog
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, OrderLog orderLog) {
        try {
            OrderLog orderLogResult = orderLogService.getOrderLogById(orderLog.getId());
            model.addAttribute("orderLog", orderLogResult);
        } catch (Exception e) {
            LOG.error("orderLog updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 订单日志----更新
     * 
     * @param model
     * @param orderLog
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, OrderLog orderLog) {
        try {
            orderLog.setUpdateUser(getLoginUserCnName());
            if (orderLogService.update(orderLog)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("orderLog update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单日志----删除
     * 
     * @param orderLog
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(OrderLog orderLog) {
        try {
            orderLog.setUpdateUser(getLoginUserCnName());
            if (orderLogService.delete(orderLog)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("orderLog delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单日志----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(OrderLogQuery query) {
        try {
            List<OrderLog> list = orderLogService.queryOrderLogList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("orderLog query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询订单日志详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(OrderLogQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            OrderLog orderLog = orderLogService.getOrderLogById(query.getId());
            if (orderLog != null) {
                return new Wrapper<OrderLog>().result(orderLog);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询订单日志详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail orderLog has error.", e);
            return error();
        }
    }
}
