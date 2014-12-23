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
import com.awe.order.domain.Orders;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.service.OrdersService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrdersController ：订单控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
*/
@Controller
@RequestMapping("orders")
public class OrdersController extends BaseController {

    @Autowired
    private OrdersService ordersService;

    /** 视图前缀 */
    private static final String viewPrefix ="orders";
    
    private static final Log LOG = LogFactory.getLog(OrdersController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, OrdersQuery query) {
        try {
            List<Orders> dataList = ordersService.queryOrdersListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("orders index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 订单----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 订单----添加
     * 
     * @param orders
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Orders orders) {
        try {
            orders.setCreateUser(getLoginUserCnName());
            if (ordersService.insert(orders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("orders add fail, exist orders.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("orders add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 订单----更新跳转
     * 
     * @param model
     * @param orders
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Orders orders) {
        try {
            Orders ordersResult = ordersService.getOrdersById(orders.getId());
            model.addAttribute("orders", ordersResult);
        } catch (Exception e) {
            LOG.error("orders updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 订单----更新
     * 
     * @param model
     * @param orders
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Orders orders) {
        try {
            orders.setUpdateUser(getLoginUserCnName());
            if (ordersService.update(orders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("orders update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单----删除
     * 
     * @param orders
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Orders orders) {
        try {
            orders.setUpdateUser(getLoginUserCnName());
            if (ordersService.delete(orders)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("orders delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(OrdersQuery query) {
        try {
            List<Orders> list = ordersService.queryOrdersList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("orders query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询订单详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(OrdersQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Orders orders = ordersService.getOrdersById(query.getId());
            if (orders != null) {
                return new Wrapper<Orders>().result(orders);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询订单详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail orders has error.", e);
            return error();
        }
    }
}
