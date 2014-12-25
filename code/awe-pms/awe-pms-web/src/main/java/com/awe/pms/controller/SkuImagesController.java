package com.awe.pms.controller;
   

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

import com.awe.pms.controller.base.BaseController;
import com.awe.pms.domain.SkuImages;
import com.awe.pms.domain.query.SkuImagesQuery;
import com.awe.pms.service.SkuImagesService;
import com.awe.pms.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * SkuImagesController ：sku图片控制器
 * 
 * @author ljz
 * @version 2014-12-25 9:31:55
*/
@Controller
@RequestMapping("skuImages")
public class SkuImagesController extends BaseController {

    @Autowired
    private SkuImagesService skuImagesService;

    /** 视图前缀 */
    private static final String viewPrefix ="skuImages";
    
    private static final Log LOG = LogFactory.getLog(SkuImagesController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, SkuImagesQuery query) {
        try {
            List<SkuImages> dataList = skuImagesService.querySkuImagesListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("skuImages index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * sku图片----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * sku图片----添加
     * 
     * @param skuImages
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(SkuImages skuImages) {
        try {
            skuImages.setCreateUser(getLoginUserCnName());
            if (skuImagesService.insert(skuImages)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("skuImages add fail, exist skuImages.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("skuImages add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * sku图片----更新跳转
     * 
     * @param model
     * @param skuImages
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, SkuImages skuImages) {
        try {
            SkuImages skuImagesResult = skuImagesService.getSkuImagesById(skuImages.getId());
            model.addAttribute("skuImages", skuImagesResult);
        } catch (Exception e) {
            LOG.error("skuImages updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * sku图片----更新
     * 
     * @param model
     * @param skuImages
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, SkuImages skuImages) {
        try {
            skuImages.setUpdateUser(getLoginUserCnName());
            if (skuImagesService.update(skuImages)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("skuImages update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * sku图片----删除
     * 
     * @param skuImages
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(SkuImages skuImages) {
        try {
            skuImages.setUpdateUser(getLoginUserCnName());
            if (skuImagesService.delete(skuImages)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("skuImages delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * sku图片----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(SkuImagesQuery query) {
        try {
            List<SkuImages> list = skuImagesService.querySkuImagesList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("skuImages query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询sku图片详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(SkuImagesQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            SkuImages skuImages = skuImagesService.getSkuImagesById(query.getId());
            if (skuImages != null) {
                return new Wrapper<SkuImages>().result(skuImages);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询sku图片详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail skuImages has error.", e);
            return error();
        }
    }
}
