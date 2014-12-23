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
import com.awe.order.domain.ShoppingCart;
import com.awe.order.domain.query.ShoppingCartQuery;
import com.awe.order.service.ShoppingCartService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ShoppingCartController ：购物车控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:58:07
*/
@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController extends BaseController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /** 视图前缀 */
    private static final String viewPrefix ="shoppingCart";
    
    private static final Log LOG = LogFactory.getLog(ShoppingCartController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ShoppingCartQuery query) {
        try {
            List<ShoppingCart> dataList = shoppingCartService.queryShoppingCartListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("shoppingCart index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 购物车----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 购物车----添加
     * 
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ShoppingCart shoppingCart) {
        try {
            shoppingCart.setCreateUser(getLoginUserCnName());
            if (shoppingCartService.insert(shoppingCart)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("shoppingCart add fail, exist shoppingCart.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("shoppingCart add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 购物车----更新跳转
     * 
     * @param model
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ShoppingCart shoppingCart) {
        try {
            ShoppingCart shoppingCartResult = shoppingCartService.getShoppingCartById(shoppingCart.getId());
            model.addAttribute("shoppingCart", shoppingCartResult);
        } catch (Exception e) {
            LOG.error("shoppingCart updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 购物车----更新
     * 
     * @param model
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ShoppingCart shoppingCart) {
        try {
            shoppingCart.setUpdateUser(getLoginUserCnName());
            if (shoppingCartService.update(shoppingCart)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("shoppingCart update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 购物车----删除
     * 
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ShoppingCart shoppingCart) {
        try {
            shoppingCart.setUpdateUser(getLoginUserCnName());
            if (shoppingCartService.delete(shoppingCart)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("shoppingCart delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 购物车----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ShoppingCartQuery query) {
        try {
            List<ShoppingCart> list = shoppingCartService.queryShoppingCartList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("shoppingCart query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询购物车详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ShoppingCartQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(query.getId());
            if (shoppingCart != null) {
                return new Wrapper<ShoppingCart>().result(shoppingCart);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询购物车详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail shoppingCart has error.", e);
            return error();
        }
    }
}
