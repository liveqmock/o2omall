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
import com.awe.uc.domain.UserAccount;
import com.awe.uc.domain.query.UserAccountQuery;
import com.awe.uc.service.UserAccountService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserAccountController ：用户账号控制器
 * 
 * @author ljz
 * @version 2014-12-23 15:38:39
*/
@Controller
@RequestMapping("userAccount")
public class UserAccountController extends BaseController {

    @Autowired
    private UserAccountService userAccountService;

    /** 视图前缀 */
    private static final String viewPrefix ="userAccount";
    
    private static final Log LOG = LogFactory.getLog(UserAccountController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, UserAccountQuery query) {
        try {
            List<UserAccount> dataList = userAccountService.queryUserAccountListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("userAccount index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 用户账号----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 用户账号----添加
     * 
     * @param userAccount
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(UserAccount userAccount) {
        try {
            userAccount.setCreateUser(getLoginUserCnName());
            if (userAccountService.insert(userAccount)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("userAccount add fail, exist userAccount.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("userAccount add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 用户账号----更新跳转
     * 
     * @param model
     * @param userAccount
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, UserAccount userAccount) {
        try {
            UserAccount userAccountResult = userAccountService.getUserAccountById(userAccount.getId());
            model.addAttribute("userAccount", userAccountResult);
        } catch (Exception e) {
            LOG.error("userAccount updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 用户账号----更新
     * 
     * @param model
     * @param userAccount
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, UserAccount userAccount) {
        try {
            userAccount.setUpdateUser(getLoginUserCnName());
            if (userAccountService.update(userAccount)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("userAccount update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户账号----删除
     * 
     * @param userAccount
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(UserAccount userAccount) {
        try {
            userAccount.setUpdateUser(getLoginUserCnName());
            if (userAccountService.delete(userAccount)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("userAccount delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户账号----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(UserAccountQuery query) {
        try {
            List<UserAccount> list = userAccountService.queryUserAccountList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("userAccount query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询用户账号详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(UserAccountQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            UserAccount userAccount = userAccountService.getUserAccountById(query.getId());
            if (userAccount != null) {
                return new Wrapper<UserAccount>().result(userAccount);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询用户账号详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail userAccount has error.", e);
            return error();
        }
    }
}
