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
import com.awe.uc.domain.UserCommonly;
import com.awe.uc.domain.query.UserCommonlyQuery;
import com.awe.uc.service.UserCommonlyService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserCommonlyController ：用户-常用信息控制器
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:32
*/
@Controller
@RequestMapping("userCommonly")
public class UserCommonlyController extends BaseController {

    @Autowired
    private UserCommonlyService userCommonlyService;

    /** 视图前缀 */
    private static final String viewPrefix ="userCommonly";
    
    private static final Log LOG = LogFactory.getLog(UserCommonlyController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, UserCommonlyQuery query) {
        try {
            List<UserCommonly> dataList = userCommonlyService.queryUserCommonlyListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("userCommonly index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 用户-常用信息----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 用户-常用信息----添加
     * 
     * @param userCommonly
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(UserCommonly userCommonly) {
        try {
            userCommonly.setCreateUser(getLoginUserCnName());
            if (userCommonlyService.insert(userCommonly)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("userCommonly add fail, exist userCommonly.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("userCommonly add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 用户-常用信息----更新跳转
     * 
     * @param model
     * @param userCommonly
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, UserCommonly userCommonly) {
        try {
            UserCommonly userCommonlyResult = userCommonlyService.getUserCommonlyById(userCommonly.getId());
            model.addAttribute("userCommonly", userCommonlyResult);
        } catch (Exception e) {
            LOG.error("userCommonly updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 用户-常用信息----更新
     * 
     * @param model
     * @param userCommonly
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, UserCommonly userCommonly) {
        try {
            userCommonly.setUpdateUser(getLoginUserCnName());
            if (userCommonlyService.update(userCommonly)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("userCommonly update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户-常用信息----删除
     * 
     * @param userCommonly
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(UserCommonly userCommonly) {
        try {
            userCommonly.setUpdateUser(getLoginUserCnName());
            if (userCommonlyService.delete(userCommonly)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("userCommonly delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户-常用信息----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(UserCommonlyQuery query) {
        try {
            List<UserCommonly> list = userCommonlyService.queryUserCommonlyList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("userCommonly query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询用户-常用信息详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(UserCommonlyQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            UserCommonly userCommonly = userCommonlyService.getUserCommonlyById(query.getId());
            if (userCommonly != null) {
                return new Wrapper<UserCommonly>().result(userCommonly);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询用户-常用信息详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail userCommonly has error.", e);
            return error();
        }
    }
}
