package com.awe.pay.controller;
   

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

import com.awe.pay.controller.base.BaseController;
import com.awe.pay.domain.Trade;
import com.awe.pay.domain.query.TradeQuery;
import com.awe.pay.service.TradeService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * TradeController ：正向交易控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:27
*/
@Controller
@RequestMapping("trade")
public class TradeController extends BaseController {

    @Autowired
    private TradeService tradeService;

    /** 视图前缀 */
    private static final String viewPrefix ="trade";
    
    private static final Log LOG = LogFactory.getLog(TradeController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TradeQuery query) {
        try {
            List<Trade> dataList = tradeService.queryTradeListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("trade index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 正向交易----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 正向交易----添加
     * 
     * @param trade
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Trade trade) {
        try {
            trade.setCreateUser(getLoginUserCnName());
            if (tradeService.insert(trade)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("trade add fail, exist trade.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("trade add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 正向交易----更新跳转
     * 
     * @param model
     * @param trade
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Trade trade) {
        try {
            Trade tradeResult = tradeService.getTradeById(trade.getId());
            model.addAttribute("trade", tradeResult);
        } catch (Exception e) {
            LOG.error("trade updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 正向交易----更新
     * 
     * @param model
     * @param trade
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Trade trade) {
        try {
            trade.setUpdateUser(getLoginUserCnName());
            if (tradeService.update(trade)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("trade update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 正向交易----删除
     * 
     * @param trade
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Trade trade) {
        try {
            trade.setUpdateUser(getLoginUserCnName());
            if (tradeService.delete(trade)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("trade delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 正向交易----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(TradeQuery query) {
        try {
            List<Trade> list = tradeService.queryTradeList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("trade query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询正向交易详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(TradeQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Trade trade = tradeService.getTradeById(query.getId());
            if (trade != null) {
                return new Wrapper<Trade>().result(trade);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询正向交易详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail trade has error.", e);
            return error();
        }
    }
}
