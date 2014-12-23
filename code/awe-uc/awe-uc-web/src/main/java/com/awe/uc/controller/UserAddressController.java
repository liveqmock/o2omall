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
import com.awe.uc.domain.UserAddress;
import com.awe.uc.domain.query.UserAddressQuery;
import com.awe.uc.service.UserAddressService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserAddressController ：收货地址控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
*/
@Controller
@RequestMapping("userAddress")
public class UserAddressController extends BaseController {

    @Autowired
    private UserAddressService userAddressService;

    /** 视图前缀 */
    private static final String viewPrefix ="userAddress";
    
    private static final Log LOG = LogFactory.getLog(UserAddressController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, UserAddressQuery query) {
        try {
            List<UserAddress> dataList = userAddressService.queryUserAddressListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("userAddress index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 收货地址----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 收货地址----添加
     * 
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(UserAddress userAddress) {
        try {
            userAddress.setCreateUser(getLoginUserCnName());
            if (userAddressService.insert(userAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("userAddress add fail, exist userAddress.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("userAddress add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 收货地址----更新跳转
     * 
     * @param model
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, UserAddress userAddress) {
        try {
            UserAddress userAddressResult = userAddressService.getUserAddressById(userAddress.getId());
            model.addAttribute("userAddress", userAddressResult);
        } catch (Exception e) {
            LOG.error("userAddress updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 收货地址----更新
     * 
     * @param model
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, UserAddress userAddress) {
        try {
            userAddress.setUpdateUser(getLoginUserCnName());
            if (userAddressService.update(userAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("userAddress update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 收货地址----删除
     * 
     * @param userAddress
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(UserAddress userAddress) {
        try {
            userAddress.setUpdateUser(getLoginUserCnName());
            if (userAddressService.delete(userAddress)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("userAddress delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 收货地址----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(UserAddressQuery query) {
        try {
            List<UserAddress> list = userAddressService.queryUserAddressList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("userAddress query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询收货地址详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(UserAddressQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            UserAddress userAddress = userAddressService.getUserAddressById(query.getId());
            if (userAddress != null) {
                return new Wrapper<UserAddress>().result(userAddress);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询收货地址详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail userAddress has error.", e);
            return error();
        }
    }
}
