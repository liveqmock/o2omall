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
import com.awe.uc.domain.UserImg;
import com.awe.uc.domain.query.UserImgQuery;
import com.awe.uc.service.UserImgService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * UserImgController ：用户关联图片控制器
 * 
 * @author lijianzhong
 * @version 2014-12-21 9:41:32
*/
@Controller
@RequestMapping("userImg")
public class UserImgController extends BaseController {

    @Autowired
    private UserImgService userImgService;

    /** 视图前缀 */
    private static final String viewPrefix ="userImg";
    
    private static final Log LOG = LogFactory.getLog(UserImgController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, UserImgQuery query) {
        try {
            List<UserImg> dataList = userImgService.queryUserImgListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("userImg index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 用户关联图片----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 用户关联图片----添加
     * 
     * @param userImg
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(UserImg userImg) {
        try {
            userImg.setCreateUser(getLoginUserCnName());
            if (userImgService.insert(userImg)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("userImg add fail, exist userImg.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("userImg add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 用户关联图片----更新跳转
     * 
     * @param model
     * @param userImg
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, UserImg userImg) {
        try {
            UserImg userImgResult = userImgService.getUserImgById(userImg.getId());
            model.addAttribute("userImg", userImgResult);
        } catch (Exception e) {
            LOG.error("userImg updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 用户关联图片----更新
     * 
     * @param model
     * @param userImg
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, UserImg userImg) {
        try {
            userImg.setUpdateUser(getLoginUserCnName());
            if (userImgService.update(userImg)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("userImg update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户关联图片----删除
     * 
     * @param userImg
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(UserImg userImg) {
        try {
            userImg.setUpdateUser(getLoginUserCnName());
            if (userImgService.delete(userImg)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("userImg delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 用户关联图片----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(UserImgQuery query) {
        try {
            List<UserImg> list = userImgService.queryUserImgList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("userImg query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询用户关联图片详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(UserImgQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            UserImg userImg = userImgService.getUserImgById(query.getId());
            if (userImg != null) {
                return new Wrapper<UserImg>().result(userImg);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询用户关联图片详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail userImg has error.", e);
            return error();
        }
    }
}
