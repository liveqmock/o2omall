package com.hbird.portal.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;
import com.hbird.portal.domain.Resource;
import com.hbird.portal.domain.constant.CommonConstants;
import com.hbird.portal.sdk.api.request.ResourceRequest;
import com.hbird.portal.sdk.api.response.dto.ResourceDto;
import com.hbird.portal.service.ResourceService;

/**
 * @author zhc
 * @email zhc@hbird.com
 * @version 2014-4-19 下午12:53:32
 */
@Component
@Path(CommonConstants.REST_URL)
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class ResourceResource {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private ResourceService resourceService;

    @POST
    @Path("/resources/getResourceCodes")
    public Wrapper<List<ResourceDto>> getResourceCodes(ResourceRequest request) {
        if (null == request || null == request.getSystemId() || null == request.getUserName()) {
            this.logger.error("resources --> getResourceCodes 传入参数有误！");
            return WrapMapper.illegalArgument();
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userName", request.getUserName());
        paramMap.put("systemId", request.getSystemId());

        try {
            this.logger.info("resources --> getResourceCodes 查询资源开始，paramMap【" + paramMap + "】");
            List<Resource> resources = this.resourceService.queryResourceList(paramMap);
            this.logger.info("resources --> getResourceCodes 查询资源结束，paramMap：【" + paramMap + "】， resources 【"
                    + resources + "】");

            List<ResourceDto> list = convert(resources);
            return new Wrapper<List<ResourceDto>>().result(list);
        } catch (Exception e) {
            this.logger.error("resources --> getResourceCodes 查询资源异常", e);
            return WrapMapper.error();
        }
    }

    // 数据转换
    private List<ResourceDto> convert(List<Resource> resources) {
        if (CollectionUtils.isEmpty(resources)) {
            return null;
        }

        List<ResourceDto> list = new ArrayList<ResourceDto>(resources.size());
        for (Resource resource : resources) {
            ResourceDto response = new ResourceDto();
            BeanUtils.copyProperties(resource, response);
            list.add(response);
        }
        return list;
    }

}
