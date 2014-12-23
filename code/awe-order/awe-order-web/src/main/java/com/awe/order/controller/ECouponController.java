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
import com.awe.order.domain.ECoupon;
import com.awe.order.domain.query.ECouponQuery;
import com.awe.order.service.ECouponService;
import com.awe.order.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ECouponController ：电子券控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
*/
@Controller
@RequestMapping("eCoupon")
public class ECouponController extends BaseController {

    @Autowired
    private ECouponService eCouponService;

    /** 视图前缀 */
    private static final String viewPrefix ="eCoupon";
    
    private static final Log LOG = LogFactory.getLog(ECouponController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ECouponQuery query) {
        try {
            List<ECoupon> dataList = eCouponService.queryECouponListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("eCoupon index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 电子券----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 电子券----添加
     * 
     * @param eCoupon
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ECoupon eCoupon) {
        try {
            eCoupon.setCreateUser(getLoginUserCnName());
            if (eCouponService.insert(eCoupon)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("eCoupon add fail, exist eCoupon.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("eCoupon add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 电子券----更新跳转
     * 
     * @param model
     * @param eCoupon
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ECoupon eCoupon) {
        try {
            ECoupon eCouponResult = eCouponService.getECouponById(eCoupon.getId());
            model.addAttribute("eCoupon", eCouponResult);
        } catch (Exception e) {
            LOG.error("eCoupon updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 电子券----更新
     * 
     * @param model
     * @param eCoupon
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ECoupon eCoupon) {
        try {
            eCoupon.setUpdateUser(getLoginUserCnName());
            if (eCouponService.update(eCoupon)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("eCoupon update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 电子券----删除
     * 
     * @param eCoupon
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ECoupon eCoupon) {
        try {
            eCoupon.setUpdateUser(getLoginUserCnName());
            if (eCouponService.delete(eCoupon)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("eCoupon delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 电子券----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ECouponQuery query) {
        try {
            List<ECoupon> list = eCouponService.queryECouponList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("eCoupon query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询电子券详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ECouponQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ECoupon eCoupon = eCouponService.getECouponById(query.getId());
            if (eCoupon != null) {
                return new Wrapper<ECoupon>().result(eCoupon);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询电子券详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail eCoupon has error.", e);
            return error();
        }
    }
}
