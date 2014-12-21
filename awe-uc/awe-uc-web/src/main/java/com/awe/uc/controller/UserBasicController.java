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
import com.awe.uc.domain.UserBasic;
import com.awe.uc.domain.query.UserBasicQuery;
import com.awe.uc.service.UserBasicService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserBasicController ：用户基本信息控制器
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:32
*/
@Controller
@RequestMapping("userBasic")
public class UserBasicController extends BaseController {

    @Autowired
    private UserBasicService userBasicService;

    /** 视图前缀 */
    private static final String viewPrefix ="userBasic";
    
    private static final Log LOG = LogFactory.getLog(UserBasicController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, UserBasicQuery query) {
        try {
            List<UserBasic> dataList = userBasicService.queryUserBasicListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("userBasic index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 用户基本信息----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 用户基本信息----添加
     * 
     * @param userBasic
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(UserBasic userBasic) {
        try {
            userBasic.setCreateUser(getLoginUserCnName());
            if (userBasicService.insert(userBasic)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("userBasic add fail, exist userBasic.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("userBasic add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 用户基本信息----更新跳转
     * 
     * @param model
     * @param userBasic
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, UserBasic userBasic) {
        try {
            UserBasic userBasicResult = userBasicService.getUserBasicById(userBasic.getId());
            model.addAttribute("userBasic", userBasicResult);
        } catch (Exception e) {
            LOG.error("userBasic updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 用户基本信息----更新
     * 
     * @param model
     * @param userBasic
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, UserBasic userBasic) {
        try {
            userBasic.setUpdateUser(getLoginUserCnName());
            if (userBasicService.update(userBasic)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("userBasic update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户基本信息----删除
     * 
     * @param userBasic
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(UserBasic userBasic) {
        try {
            userBasic.setUpdateUser(getLoginUserCnName());
            if (userBasicService.delete(userBasic)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("userBasic delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户基本信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(UserBasicQuery query) {
        try {
            List<UserBasic> list = userBasicService.queryUserBasicList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("userBasic query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询用户基本信息详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(UserBasicQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            UserBasic userBasic = userBasicService.getUserBasicById(query.getId());
            if (userBasic != null) {
                return new Wrapper<UserBasic>().result(userBasic);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询用户基本信息详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail userBasic has error.", e);
            return error();
        }
    }
}
