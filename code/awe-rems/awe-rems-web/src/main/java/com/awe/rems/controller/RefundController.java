package com.awe.rems.controller;
   

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

import com.awe.rems.controller.base.BaseController;
import com.awe.rems.domain.Refund;
import com.awe.rems.domain.query.RefundQuery;
import com.awe.rems.service.RefundService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * RefundController ：退款表控制器
 * 
 * @author zyq
 * @version 2014-12-25 9:16:22
*/
@Controller
@RequestMapping("refund")
public class RefundController extends BaseController {

    @Autowired
    private RefundService refundService;

    /** 视图前缀 */
    private static final String viewPrefix ="refund";
    
    private static final Log LOG = LogFactory.getLog(RefundController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, RefundQuery query) {
        try {
            List<Refund> dataList = refundService.queryRefundListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("refund index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 退款表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 退款表----添加
     * 
     * @param refund
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Refund refund) {
        try {
            refund.setCreateUser(getLoginUserCnName());
            if (refundService.insert(refund)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("refund add fail, exist refund.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("refund add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 退款表----更新跳转
     * 
     * @param model
     * @param refund
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Refund refund) {
        try {
            Refund refundResult = refundService.getRefundById(refund.getId());
            model.addAttribute("refund", refundResult);
        } catch (Exception e) {
            LOG.error("refund updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 退款表----更新
     * 
     * @param model
     * @param refund
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Refund refund) {
        try {
            refund.setUpdateUser(getLoginUserCnName());
            if (refundService.update(refund)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("refund update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退款表----删除
     * 
     * @param refund
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Refund refund) {
        try {
            refund.setUpdateUser(getLoginUserCnName());
            if (refundService.delete(refund)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("refund delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退款表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(RefundQuery query) {
        try {
            List<Refund> list = refundService.queryRefundList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("refund query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询退款表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(RefundQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Refund refund = refundService.getRefundById(query.getId());
            if (refund != null) {
                return new Wrapper<Refund>().result(refund);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询退款表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail refund has error.", e);
            return error();
        }
    }
}
