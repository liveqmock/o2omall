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
import com.awe.rems.domain.ReturnExchangeImage;
import com.awe.rems.domain.query.ReturnExchangeImageQuery;
import com.awe.rems.service.ReturnExchangeImageService;
import com.awe.rems.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * ReturnExchangeImageController ：退换货图片表控制器
 * 
 * @author zyq
 * @version 2014-12-25 9:16:22
*/
@Controller
@RequestMapping("returnExchangeImage")
public class ReturnExchangeImageController extends BaseController {

    @Autowired
    private ReturnExchangeImageService returnExchangeImageService;

    /** 视图前缀 */
    private static final String viewPrefix ="returnExchangeImage";
    
    private static final Log LOG = LogFactory.getLog(ReturnExchangeImageController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, ReturnExchangeImageQuery query) {
        try {
            List<ReturnExchangeImage> dataList = returnExchangeImageService.queryReturnExchangeImageListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("returnExchangeImage index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 退换货图片表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 退换货图片表----添加
     * 
     * @param returnExchangeImage
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(ReturnExchangeImage returnExchangeImage) {
        try {
            returnExchangeImage.setCreateUser(getLoginUserCnName());
            if (returnExchangeImageService.insert(returnExchangeImage)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("returnExchangeImage add fail, exist returnExchangeImage.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("returnExchangeImage add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 退换货图片表----更新跳转
     * 
     * @param model
     * @param returnExchangeImage
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, ReturnExchangeImage returnExchangeImage) {
        try {
            ReturnExchangeImage returnExchangeImageResult = returnExchangeImageService.getReturnExchangeImageById(returnExchangeImage.getId());
            model.addAttribute("returnExchangeImage", returnExchangeImageResult);
        } catch (Exception e) {
            LOG.error("returnExchangeImage updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 退换货图片表----更新
     * 
     * @param model
     * @param returnExchangeImage
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, ReturnExchangeImage returnExchangeImage) {
        try {
            returnExchangeImage.setUpdateUser(getLoginUserCnName());
            if (returnExchangeImageService.update(returnExchangeImage)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchangeImage update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退换货图片表----删除
     * 
     * @param returnExchangeImage
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(ReturnExchangeImage returnExchangeImage) {
        try {
            returnExchangeImage.setUpdateUser(getLoginUserCnName());
            if (returnExchangeImageService.delete(returnExchangeImage)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchangeImage delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 退换货图片表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(ReturnExchangeImageQuery query) {
        try {
            List<ReturnExchangeImage> list = returnExchangeImageService.queryReturnExchangeImageList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("returnExchangeImage query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询退换货图片表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(ReturnExchangeImageQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            ReturnExchangeImage returnExchangeImage = returnExchangeImageService.getReturnExchangeImageById(query.getId());
            if (returnExchangeImage != null) {
                return new Wrapper<ReturnExchangeImage>().result(returnExchangeImage);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询退换货图片表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail returnExchangeImage has error.", e);
            return error();
        }
    }
}
