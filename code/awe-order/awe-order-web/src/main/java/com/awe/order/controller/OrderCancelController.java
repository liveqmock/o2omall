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
import com.awe.order.domain.OrderCancel;
import com.awe.order.domain.query.OrderCancelQuery;
import com.awe.order.service.OrderCancelService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrderCancelController ：订单取消控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:58:07
*/
@Controller
@RequestMapping("orderCancel")
public class OrderCancelController extends BaseController {

    @Autowired
    private OrderCancelService orderCancelService;

    /** 视图前缀 */
    private static final String viewPrefix ="orderCancel";
    
    private static final Log LOG = LogFactory.getLog(OrderCancelController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, OrderCancelQuery query) {
        try {
            List<OrderCancel> dataList = orderCancelService.queryOrderCancelListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("orderCancel index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 订单取消----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    
    /**
     * 订单取消----添加
     * 
     * @param orderCancel
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(OrderCancel orderCancel) {
        try {
            orderCancel.setCreateUser(getLoginUserCnName());
            if (orderCancelService.insert(orderCancel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("orderCancel add fail, exist orderCancel.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("orderCancel add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 订单取消----更新跳转
     * 
     * @param model
     * @param orderCancel
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, OrderCancel orderCancel) {
        try {
            OrderCancel orderCancelResult = orderCancelService.getOrderCancelById(orderCancel.getId());
            model.addAttribute("orderCancel", orderCancelResult);
        } catch (Exception e) {
            LOG.error("orderCancel updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 订单取消----更新
     * 
     * @param model
     * @param orderCancel
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, OrderCancel orderCancel) {
        try {
            orderCancel.setUpdateUser(getLoginUserCnName());
            if (orderCancelService.update(orderCancel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("orderCancel update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单取消----审核
     * 
     * @param model
     * @param orderCancel
     * @return
     * 1:修改 取消表状态
     * 2:修改订单状态
     * 3:写订单日志
     */
    @RequestMapping(value = "Cancelupdate")
    @ResponseBody
    public Wrapper<?> Cancelupdate(Model model, OrderCancel orderCancel) {
        try {
            orderCancel.setUpdateUser(getLoginUserCnName());
            if (orderCancelService.Cancelupdate(orderCancel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("orderCancel update has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 订单取消----删除
     * 
     * @param orderCancel
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(OrderCancel orderCancel) {
        try {
            orderCancel.setUpdateUser(getLoginUserCnName());
            if (orderCancelService.delete(orderCancel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("orderCancel delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单取消----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(OrderCancelQuery query) {
        try {
            List<OrderCancel> list = orderCancelService.queryOrderCancelList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("orderCancel query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询订单取消详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(OrderCancelQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            OrderCancel orderCancel = orderCancelService.getOrderCancelById(query.getId());
            if (orderCancel != null) {
                return new Wrapper<OrderCancel>().result(orderCancel);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询订单取消详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail orderCancel has error.", e);
            return error();
        }
    }
}
