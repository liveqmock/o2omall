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
import com.awe.uc.domain.Area;
import com.awe.uc.domain.query.AreaQuery;
import com.awe.uc.service.AreaService;
import com.awe.uc.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * AreaController ：三级地址控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:46
*/
@Controller
@RequestMapping("area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

    /** 视图前缀 */
    private static final String viewPrefix ="area";
    
    private static final Log LOG = LogFactory.getLog(AreaController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, AreaQuery query) {
        try {
            List<Area> dataList = areaService.queryAreaListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("area index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 三级地址----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 三级地址----添加
     * 
     * @param area
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(Area area) {
        try {
            area.setCreateUser(getLoginUserCnName());
            if (areaService.insert(area)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("area add fail, exist area.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("area add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 三级地址----更新跳转
     * 
     * @param model
     * @param area
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, Area area) {
        try {
            Area areaResult = areaService.getAreaById(area.getId());
            model.addAttribute("area", areaResult);
        } catch (Exception e) {
            LOG.error("area updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 三级地址----更新
     * 
     * @param model
     * @param area
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, Area area) {
        try {
            area.setUpdateUser(getLoginUserCnName());
            if (areaService.update(area)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("area update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 三级地址----删除
     * 
     * @param area
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(Area area) {
        try {
            area.setUpdateUser(getLoginUserCnName());
            if (areaService.delete(area)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("area delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 三级地址----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(AreaQuery query) {
        try {
            List<Area> list = areaService.queryAreaList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("area query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询三级地址详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(AreaQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            Area area = areaService.getAreaById(query.getId());
            if (area != null) {
                return new Wrapper<Area>().result(area);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询三级地址详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail area has error.", e);
            return error();
        }
    }
}
