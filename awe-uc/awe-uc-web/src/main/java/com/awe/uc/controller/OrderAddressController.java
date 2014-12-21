package com.awe.uc.controller;
   

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

import com.awe.uc.controller.base.BaseController;
import com.awe.uc.domain.OrderAddress;
import com.awe.uc.domain.query.OrderAddressQuery;
import com.awe.uc.service.OrderAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrderAddressController ：收货地址表控制器
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:32
*/
@Controller
@RequestMapping("orderAddress")
public class OrderAddressController extends BaseController {

    @Autowired
    private OrderAddressService orderAddressService;

    /** 视图前缀 */
    private static final String viewPrefix ="orderAddress";
    
    private static final Log LOG = LogFactory.getLog(OrderAddressController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, OrderAddressQuery query) {
        try {
            List<OrderAddress> dataList = orderAddressService.queryOrderAddressListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("orderAddress index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 收货地址表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 收货地址表----添加
     * 
     * @param orderAddress
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(OrderAddress orderAddress) {
        try {
            orderAddress.setCreateUser(getLoginUserCnName());
            if (orderAddressService.insert(orderAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("orderAddress add fail, exist orderAddress.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("orderAddress add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 收货地址表----更新跳转
     * 
     * @param model
     * @param orderAddress
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, OrderAddress orderAddress) {
        try {
            OrderAddress orderAddressResult = orderAddressService.getOrderAddressById(orderAddress.getId());
            model.addAttribute("orderAddress", orderAddressResult);
        } catch (Exception e) {
            LOG.error("orderAddress updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 收货地址表----更新
     * 
     * @param model
     * @param orderAddress
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, OrderAddress orderAddress) {
        try {
            orderAddress.setUpdateUser(getLoginUserCnName());
            if (orderAddressService.update(orderAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("orderAddress update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 收货地址表----删除
     * 
     * @param orderAddress
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(OrderAddress orderAddress) {
        try {
            orderAddress.setUpdateUser(getLoginUserCnName());
            if (orderAddressService.delete(orderAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("orderAddress delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 收货地址表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(OrderAddressQuery query) {
        try {
            List<OrderAddress> list = orderAddressService.queryOrderAddressList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("orderAddress query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询收货地址表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(OrderAddressQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            OrderAddress orderAddress = orderAddressService.getOrderAddressById(query.getId());
            if (orderAddress != null) {
                return new Wrapper<OrderAddress>().result(orderAddress);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询收货地址表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail orderAddress has error.", e);
            return error();
        }
    }
}
