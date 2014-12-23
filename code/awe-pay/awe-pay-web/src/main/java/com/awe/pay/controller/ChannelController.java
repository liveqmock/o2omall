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
import com.awe.pay.domain.Channel;
import com.awe.pay.domain.query.ChannelQuery;
import com.awe.pay.service.ChannelService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ChannelController ：支付通道控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:27
*/
@Controller
@RequestMapping("channel")
public class ChannelController extends BaseController {

    @Autowired
    private ChannelService channelService;

    /** 视图前缀 */
    private static final String viewPrefix ="channel";
    
    private static final Log LOG = LogFactory.getLog(ChannelController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ChannelQuery query) {
        try {
            List<Channel> dataList = channelService.queryChannelListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("channel index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 支付通道----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 支付通道----添加
     * 
     * @param channel
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Channel channel) {
        try {
            channel.setCreateUser(getLoginUserCnName());
            if (channelService.insert(channel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("channel add fail, exist channel.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("channel add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 支付通道----更新跳转
     * 
     * @param model
     * @param channel
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Channel channel) {
        try {
            Channel channelResult = channelService.getChannelById(channel.getId());
            model.addAttribute("channel", channelResult);
        } catch (Exception e) {
            LOG.error("channel updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 支付通道----更新
     * 
     * @param model
     * @param channel
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Channel channel) {
        try {
            channel.setUpdateUser(getLoginUserCnName());
            if (channelService.update(channel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("channel update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 支付通道----删除
     * 
     * @param channel
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Channel channel) {
        try {
            channel.setUpdateUser(getLoginUserCnName());
            if (channelService.delete(channel)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("channel delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 支付通道----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ChannelQuery query) {
        try {
            List<Channel> list = channelService.queryChannelList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("channel query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询支付通道详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ChannelQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Channel channel = channelService.getChannelById(query.getId());
            if (channel != null) {
                return new Wrapper<Channel>().result(channel);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询支付通道详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail channel has error.", e);
            return error();
        }
    }
}
