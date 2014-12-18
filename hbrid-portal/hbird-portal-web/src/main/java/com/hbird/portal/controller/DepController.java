package com.hbird.portal.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbird.common.utils.page.PaginatedArrayList;
import com.hbird.portal.controller.base.BaseController;
import com.hbird.portal.domain.Dep;
import com.hbird.portal.domain.query.DepQuery;
import com.hbird.portal.service.DepService;
import com.hbird.portal.web.util.JsonReader;
import com.hbird.portal.web.util.JsonResult;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-9 下午01:56:26
 */
@Controller
@RequestMapping("/dep")
public class DepController extends BaseController {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private DepService depService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        this.logger.debug("dep --> index");
        // initDateTimePicker(model);
        return "dep/index";
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryList(@RequestParam Map<String, Object> paramMap, DepQuery depQuery) {
        this.logger.debug("dep --> queryList" + paramMap);
        String currPageStr = (String) paramMap.get("page");
        int currPage = 1;
        if (StringUtils.isNotBlank(currPageStr)) {
            currPage = Integer.valueOf(currPageStr);
        }
        String rowsStr = (String) paramMap.get("rows");
        int rows = 0;
        if (StringUtils.isNotBlank(rowsStr)) {
            rows = Integer.valueOf(rowsStr);
        }
        JsonReader result = new JsonReader(currPage);
        try {
            PaginatedArrayList<Dep> deps = this.depService.queryDepListWithPage(depQuery, currPage, rows);
            result.setPaginatedData(deps);

        } catch (Exception e) {
            this.logger.error("dep --> queryList 查询数据异常:", e);
            result.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/queryBeanList", method = RequestMethod.POST)
    @ResponseBody
    public JsonReader queryBeanList(DepQuery depQuery) {
        this.logger.debug("dep --> queryBeanList " + depQuery);
        JsonReader result = new JsonReader(1);
        try {
            PaginatedArrayList<Dep> deps = this.depService.queryDepListWithPage(null, 1, 10);
            result.setPaginatedData(deps);

        } catch (Exception e) {
            this.logger.error("dep --> queryBeanList 查询数据异常:", e);
            result.setCode(JsonResult.CODE_SERVER_ERROR);
        }
        return result;
    }
}
