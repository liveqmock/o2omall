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
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.OrdersItemsQuery;
import com.awe.order.service.OrdersItemsService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrdersItemsController ：订单明细控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:58:07
*/
@Controller
@RequestMapping("ordersItems")
public class OrdersItemsController extends BaseController {

    @Autowired
    private OrdersItemsService ordersItemsService;

    /** 视图前缀 */
    private static final String viewPrefix ="ordersItems";
    
    private static final Log LOG = LogFactory.getLog(OrdersItemsController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, OrdersItemsQuery query) {
        try {
            List<OrdersItems> dataList = ordersItemsService.queryOrdersItemsListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("ordersItems index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 订单明细----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 订单明细----添加
     * 
     * @param ordersItems
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(OrdersItems ordersItems) {
        try {
            ordersItems.setCreateUser(getLoginUserCnName());
            if (ordersItemsService.insert(ordersItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("ordersItems add fail, exist ordersItems.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("ordersItems add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 订单明细----更新跳转
     * 
     * @param model
     * @param ordersItems
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, OrdersItems ordersItems) {
        try {
            OrdersItems ordersItemsResult = ordersItemsService.getOrdersItemsById(ordersItems.getId());
            model.addAttribute("ordersItems", ordersItemsResult);
        } catch (Exception e) {
            LOG.error("ordersItems updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 订单明细----更新
     * 
     * @param model
     * @param ordersItems
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, OrdersItems ordersItems) {
        try {
            ordersItems.setUpdateUser(getLoginUserCnName());
            if (ordersItemsService.update(ordersItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("ordersItems update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单明细----删除
     * 
     * @param ordersItems
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(OrdersItems ordersItems) {
        try {
            ordersItems.setUpdateUser(getLoginUserCnName());
            if (ordersItemsService.delete(ordersItems)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("ordersItems delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 订单明细----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(OrdersItemsQuery query) {
        try {
            List<OrdersItems> list = ordersItemsService.queryOrdersItemsList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("ordersItems query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询订单明细详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(OrdersItemsQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            OrdersItems ordersItems = ordersItemsService.getOrdersItemsById(query.getId());
            if (ordersItems != null) {
                return new Wrapper<OrdersItems>().result(ordersItems);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询订单明细详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail ordersItems has error.", e);
            return error();
        }
    }
}
