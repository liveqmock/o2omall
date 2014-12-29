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
import com.awe.rems.domain.ReturnExchange;
import com.awe.rems.domain.query.ReturnExchangeQuery;
import com.awe.rems.service.ReturnExchangeService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ReturnExchangeController ：退换货控制器
 * 
 * @author zyq
 * @version 2014-12-25 9:16:22
*/
@Controller
@RequestMapping("returnExchange")
public class ReturnExchangeController extends BaseController {

    @Autowired
    private ReturnExchangeService returnExchangeService;

    /** 视图前缀 */
    private static final String viewPrefix ="returnExchange";
    
    private static final Log LOG = LogFactory.getLog(ReturnExchangeController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ReturnExchangeQuery query) {
        try {
            List<ReturnExchange> dataList = returnExchangeService.queryReturnExchangeListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("returnExchange index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 退换货----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 退换货----添加
     * 
     * @param returnExchange
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ReturnExchange returnExchange) {
        try {
            returnExchange.setCreateUser(getLoginUserCnName());
            if (returnExchangeService.insert(returnExchange)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("returnExchange add fail, exist returnExchange.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("returnExchange add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 退换货----更新跳转
     * 
     * @param model
     * @param returnExchange
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ReturnExchange returnExchange) {
        try {
            ReturnExchange returnExchangeResult = returnExchangeService.getReturnExchangeById(returnExchange.getId());
            model.addAttribute("returnExchange", returnExchangeResult);
        } catch (Exception e) {
            LOG.error("returnExchange updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 退换货----更新
     * 
     * @param model
     * @param returnExchange
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ReturnExchange returnExchange) {
        try {
            returnExchange.setUpdateUser(getLoginUserCnName());
            if (returnExchangeService.update(returnExchange)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchange update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退换货----删除
     * 
     * @param returnExchange
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ReturnExchange returnExchange) {
        try {
            returnExchange.setUpdateUser(getLoginUserCnName());
            if (returnExchangeService.delete(returnExchange)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchange delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退换货----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ReturnExchangeQuery query) {
        try {
            List<ReturnExchange> list = returnExchangeService.queryReturnExchangeList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchange query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询退换货详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ReturnExchangeQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ReturnExchange returnExchange = returnExchangeService.getReturnExchangeById(query.getId());
            if (returnExchange != null) {
                return new Wrapper<ReturnExchange>().result(returnExchange);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询退换货详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail returnExchange has error.", e);
            return error();
        }
    }
}
