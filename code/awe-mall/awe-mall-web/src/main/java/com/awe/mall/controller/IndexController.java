package com.awe.mall.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.awe.mall.controller.base.BaseController;

/**
 * 主界面控制器：网站的默认入口
 * 
 * @author ljz
 * @version 2014-12-30 上午10:22:47
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

    private static final String VIEW_INDEX = "index";

    private final Log logger = LogFactory.getLog(this.getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(Model model) {
        return index(model);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("go to index page");
        return VIEW_INDEX;
    }

}
